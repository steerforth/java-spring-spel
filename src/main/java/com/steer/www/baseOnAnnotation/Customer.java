package com.steer.www.baseOnAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * SPEL 获取对象，对象属性，获取对象的方法
 */
@Component("customer")
public class Customer {
    @Value("#{item}")
    private Item item;
    @Value("#{item.name}")
    private String itemName;
    @Value("#{price.getSpecialPrice()}")
    private double amount;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "item=" + item +
                ", itemName='" + itemName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
