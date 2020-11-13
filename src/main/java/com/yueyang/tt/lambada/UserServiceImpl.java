package com.yueyang.tt.lambada;

import org.springframework.stereotype.Component;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-06-17 10:10
 **/
@Component
public class UserServiceImpl implements UserService {

    @Override
    public Result insertUser(User user, ToSingleParam family) {
        System.out.println("加载配置----------------------------");
        return null;
    }

    UserFunction<ToSingleParam> paramUserFunction = (userService, user, param1) -> userService.insertUser(user, param1);

}