package com.example.mythreadpool.example3.threadpool;



/**
 * @author kangdongyang
 * @version 1.0
 * @description: //丢弃的拒绝策略
 * @date 2024/9/13 17:41
 */
public class DiscardDenyPolicy implements DenyPolicy {
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        System.out.println("The RunnableQueue is Full, and" + runnable + "will be discard");
    }
}
