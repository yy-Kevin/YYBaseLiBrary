package com.yy.yybaselibary.proxy;

import androidx.viewpager.widget.ViewPager;

/**
 * author: Created by yuyao on 2019/8/5 14:23
 * E-Mail: 380712098@qq.com
 * description: 代理类
 *
 * 会什么会有代理类呢
 */
public class DogProxy implements Animal {


    Dog mDog;

    public void setCat(Dog mDog){
        this.mDog = mDog;
    }

    /**
     * 因为真正吃鱼的的动物还是猫 ，而当前类只是一个代理类，不能替代吃的动作，必须交给具体子类猫自己实现
     *
     */
//    Animal mAnimal;
//
//    public void setAnimal(Animal mAnimal){
//        this.mAnimal = mAnimal;
//    }


    @Override
    public void eat() {
//        ViewPager x = new ViewPager();
        mDog.eat();
//        mAnimal.eat();
    }
}
