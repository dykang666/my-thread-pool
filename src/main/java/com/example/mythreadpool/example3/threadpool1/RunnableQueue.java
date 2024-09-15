package com.example.mythreadpool.example3.threadpool1;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 任务队列接口
 * @date 2024/9/14 16:29
 */
public interface RunnableQueue {
    /**
     * 将任务添加至任务队列中
     * @param runnable
     */
    void offer(Runnable runnable);

    /**
     * 从任务列队中取出一个任务
     * @return
     */
    Runnable take();



    /**
     * 获取任务队列中任务数量
     * @return
     */
    int size();
}
