package com.yy.yybaselibary.proxy.reflex;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * author: Created by yuyao on 2019/8/5 09:42
 * E-Mail: 380712098@qq.com
 * description: 反射demo类
 */
public class LoadClass {

    public static String TAG = "LoadClass";

    public void setLoadClass() throws Exception {
        /**
         * 得到一个类对象的三种方式，
         * a. 直接new一个对象
         * b. 得到类的class，调用newInstance方法
         * c. 通过反射，得到这个类的构造方法 然后调用newInstance方法
         * d. 获取class的三种方式
         */
        //第一种方式获取class（可以new类的对象）
        People people = new People();
        Class pClass1 = people.getClass();
        //第二张方式获取class（通过类名）
        Class pClass2 = People.class;
        //第三种方式获取class （类的全路径名获取）
        Class pClass3 = Class.forName("com.yy.yybaselibary.proxy.reflex.People");

        Log.e(TAG, "pClass1 --- " + pClass1.getName());
        Log.e(TAG, "pClass2 --- " + pClass2.getName());
        Log.e(TAG, "pClass3 --- " + pClass3.getName());

        //获取所有的公开的构造方法
        Constructor[] constructors = pClass1.getConstructors();
        for (Constructor c : constructors) {
            Log.e(TAG, "constructors --- " + c);
        }
        //获取所有的构造方法 包括私有的
        Constructor[] declaredConstructors = pClass1.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            Log.e(TAG, "declaredConstructors --- " + c);
        }

        /**
         * 执行公开的构造方法
         */
        Constructor constructorPublic = pClass1.getDeclaredConstructor(String.class,int.class);
        //获取单个构造方法
        people.toInfo("执行公开的构造方法" + "ppu.name");
        People ppu = (People) constructorPublic.newInstance("段邮寄",22);
        Log.e(TAG, "ppu.name --- =" + ppu.getName());
        Log.e(TAG, "ppu.age --- =" + ppu.getAge());

        /**
         * 执行私有的构造方法
         */
        Constructor constructorPrivate = pClass1.getDeclaredConstructor(int.class);
        //获取单个构造方法
        constructorPrivate.setAccessible(true);
        People ppr = (People) constructorPrivate.newInstance(2);
        people.toInfo("执行私有的构造方法" + "ppu.name");
        Log.e(TAG, "ppr.name --- =" + ppr.getName());
        Log.e(TAG, "ppr.age --- =" + ppr.getAge());

        //获取公开类方法，包括父类的
        Method[] methods = pClass3.getMethods();
        for (Method c : methods) {
            Log.e(TAG, "Method --- " + c);
        }

        //获取所有类方法，包括私有 不包括父类的方法
        Method[] declaredMethods = pClass3.getDeclaredMethods();
        for (Method c : declaredMethods) {
            Log.e(TAG, "declaredMethods --- " + c);
        }

        /**
         * 执行方法
         * 需要知道方法的名字，以及需要传入的参数。
         * a. 得到方法
         * b. 调用invoke方法
         * c. 如果是私有的，则需要调用setAccessible
         */
        Method declaredMethod = (Method) pClass3.getDeclaredMethod("setAge", int.class);
        Method declaredMethod1 = (Method) pClass3.getDeclaredMethod("setName", String.class, int.class);
        Method toShowMethod = (Method) pClass3.getDeclaredMethod("toShow");
        Method setName = pClass3.getDeclaredMethod("setName", String.class);
        declaredMethod.setAccessible(true);//表示可以该方法如果是私有的也可以被调用
        declaredMethod.invoke(pClass3.newInstance(),20);//不能执行
        setName.invoke(pClass3.newInstance(),"zhangsan");//可以执行
        toShowMethod.setAccessible(true);
        toShowMethod.invoke(pClass3.newInstance());//可以执行 虽然是私有 但是设置了setAccessible
        declaredMethod1.invoke(pClass3.newInstance(),"ls",30);

        /**
         * 获取字段
         * a .需要知道变量的名字
         */
        Field[] declaredFields = pClass1.getDeclaredFields();

        for (Method c : declaredMethods) {
            Log.e(TAG, "declaredFields 字段 --- " + c);
        }

        //* 字段的读取和设置

        Field name = pClass1.getDeclaredField("name");

        Constructor constructor1 = pClass1.getDeclaredConstructor(String.class,int.class);
        //获取单个构造方法
//        constructor.setAccessible(true);
        constructor1.newInstance("zs",2);
        name.get(constructor1.newInstance("zs",2));
        name.get(null);
        Log.e(TAG,"获取字段 name = " + name);

    }
}
