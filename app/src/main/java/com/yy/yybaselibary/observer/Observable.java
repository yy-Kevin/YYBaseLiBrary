package com.yy.yybaselibary.observer;

/**
 * author: Created by yuyao on 2019/8/19 15:22
 * E-Mail: 380712098@qq.com
 * description: 创建一个 被观察者 抽象接口，声明增加 删除 通知观察者的方法
 *
 * 用一个警察抓小偷的案例
 *
 * 小偷是被观察者，警察是观察者且有很多个。
 *
 *
 */
public abstract class Observable {
    public abstract void add(Observer observer);
    public abstract void remove(Observer observer);
    public abstract void notifyObservers();
}
