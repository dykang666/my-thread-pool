package com.example.mythreadpool.example3.threadpool;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/13 17:01
 */
public class AbortDenyPolicy implements DenyPolicy {
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        throw new RunnableDenyException("The RunnableQueue is Full, and" + runnable + "will be abort");
    }
}
