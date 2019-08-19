package com.yy.yybaselibary.proxy;

import java.lang.reflect.Proxy;

/**
 * author: Created by yuyao on 2019/8/5 14:52
 * E-Mail: 380712098@qq.com
 * description:
 */
public class ProxyUtil {

    public static Object getRroxy(Object o) {
        AllProxy allProxy = new AllProxy();
        allProxy.setObj(o);

        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), allProxy);
    }
}
