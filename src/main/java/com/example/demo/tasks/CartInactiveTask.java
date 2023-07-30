package com.example.demo.tasks;

import com.example.demo.models.Cart;
import com.example.demo.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CartInactiveTask {

    @Autowired
    private CartRepository cartRepository;

    @Scheduled(fixedRate = 600000)
    public void deleteInactiveCarts() {
        LocalDateTime tenMinutes = LocalDateTime.now().minusMinutes(10);
        List<Cart> cartsInactives = cartRepository.findByLastActiveDateTimeBefore(tenMinutes);
        cartRepository.deleteAll(cartsInactives);
    }
}
