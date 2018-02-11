package com.eason.设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: eason
 * @Description:
 * @Date: Create in 15:58 2018/2/9
 * @Modified By:
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler() {
        super();
    }

    MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("+++++++++befor: 方法名：" + method.getName() + "++++++");

        Object result = method.invoke(target, args);
        System.out.println("执行结果:" + result);

        System.out.println("+++++++++after: 方法名：" + method.getName() + "++++++");
        return result;
    }
}
