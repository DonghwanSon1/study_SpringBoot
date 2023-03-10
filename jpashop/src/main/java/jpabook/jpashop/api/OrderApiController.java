package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;

    /**
     * orderItem , item 관계를 직접 초기화하면 Hibernate5Module 설정에 의해 엔티티를 JSON으로 생성한다.
     * 양방향 연관관계면 무한 루프에 걸리지 않게 한곳에 @JsonIgnore 를 추가해야 한다.
     * 엔티티를 직접 노출하므로 좋은 방법은 아니다.
     */
    @GetMapping("/api/v1/orders")
    public List<Order> orderV1 () {
        List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName();
            order.getDelivery().getAddress();

            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o -> o.getItem().getName());
        }
        return all;
    }

    /**
     * 지연 로딩으로 너무 많은 SQL 실행
     * SQL 실행 수
     *  - order 1번
     *  - member , address N번(order 조회 수 만큼)
     *  - orderItem N번(order 조회 수 만큼)
     *  - item N번(orderItem 조회 수 만큼)
     * > 참고: 지연 로딩은 영속성 컨텍스트에 있으면 영속성 컨텍스트에 있는 엔티티를 사용하고 없으면 SQL을 실행한다.
     *        따라서 같은 영속성 컨텍스트에서 이미 로딩한 회원 엔티티를 추가로 조회하면 SQL을 실행하지 않는다.
     */
    @GetMapping("/api/v2/orders")
    public List<OrderDto> orderV2(){
        List<Order> orders = orderRepository.findAllByCriteria(new OrderSearch());
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * 페치 조인으로 SQL이 1번만 실행됨
     * distinct 를 사용한 이유는 1대다 조인이 있으므로 데이터베이스 row가 증가한다.
     * 그 결과 같은 order 엔티티의 조회 수도 증가하게 된다.
     * JPA의 distinct는 SQL에 distinct를 추가하고,
     * 더해서 같은 엔티티가 조회되면, 애플리케이션에서 중복을 걸러준다.
     * 이 예에서 order가 컬렉션 페치 조인 때문에 중복 조회 되는것을 막아준다.
     * - 단점
     *   - ** 페이징 불가능 **
     * > 참고: 컬렉션 페치 조인을 사용하면 페이징이 불가능하다.
     *        하이버네이트는 경고 로그를 남기면서 모든 데이터를 DB에서 읽어오고,
     *        메모리에서 페이징 해버린다(매우 위험하다).
     *        자세한 내용은 자바 ORM 표준 JPA 프로그래밍의 페치 조인 부분을 참고하자.
     * > 참고: 컬렉션 페치 조인은 1개만 사용할 수 있다.
     *        컬렉션 둘 이상에 페치 조인을 사용하면 안된다.
     *        데이터가 부정합하게 조회될 수 있다.
     *        자세한 내용은 자바 ORM 표준 JPA 프로그래밍을 참고하자.
     */
    @GetMapping("/api/v3/orders")
    public List<OrderDto> orderV3(){
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> result = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * - 페이징과 한계 돌파
     *  컬렉션을 페치 조인하면 페이징이 불가능하다.
     *      컬렉션을 페치 조인하면 일대다 조인이 발생하므로 데이터가 예측할 수 없이 증가한다.
     *      일다대에서 일(1)을 기준으로 페이징을 하는 것이 목적이다.
     *      그런데 데이터는 다(N)를 기준으로 row가 생성된다.
     *      Order를 기준으로 페이징 하고 싶은데, 다(N)인 OrderItem을 조인하면 OrderItem이 기준이 되어버린다.
     *
     * 이 경우 하이버네이트는 경고 로그를 남기고 모든 DB 데이터를 읽어서 메모리에서 페이징을 시도한다.
     * 최악의 경우 장애로 이어질 수 있다.
     *
     * - 한계 돌파
     *  페이징 + 컬렉션 엔티티를 함께 조회하는 방법
     *      먼저 ToOne(OneToOne, ManyToOne) 관계를 모두 페치조인 한다.
     *      ToOne 관계는 row수를 증가시키지 않으므로 페이징 쿼리에 영향을 주지 않는다.
     *      컬렉션은 지연 로딩으로 조회한다.
     *      지연 로딩 성능 최적화를 위해 hibernate.default_batch_fetch_size , @BatchSize 를 적용한다.
     *      - hibernate.default_batch_fetch_size: 글로벌 설정
     *      - @BatchSize: 개별 최적화
     *      이 옵션을 사용하면 컬렉션이나, 프록시 객체를 한꺼번에 설정한 size 만큼 IN 쿼리로 조회한다.
     */

    @Getter
    static class OrderDto {

        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;
        private List<OrderItemDto> orderItems;

        public OrderDto(Order order){
            orderId = order.getId();
            name = order.getMember().getName();
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress();
            orderItems = order.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDto(orderItem))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    static class OrderItemDto {

        private String itemName; // 상품명
        private int orderPrice; // 주문 가격
        private int count; // 주문 수량
        public OrderItemDto(OrderItem orderItem) {
            itemName = orderItem.getItem().getName();
            orderPrice = orderItem.getTotalPrice();
            count = orderItem.getCount();
        }
    }





}
