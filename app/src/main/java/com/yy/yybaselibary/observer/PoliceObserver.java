package com.yy.yybaselibary.observer;

import android.util.Log;

/**
 * author: Created by yuyao on 2019/8/19 15:32
 * E-Mail: 380712098@qq.com
 * description:
 */
public class PoliceObserver extends Observer {

    public static final String TAG = "PoliceObserver";

    private String name;

    public PoliceObserver(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        Log.e(TAG, "---小偷正在偷东西，" + name + "警察开始抓捕---");
    }
}
