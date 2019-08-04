/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author thuongnnse05095
 */
public class Menu {

    private int id;
    private String name;
    private String content;
    private double price;

    public Menu() {

    }

    public Menu(int id, String name, String content, double price) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name=" + name + ", content=" + content + ", price=" + price + '}';
    }

    
}
