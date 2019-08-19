package com.yy.yybaselibary.proxy.jianshu;

import android.util.Log;

/**
 * author: Created by yuyao on 2019/8/8 10:23
 * E-Mail: 380712098@qq.com
 * description: 茅台酒 代理
 */
public class MaoTaiProxy implements MakeWinery{

    public static String TAG = "MaoTaiProxy --";
    //代理类需要持有代理的对象
    MaoTai mMaoTai ;

    public MaoTaiProxy(MaoTai maoTai){
        this.mMaoTai = maoTai;
    }

    @Override
    public void createWinery() {
        //对酒就行包装，贴上标签等操作
        design();
        //在外部调用我们生产酒的方法时，实际还是茅台酒厂自己生产酒
        mMaoTai.createWinery();
        //售后服务
        afterServer();

    }

    //包装设计
    private void design() {
        Log.e(TAG,"我们茅台酒售后");
    }

    //售后服务
    private void afterServer() {
        Log.e(TAG,"我们茅台酒售后");
    }
}
