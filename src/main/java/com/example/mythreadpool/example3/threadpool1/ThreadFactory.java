package com.example.mythreadpool.example3.threadpool1;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 线程工厂接口
 * @date 2024/9/14 16:28
 */
public interface  ThreadFactory {
    Thread createThread(Runnable runnable);
}
