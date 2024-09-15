package com.example.mythreadpool.example3.threadpool1.deny;

import com.example.mythreadpool.example3.threadpool1.ThreadPool;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 拒绝策略接口
 * @date 2024/9/14 22:47
 */
public interface DenyPolicy {
    void reject(Runnable runnable, ThreadPool threadPool);

}
