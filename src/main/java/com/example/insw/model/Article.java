package com.example.insw.model;

import com.example.insw.Calculator;

public class Article {
    private String nombre;
    private int cantidad;
    private double precio;
    private double descuento;

    public Article(String nombre, int cantidad, double precio, double descuento) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getGrossAmount(){
        Calculator calculator = new Calculator();

        double cantidad = calculator.multiply(this.cantidad, this.precio);

        return cantidad;
    }

    public double getDiscountedAmount(){
        Calculator calculator = new Calculator();

        double descuento = calculator.discount(getGrossAmount(), this.descuento);

        return descuento;
    }    
    
}
