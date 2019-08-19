package com.yy.yybaselibary.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author: Created by yuyao on 2019/8/5 14:39
 * E-Mail: 380712098@qq.com
 * description:
 */
public class AllProxy implements InvocationHandler {

    Object obj;

    public AllProxy() {}

    public void setObj(Object obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        //代理前
        Object returnVal = method.invoke(obj, objects);
        //代理后
        return returnVal;
    }
}
