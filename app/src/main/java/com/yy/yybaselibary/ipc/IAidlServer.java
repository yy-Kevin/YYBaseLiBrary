package com.yy.yybaselibary.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Created by yuyao on 2019/8/22 10:13
 * E-Mail: 380712098@qq.com
 * description: 服务端代码
 */
public class IAidlServer extends Service {
    private ArrayList<Fruit> mFruits;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    IBinder mIBinder = new IAidlInterface.Stub() {
        @Override
        public void addFruit(Fruit fruit) throws RemoteException {
            mFruits.add(fruit);
        }

        @Override
        public List<Fruit> getFruitList() throws RemoteException {
            return mFruits;
        }
    };
}
