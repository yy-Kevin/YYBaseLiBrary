package com.yy.yybaselibary.proxy.jianshu;

import android.util.Log;

/**
 * author: Created by yuyao on 2019/8/8 10:12
 * E-Mail: 380712098@qq.com
 * description: 茅台酒
 */
public class MaoTai implements MakeWinery {

    public static String TAG = "MaoTai --";
    @Override
    public void createWinery() {
        Log.e(TAG,"我们生成的是茅台酒");
    }
}
