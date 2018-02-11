package com.eason.设计模式.代理模式;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: eason
 * @Description: 动态代理
 * @Date: Create in 16:02 2018/2/9
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);

        System.out.println(userServiceProxy.getName("lily"));


        String path = "D:\\myGithub\\lg-summary\\target\\classes\\com\\eason\\java\\dynamicproxy\\$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", UserServiceImpl.class.getInterfaces());
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
