package com.steer.www.baseOnAnnotation;

import org.springframework.stereotype.Component;

@Component("price")
public class Price {
    public double getSpecialPrice(){
        return new Double(19.99);
    }
}
