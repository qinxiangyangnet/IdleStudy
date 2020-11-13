package com.yueyang.tt.jvm;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-06-26 16:48
 **/
public class Test {

    public static void main(String[] args) {
        /**
         * 类加载器
         * bootstrap->extendB->app->自定义
         *
         */
        Member member = new Member();
        String str = "fsdf";
        System.out.println(member.getClass().getClassLoader());
        System.out.println(str.getClass().getClassLoader().getParent());
    }

}