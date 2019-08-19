package com.yy.yybaselibary.proxy.reflex;

import android.util.Log;

/**
 * author: Created by yuyao on 2019/8/5 09:42
 * E-Mail: 380712098@qq.com
 * description:
 */
public class People {

    public String name;

    private int age;

    public People(){

    }

    private People(int age){
        this.age = age;
    }

    public People(String name, int age){
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public People setName(String name) {
        this.name = name;
        return this;
    }

    public People setName(String name, int age) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public People setAge(int age) {
        this.age = age;
        return this;
    }

    private void toShow(){
        Log.e("LoadClass" ,"---toshow");
    }


    public void toInfo(String msg){
        Log.e("LoadClass" + msg + "===" ,"age = " + age + "name = " + name);
    }
}
