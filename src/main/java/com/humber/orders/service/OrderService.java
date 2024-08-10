package com.humber.orders.service;


import org.springframework.stereotype.Service;

import com.humber.orders.kafka.KafkaProducer;
import com.humber.orders.kafka.OrderPlacedEvent;
import com.humber.orders.model.Order;
import com.humber.orders.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final KafkaProducer kafkaProducer;

    public OrderService(OrderRepository orderRepository, KafkaProducer kafkaProducer) {
        this.orderRepository = orderRepository;
        this.kafkaProducer = kafkaProducer;
    }

    public Order placeOrder(Order order) {
        Order savedOrder = orderRepository.save(order);

        // 
        OrderPlacedEvent event = new OrderPlacedEvent();
        event.setOrderId(savedOrder.getId());
        event.setOrderItems(savedOrder.getOrderItems());

        kafkaProducer.publishOrderPlacedEvent(event);

        return savedOrder;
    }
}

