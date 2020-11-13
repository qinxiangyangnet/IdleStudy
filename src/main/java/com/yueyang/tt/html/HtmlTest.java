package com.yueyang.tt.html;

import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-08-24 10:45
 **/
public class HtmlTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("42134213");
        list.add("42134213");
        list.add("gdsfgdsfg453");
        list.add("gdsfgdsfg534543");
        list.add("gdsfgdsfg5345");
        list.add("gdsfgdsfg53454");
        list.add("gdsfgdsfg534543");
        list.add("gdsfgdsfg53453");
        System.out.println(list.stream().distinct().collect(Collectors.toList()).toString());
    }

}