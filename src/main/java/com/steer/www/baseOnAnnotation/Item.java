package com.steer.www.baseOnAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * SPEL 获取字符串，数字
 */
@Component("item")
public class Item {
    @Value("itemA")
    private String name;
    @Value("10")
    private int total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", total=" + total +
                '}';
    }
}
