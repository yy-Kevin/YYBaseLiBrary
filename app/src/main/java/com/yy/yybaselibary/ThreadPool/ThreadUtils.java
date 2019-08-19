package com.yy.yybaselibary.ThreadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * author: Created by yuyao on 2019/8/6 14:43
 * E-Mail: 380712098@qq.com
 * description:
 */
public class ThreadUtils {

    private static class UseThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }


    private static class UseRunable implements Runnable{

        @Override
        public void run() {

        }
    }

    private static class userCallBack implements Callable{

        @Override
        public Object call() throws Exception {
            return null;
        }
    }
    private void runThread(){
        UseThread mUseThread = new UseThread();
        mUseThread.run();
        mUseThread.start();
        mUseThread.interrupt();

        UseRunable useRunable = new UseRunable();
        new Thread(useRunable).start();

        userCallBack userCallBack = new userCallBack();
        FutureTask futureTask = new FutureTask(userCallBack);
        new Thread(futureTask).start();

        try {
            futureTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
