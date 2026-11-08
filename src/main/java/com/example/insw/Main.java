package com.example.insw;

import java.io.InputStream;
import java.util.List;

import com.example.insw.controller.OrderController;
import com.example.insw.model.*;
import com.example.insw.view.OrderView;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ObjectMapper lector = new ObjectMapper();

        try {
            List<Order> orders = lector.readValue(
                    Main.class.getResourceAsStream("/orders.json"),
                    new TypeReference<List<Order>>() {
                    });

            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                log.debug("Loaded order: {}", order.getId());
            }

            // Initialize MVC
            OrderView view = new OrderView();
            new OrderController(view, orders);

        } catch (Exception e) {
            // TODO: handle exception
            log.error("Error al leer el fichero", e);
        }

    }
}