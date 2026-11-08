package com.example.insw.view;

import javax.swing.*;
import com.example.insw.model.Order;
import java.awt.*;

public class OrderView extends JFrame {
    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(10, 40);

    public OrderView() {
        setTitle("Order Management");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // add new JLabel("Order ID:");
        add(new JLabel("Order ID:"));

        // add to view the search field
        add(searchField);
        // add to view the search button
        add(searchButton);
        // add to view the result area inside a JScrollPane
        add(new JScrollPane(resultArea));

        pack();
        setVisible(true);
    }

    public String getSearchId() {
        // ...
        return searchField.getText();
    }

    public JButton getSearchButton() {
        // ...
        return searchButton;
    }

    public void displayOrder(Order order, double rate) {
        // Display order details in resultArea
        if (order != null) {
            String resultado = order.toString();

            resultado += "Gross total (USD): " + order.getGrossTotal() * rate + "$\n";
            resultado += "Discounted total (USD): " + order.getDiscountedTotal() * rate + "$\n";

            resultArea.setText(resultado);
        } else {
            resultArea.setText("Order not found.");
        }
    }
}
