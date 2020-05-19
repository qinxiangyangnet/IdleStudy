package com.yueyang.tt.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-18 14:45
 **/

@Component
public class IndexService {

    @Resource
    private UserService userService;

    public IndexService() {
        //容器初始化的时候已经创建
        System.out.println("construtor  from IndexService");
    }

    public void getService() {
        System.out.println(userService);
    }
}