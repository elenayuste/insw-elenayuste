package com.example.insw.model;

import java.util.List;

public class Order {
    private String id;
    private List<Article> articles;

    public Order(String id, List<Article> articles) {
        this.id = id;
        this.articles = articles;
    }

    public Order() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public double getGrossTotal() {
        double gross = 0;

        for (int i = 0; i < this.articles.size(); i++) {
            gross += articles.get(i).getGrossAmount();

        }

        return gross;

    }

    public double getDiscountedTotal() {
        double discount = 0;

        for (int i = 0; i < this.articles.size(); i++) {
            discount += articles.get(i).getDiscountedAmount();

        }

        return discount;

    }

    @Override
    public String toString() {
        String resultado = "Order " + id + ":\n";

        for (Article articulo : articles) {
            resultado += articulo.getName()
                    + " x" + articulo.getQuantity()
                    + " @ " + articulo.getUnitPrice() + "$"
                    + " (discount " + articulo.getDiscount() + "%)"
                    + " = " + articulo.getDiscountedAmount() + "$\n";
        }

        resultado += "Gross total: " + getGrossTotal() + "$\n";
        resultado += "Discounted total: " + getDiscountedTotal() + "$\n";

        return resultado;
    }

}
