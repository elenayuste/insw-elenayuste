package com.example.insw.model;

import java.util.List;

public class Order {
    private String id;
    private List<Article> articulos;

    public Order(String id, List<Article> articulos) {
        this.id = id;
        this.articulos = articulos;
    }

        public Order() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Article> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Article> articulos) {
        this.articulos = articulos;
    }

    public double getGrossTotal() {
        double gross = 0;

        for (int i = 0; i < this.articulos.size(); i++) {
            gross += articulos.get(i).getGrossAmount();

        }

        return gross;

    }

    public double getDiscountedTotal() {
        double discount = 0;

        for (int i = 0; i < this.articulos.size(); i++) {
            discount += articulos.get(i).getDiscountedAmount();

        }

        return discount;

    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", articulos=" + articulos + ", getId()=" + getId() + ", getArticulos()="
                + getArticulos() + ", getGrossTotal()=" + getGrossTotal() + ", getDiscountedTotal()="
                + getDiscountedTotal() + ", toString()=" + super.toString() + "]";
    }

}
