package com.steer.www;

import com.steer.www.baseOnParser.Account;
import com.steer.www.baseOnParser.Ball;
import com.steer.www.baseOnParser.Friend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpelParserTest {
    ExpressionParser parser = null;

    @Before
    public void prepare(){
        parser = new SpelExpressionParser();
    }

    @Test
    public void parseText(){
        String str = (String) parser.parseExpression("'你好'").getValue();
        Assert.assertEquals("你好",str);
        int integerVal = (Integer) parser.parseExpression("0x16").getValue();
        Assert.assertEquals(22,integerVal);
        Boolean booleanVal = (Boolean) parser.parseExpression("true").getValue();
        Assert.assertEquals(true,booleanVal);
    }


    @Test
    public void parseObject(){
        //初始化对象
        Account account=new Account("Deniro");
        account.setFootballCount(10);
        account.addFriend(new Friend("Jack"));

        //解析上下文
        EvaluationContext context=new StandardEvaluationContext(account);
        //获取不同类型的属性
        String name= (String) parser.parseExpression("name").getValue(context);
        Assert.assertEquals("Deniro",name);
        int count= (Integer) parser.parseExpression("footballCount+1").getValue(context);
        Assert.assertEquals(11,count);
        //获取嵌套类中的属性
        String friendName= (String) parser.parseExpression("friend.name").getValue(context);
        Assert.assertEquals("Jack",friendName);

    }

    @Test
    public void parseCollection(){
        //解析一维数组
        int[] oneArray = (int[]) parser.parseExpression("new int[]{3,4,5}").getValue();
        Assert.assertEquals(3,oneArray[0]);
        Assert.assertEquals(4,oneArray[1]);
        Assert.assertEquals(5,oneArray[2]);
        //解析 list
        List list = (List) parser.parseExpression("{3,4,5}").getValue();
        Assert.assertEquals(3,list.get(0));
        Assert.assertEquals(4,list.get(1));
        Assert.assertEquals(5,list.get(2));

        //解析 Map
        Map map = (Map) parser.parseExpression("{account:'deniro',footballCount:10}")
                .getValue();
        Assert.assertEquals("deniro",map.get("account"));
        Assert.assertEquals(10,map.get("footballCount"));



        //解析对象中的 list
        final Account account = new Account("Deniro");
        Ball ball1 = new Ball("Ball1");
        Ball ball2 = new Ball("Ball2");
        account.addBall(ball1);
        account.addBall(ball2);
        EvaluationContext context = new StandardEvaluationContext(account);
        String ball1Name = (String) parser.parseExpression("balls[0].name")
                .getValue(context);
        Assert.assertEquals("Ball1",ball1Name);

    }

    @Test
    public void parseFunction(){
        //调用 String 方法
        boolean isEmpty = parser.parseExpression("'Hi,everybody'.contains('Hi')").getValue
                (Boolean
                        .class);
        Assert.assertEquals(true,isEmpty);

        /**
         * 调用对象相关方法
         */
        final Account account = new Account("Deniro");
        EvaluationContext context = new StandardEvaluationContext(account);

        //调用公开方法
        parser.parseExpression("setFootballCount(11)").getValue(context, Boolean
                .class);
        Assert.assertEquals(11,account.getFootballCount());


        //调用静态方法
        parser.parseExpression("read()").getValue(context, Boolean
                .class);
    }

    @Test
    public void parseVariable(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 11);

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("map", map);
        int result = parser.parseExpression("#map['a']").getValue(context, int.class);
        Assert.assertEquals(11,result);
    }


    @Test
    public void parseArithmetic(){
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("A", 5);
        int result = parser.parseExpression("#A*3/5").getValue(context, int.class);
        Assert.assertEquals(3,result);
    }
}
