package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue // 시퀀스 , 스퀀스 자동입력
    @Column(name = "order_id") // 데이터베이스 테이블명으로 바꿔줄려고 씀
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 다대1
    @JoinColumn(name = "member_id") //맵핑을 뭘로 할건지 정하기 위해 씀
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private  Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    private OrderStatus status; //주문상태 [ORDER, CANCEL]




}
