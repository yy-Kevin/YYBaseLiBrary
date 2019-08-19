package com.yy.yybaselibary.proxy;

import android.util.Log;

/**
 * author: Created by yuyao on 2019/8/5 14:02
 * E-Mail: 380712098@qq.com
 * description: 河南人都吃 面
 */
public class Dog implements Animal {

    private static final String TAG = "Animal---";

    @Override
    public void eat() {
        Log.e(TAG,"狗吃骨头");
    }

}
