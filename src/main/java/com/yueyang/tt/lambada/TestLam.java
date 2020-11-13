package com.yueyang.tt.lambada;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-06-17 10:07
 **/
public class TestLam {

    @Autowired
    private UserService userService;

    public PushResult toSingle(ToSingleParam param) {
        userService.insertUser(new User(), new ToSingleParam());
        return null;
    }

}