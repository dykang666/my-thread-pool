package com.example.mythreadpool.example3.threadpool1.core;

import com.example.mythreadpool.example3.threadpool1.RunnableQueue;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 线程池核心消费任务
 * @date 2024/9/14 16:34
 */
public class InternalTask implements Runnable{
    private  RunnableQueue runnableQueue;//任务队列
    private volatile boolean running = true;//执行开关
    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }
    @Override
    public void run() {
        while(running && !Thread.currentThread().isInterrupted()){
            //不断的从任务队列中取出一个任务来执行
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (Exception ex) {
                ex.printStackTrace();
                running = false;
                break;
            }
        }
    }
    //停止任务
    void stop(){
        this.running = false;
    }
}
