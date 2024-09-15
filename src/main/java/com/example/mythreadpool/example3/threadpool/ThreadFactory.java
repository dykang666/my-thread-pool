package com.example.mythreadpool.example3.threadpool;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/13 17:23
 */
// 创建线程的工厂
@FunctionalInterface
public interface ThreadFactory {
    // 创建线程
    Thread createThread(Runnable runnable);
}
