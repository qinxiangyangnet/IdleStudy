package com.yueyang.tt.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: IdleStudy
 * @description: 循环依赖
 *
 * spring当中默认单例支持循环依赖
 * 怎么证明支持？
 * 怎么关闭？
 * 解决循环依赖的细节
 *
 *
 * 依赖注入的功能，
 * 什么时候完成？ 容器初始化
 *
 * 初始化bean，有一个初始化过程---spring  bean生命的周期
 *
 *
 * beam:  spring  bean,有一个完整的生命的周期
 * java对象：new出来的
 *
 * bean由什么产生的？对象java文件--- class----beanDefinition---Object
 * clazz各种配置信息，由beanDefinition字类。存储某个class所有的信息，放到map中，单例池
 *
 *
 * 	finishBeanFactoryInitialization(beanFactory);实例化对象非多列，非lazy
 *
 * 	Object singletonObject = this.singletonObjects.get(beanName);  为什么要拿bean？创建bean的时候为啥要get?
 *
 *
 *
 * @author: qinxiangyang
 * @create: 2020-05-18 14:44
 **/
public class CircularDependence {


    public static void main(String[] args) {
        
        //初始化Spring容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanNamesForAnnotation = ac.getBeanNamesForAnnotation(Component.class);

        IndexService bean = ac.getBean(IndexService.class);
        System.out.println(bean);

     //   ac.getBean(UserService.class).getService();

    }
}