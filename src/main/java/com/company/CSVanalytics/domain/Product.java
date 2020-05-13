package com.company.CSVanalytics.domain;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class Product {

    @CsvBindByName
    private int id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String condition;
    @CsvBindByName
    private String state;
    @CsvBindByName
    private float price;

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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Float.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(condition, product.condition) &&
                Objects.equals(state, product.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, condition, state, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", condition='" + condition + '\'' +
                ", state='" + state + '\'' +
                ", price=" + price +
                '}';
    }
}
