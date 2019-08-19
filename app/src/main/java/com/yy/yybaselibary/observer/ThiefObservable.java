package com.yy.yybaselibary.observer;

import java.util.ArrayList;

/**
 * author: Created by yuyao on 2019/8/19 15:29
 * E-Mail: 380712098@qq.com
 * description:
 */
public class ThiefObservable extends Observable {

    ArrayList<Observer> mObservers;

    public ThiefObservable() {
        mObservers = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        mObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer ob: mObservers){
            ob.update();
        }
    }
}
