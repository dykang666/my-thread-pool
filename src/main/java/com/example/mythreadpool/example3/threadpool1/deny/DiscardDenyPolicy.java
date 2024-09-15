package com.example.mythreadpool.example3.threadpool1.deny;

import com.example.mythreadpool.example3.threadpool1.ThreadPool;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: 直接丢弃任务策略
 * @date 2024/9/14 22:48
 */
public class DiscardDenyPolicy implements DenyPolicy {
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        //do nothing,just deny it
    }
}
