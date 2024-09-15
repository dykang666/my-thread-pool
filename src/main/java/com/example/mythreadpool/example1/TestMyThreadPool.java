package com.example.mythreadpool.example1;

import java.util.concurrent.*;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/13 10:25
 */
public class TestMyThreadPool extends ThreadPoolExecutor {
    public TestMyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                            BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public static void main(String[] args) throws InterruptedException{
        //创建3个线程的线程池
        MyThreadPool myThreadPool = new MyThreadPool(3, 3);
        myThreadPool.execute(new MyTask("A"));
        myThreadPool.execute(new MyTask("B"));
        myThreadPool.execute(new MyTask("C"));
        myThreadPool.execute(new MyTask("D"));
        myThreadPool.execute(new MyTask("E"));
        System.out.println(myThreadPool);
        Thread.sleep(10000);
        myThreadPool.destory(); //所有线程都执行完成后，再destory
        System.out.println(myThreadPool);
    }
}
