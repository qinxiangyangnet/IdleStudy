package com.yueyang.tt.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-18 14:45
 **/
@Component
public class UserService {
    @Autowired
    private IndexService indexService;

    public UserService() {
        System.out.println("construtor  from UserService");
    }

    public void getService() {
        System.out.println(indexService);
    }

}