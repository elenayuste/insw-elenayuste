package com.example.insw.model;

import com.example.insw.Calculator;

public class Article {
    private String name;
    private int quantity;
    private double unitPrice;
    private double discount;

    public Article(String name, int quantity, double unitPrice, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public Article() {

    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getGrossAmount() {
        Calculator calculator = new Calculator();

        double cantidad = calculator.multiply(this.quantity, this.unitPrice);

        return cantidad;
    }

    public double getDiscountedAmount() {
        Calculator calculator = new Calculator();

        double descuento = calculator.discount(getGrossAmount(), this.discount);

        return descuento;
    }

}
