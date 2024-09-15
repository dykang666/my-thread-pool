package com.example.mythreadpool.example3.threadpool1.core;

import com.example.mythreadpool.example3.threadpool1.ThreadFactory;
import com.example.mythreadpool.example3.threadpool1.ThreadPool;

import java.util.concurrent.TimeUnit;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/14 22:50
 */
public class Test {

    public static void main(String[] args) {
        ThreadFactory factory  = new ThreadFactory() {
            @Override
            public Thread createThread(Runnable runnable) {
                return new Thread(runnable);
            }
        };

        /**
         * 创建一个线程池
         */
        ThreadPool pool = new BasicThreadPool(3, 10, 5, factory,20,BasicThreadPool.DEFAULT_DENY_POLICY,500);
        for (int i=0;i<100;i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("NAME:"+Thread.currentThread().getName() + "  task +start.....");
                        TimeUnit.MILLISECONDS.sleep(1500);
                        System.out.println("NAME:"+Thread.currentThread().getName() + "  task -done.....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
