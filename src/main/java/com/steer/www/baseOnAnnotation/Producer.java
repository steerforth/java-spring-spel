package com.steer.www.baseOnAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * SPEL list,map操作
 */
@Component("producer")
public class Producer {
    @Value("#{testBean.map['MapA']}")
    private String mapA;
    @Value("#{testBean.list[0]}")
    private String listA;

    @Override
    public String toString() {
        return "Producer{" +
                "mapA='" + mapA + '\'' +
                ", listA='" + listA + '\'' +
                '}';
    }
}
