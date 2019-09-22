package com.pe.delicias.order;

import android.content.Context;

import com.pe.delicias.order.model.Order;

import java.util.LinkedList;
import java.util.List;

public class OrderSingleton {

    private List<Order> orders;
    private double priceTotal;
    private static OrderSingleton INSTANCE;
    private Context context;

    public OrderSingleton(Context context) {
        this.context = context;
        this.orders=new LinkedList<>();
    }

    public static OrderSingleton getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new OrderSingleton(context);
        }
        return INSTANCE;
    }

    public void addOrder(Order order) {
        this.priceTotal=priceTotal+order.getTotal();
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void removeAllOrders() {
        this.orders = new LinkedList<>();
    }

    public double getPriceTotal() {
        return priceTotal;
    }
}