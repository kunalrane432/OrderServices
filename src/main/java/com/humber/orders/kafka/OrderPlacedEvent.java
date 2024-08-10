package com.humber.orders.kafka;

import java.util.List;

import com.humber.orders.model.OrderItem;



public class OrderPlacedEvent {
    private Long orderId;
    private List<OrderItem> orderItems;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

    
}
