package com.yueyang.thread.tongxin;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-09-16 20:51
 **/
public class ThreadNotyfy {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        String str = "test:info:+#user.id";
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("primes", str);
        String primesGreaterThanTen = (String)parser.parseExpression(str).getValue(context);
        System.out.println(primesGreaterThanTen);
        char[] c1 = "123456".toCharArray();
        char[] c2 = "ABCDEF".toCharArray();
        Object o = new Object();
        new Thread(() ->
        {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for (char c : c1) {
                    System.out.println(c);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();
        new Thread(() ->
        {
            synchronized (o) {
                for (char c : c2) {
                    System.out.println(c);
                    countDownLatch.countDown();
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }

}