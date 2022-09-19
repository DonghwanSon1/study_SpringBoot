package hello.core.order;

import com.sun.org.apache.xpath.internal.operations.Or;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);


}
