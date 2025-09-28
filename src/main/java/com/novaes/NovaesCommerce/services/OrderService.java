/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.novaes.NovaesCommerce.services;

import com.novaes.NovaesCommerce.dto.OrderDTO;
import com.novaes.NovaesCommerce.dto.OrderItemDTO;
import com.novaes.NovaesCommerce.entities.Order;
import com.novaes.NovaesCommerce.entities.OrderItem;
import com.novaes.NovaesCommerce.entities.OrderStatus;
import com.novaes.NovaesCommerce.entities.Product;
import com.novaes.NovaesCommerce.entities.User;
import com.novaes.NovaesCommerce.repositories.OrderItemRepository;
import com.novaes.NovaesCommerce.repositories.OrderRepository;
import com.novaes.NovaesCommerce.repositories.ProductRepository;
import com.novaes.NovaesCommerce.services.exceptions.ResourceNotFoundException;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author blnov
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);
        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }
        
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());
        return new OrderDTO(order);
    }
}
