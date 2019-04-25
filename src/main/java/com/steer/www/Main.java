package com.steer.www;

import com.steer.www.baseOnAnnotation.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 能做什么？
 * 1.把字符串转为对象
 * 2.把字符串里面的运算转为最终结果给
 * 3.利用上下文context，可以执行放入上下文中的对象的方法
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application-context.xml");
        Item item = (Item) applicationContext.getBean("Item");
        System.out.println(item.getName());
    }

}
