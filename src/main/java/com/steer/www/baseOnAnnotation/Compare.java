package com.steer.www.baseOnAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * SPEL 关系，逻辑，数学运算
 */
@Component("compare")
public class Compare {
    @Value("#{1==1}")
    private boolean testEqual;

    /**
     * 在xml配置中，'>','<'要用gt,lt代替
     */
    @Value("#{99>1 AND 1<5}")
    private boolean testAnd;

    @Value("#{1 + 5}")
    private double testAdd;

    @Value("#{'1' + '@' + '2'}")
    private String testAddStr;

    @Value("#{ 2 ^ 3}")
    private double testExponentialPower;

    @Value("#{ 9 > 1 ? true : false}")
    private boolean ternaryOperator;

    @Override
    public String toString() {
        return "Compare{" +
                "testEqual=" + testEqual +
                ", testAnd=" + testAnd +
                ", testAdd=" + testAdd +
                ", testAddStr='" + testAddStr + '\'' +
                ", testExponentialPower=" + testExponentialPower +
                ", ternaryOperator=" + ternaryOperator +
                '}';
    }
}
