package com.example.insw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.insw.Main;
import com.example.insw.model.Order;
import com.example.insw.Searcher;
import com.example.insw.view.OrderView;

public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    // Atributo de clase OrderView
    OrderView view;
    // Lista de orders
    List<Order> orders;
    // Atributo de clase Searcher
    Searcher searcher;

    public OrderController(OrderView view, List<Order> orders) {
        // Initialize attributes
        this.view = view;
        this.orders = orders;
        this.searcher = new Searcher();

        // Adding action listener to the search button, call searchOrder on click
        // ...
        view.getSearchButton().addActionListener(e -> searchOrder());
    }

    private void searchOrder() {
        String id = view.getSearchId();

        // ... display order if found, else display "Order not found."
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                view.displayOrder(order, 1.16);
                return;
            }
        }

        view.displayOrder(null, 1.16);
    }
}
