package com.yueyang.tt.lambada;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-06-17 10:18
 **/
@FunctionalInterface
public interface UserFunction<T extends BaseParam> {

    Result sendPUsh(UserService userService, User user, T t);

}