package com.steer.www;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    private ApplicationContext context;

    @Before
    public void prepare(){
        context =new ClassPathXmlApplicationContext("application-context.xml");
    }

       @org.junit.Test
    public void testItem(){
        Item item = (Item) context.getBean("item");
        System.out.println(item.getName());
        System.out.println(item.getTotal());
    }

    @org.junit.Test
    public void testCustom(){
        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer.getItem().getTotal());
        System.out.println(customer.getItemName());
        System.out.println(customer.getAmount());
    }

}
