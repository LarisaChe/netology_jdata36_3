package ru.netology.model;

import java.util.Date;

public class Order {
    private int id;
    private Date dat;
    private int customer_id;
    private String product_name;
    private float amount;

    public Order(int id, Date dat, int customer_id, String product_name, float amount) {
        this.id = id;
        this.dat = dat;
        this.customer_id = customer_id;
        this.product_name = product_name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Date getDat() {
        return dat;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dat=" + dat +
                ", customer_id=" + customer_id +
                ", product_name='" + product_name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
