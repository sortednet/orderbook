package westpac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBookImpl implements OrderBook {


    private OrdersForSide bidOrders = new OrdersForSide(true);
    private OrdersForSide askOrders = new OrdersForSide(false);

    private Map<Long, OrdersForSide> orderIdToOrdersForSide = new HashMap<>();

    @Override
    public void addOrder(Order order) {

        char side = order.getSide();
        OrdersForSide orders = getOrdersForSide(side);
        orders.addOrder(order);
        orderIdToOrdersForSide.put(order.getId(), orders);
    }

    @Override
    public void removeOrder(long orderId) {
        OrdersForSide orders = orderIdToOrdersForSide.get(orderId);
        orders.removeOrder(orderId);
    }

    @Override
    public void modifyOrder(long orderId, long size) {
        OrdersForSide orders = orderIdToOrdersForSide.get(orderId);
        orders.modifyOrder(orderId, size);
    }

    @Override
    public double getPriceAtLevel(char side, int level) {
        OrdersForSide orders = getOrdersForSide(side);
        return orders.getPriceAtLevel(level);
    }

    @Override
    public long getSizeAtLevel(char side, int level) {
        OrdersForSide orders = getOrdersForSide(side);
        return orders.getSizeAtLevel(level);
    }

    @Override
    public List<Order> getAllOrdersForSide(char side) {

        OrdersForSide orders = getOrdersForSide(side);
        return orders.getOrdersByLevelAndTime();
    }

    private OrdersForSide getOrdersForSide(char side) {
        if (side == Order.BID) {
            return bidOrders;
        } else {
            return askOrders;
        }
    }
}
