package com.example.mythreadpool.example3.threadpool;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/13 11:36
 */
public interface ThreadPool {
    // 提交任务到线程池
    void execute(Runnable runnable);

    // 关闭线程池
    void shutdown();

    // 获取线程池的初始化大小
    int getInitSize();

    // 获取线程池最大的线程数
    int getMaxSize();

    // 获取线程池核心线程数量
    int getCoreSize();

    // 获取线程池中用于缓存任务队列的大小
    int getQueueSize();


    // 获取线程池活跃的线程数量
    int getActiveCount();


    // 查看线程池是否已经被shutdown
    boolean isShutdown();
}
