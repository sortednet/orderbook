package net.sorted;

import java.util.List;

public interface OrderBook {

    void addOrder(Order order);

    void removeOrder(long orderId);

    void modifyOrder(long orderId, long size);

    double getPriceAtLevel(char side, int level);

    long getSizeAtLevel(char side, int level);

    List<Order> getAllOrdersForSide(char side);
}
