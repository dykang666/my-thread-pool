package com.example.mythreadpool.example3.threadpool;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * // 该拒绝策略会使任务提交者在自己所在的线程中执行任务
 * @date 2024/9/14 10:14
 */
public class RunnerDenyPolicy implements DenyPolicy{
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
        if (!threadPool.isShutdown()) {
            runnable.run();
        }
    }
}
