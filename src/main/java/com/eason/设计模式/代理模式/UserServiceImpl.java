package com.eason.设计模式.代理模式;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 15:57 2018/2/9
 * @Modified By:
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getName(String name) {
        System.out.println("被代理对象方法开始执行：====");
        return name;
    }
}
