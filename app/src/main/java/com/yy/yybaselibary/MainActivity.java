package com.yy.yybaselibary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yy.yybaselibary.observer.Observable;
import com.yy.yybaselibary.observer.Observer;
import com.yy.yybaselibary.observer.PoliceObserver;
import com.yy.yybaselibary.observer.ThiefObservable;
import com.yy.yybaselibary.proxy.AllProxy;
import com.yy.yybaselibary.proxy.Animal;
import com.yy.yybaselibary.proxy.Cat;
import com.yy.yybaselibary.proxy.CatProxy;
import com.yy.yybaselibary.proxy.Dog;
import com.yy.yybaselibary.proxy.DogProxy;
import com.yy.yybaselibary.proxy.ProxyUtil;
import com.yy.yybaselibary.proxy.jianshu.MaoTai;
import com.yy.yybaselibary.proxy.jianshu.MaoTaiProxy;
import com.yy.yybaselibary.test.LoadClass;


import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //代理模式
//        proxy();
        //观察者模式
        observer();
    }

    private void proxy() {
        LoadClass loadClass = new LoadClass();
//        AsyncTask
        try {
            loadClass.setLoadClass();
        } catch (Exception e) {
            e.printStackTrace();
        }

        final TextView tv_hw = findViewById(R.id.tv_hw);
        tv_hw.setOnClickListener(v -> {});
        tv_hw.setOnClickListener(v -> tv_hw.setText(""));

        //静态代理
//        CatProxy proxy = new CatProxy();
//        Cat cat = new Cat();
//        proxy.setCat(cat); //此时需要狗的代理的时候 我们又需要创教一个狗的代理对象
//
//
//        DogProxy dogProxy = new DogProxy();
//        Dog dog = new Dog();
//        dogProxy.setCat(dog);

        //有多少个动物就需要多少个代理类，违背的java的开闭原则(对修改关闭，对)

        //动态代理
        AllProxy allProxy = new AllProxy();
        Cat cat1 = new Cat();
        allProxy.setObj(cat1);
        Object o = Proxy.newProxyInstance(cat1.getClass().getClassLoader(), cat1.getClass().getInterfaces(), allProxy);
        Animal animal = (Animal) o;
        animal.eat();

        Dog dog1 = new Dog();
        Animal rroxy = (Animal) ProxyUtil.getRroxy(dog1);
        rroxy.eat();

        //使用代理类调用
        MaoTai maoTai = new MaoTai();
        MaoTaiProxy maoTaiProxy = new MaoTaiProxy(maoTai);
        maoTaiProxy.createWinery();
    }

    private void observer() {

        //new 一个被观察者
        Observable thief = new ThiefObservable();
        //new 三个观察者
        Observer police1 = new PoliceObserver("张三");
        Observer police2 = new PoliceObserver("李四");
        Observer police3 = new PoliceObserver("王二");

        thief.add(police1);
        thief.add(police2);
        thief.add(police3);

        thief.notifyObservers();

        thief.remove(police2);

        thief.notifyObservers();
    }
}
