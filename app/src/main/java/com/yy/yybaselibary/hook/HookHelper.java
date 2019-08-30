package com.yy.yybaselibary.hook;

import android.content.Context;

/**
 * author: Created by yuyao on 2019/8/22 16:24
 * E-Mail: 380712098@qq.com
 * description: hook一个没有在xml中注册过的activity
 */
public class HookHelper {

    public static void hookStartActivity(Context context) {
        context.startActivity();
    }
}
