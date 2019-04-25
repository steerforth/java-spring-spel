package com.steer.www;

import com.steer.www.baseOnAnnotation.Compare;
import com.steer.www.baseOnAnnotation.Customer;
import com.steer.www.baseOnAnnotation.Item;
import com.steer.www.baseOnAnnotation.Producer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelTest {
    private ApplicationContext context;

    @Before
    public void prepare(){
        context =new ClassPathXmlApplicationContext("application-context.xml");
    }

    @Test
    public void testItem(){
        Item item = (Item) context.getBean("item");
        System.out.println(item.getName());
        System.out.println(item.getTotal());
    }

    @Test
    public void testCustomer(){
        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer.getItem().getTotal());
        System.out.println(customer.getItemName());
        System.out.println(customer.getAmount());
    }

    @Test
    public void testCompare(){
        Compare compare = (Compare) context.getBean("compare");
        System.out.println(compare);
    }

    @Test
    public void testProducer(){
        Producer producer = (Producer)context.getBean("producer");
        System.out.println(producer);
    }

}
