package com.example.mythreadpool.example3.threadpool;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: // 拒绝策略
 * @date 2024/9/13 11:35
 */
@FunctionalInterface
public interface  DenyPolicy {
    //拒绝接口
    void reject(Runnable runnable,ThreadPool threadPool);
}
