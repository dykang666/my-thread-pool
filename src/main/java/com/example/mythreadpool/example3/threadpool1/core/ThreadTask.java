package com.example.mythreadpool.example3.threadpool1.core;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: Thread和InternalTask包装类
 * @date 2024/9/14 16:33
 */
public class ThreadTask {
    private Thread thread;
    private InternalTask internalTask;

    public ThreadTask(Thread thread, InternalTask internalTask) {
        this.thread = thread;
        this.internalTask = internalTask;
    }
    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public InternalTask getInternalTask() {
        return internalTask;
    }

    public void setInternalTask(InternalTask internalTask) {
        this.internalTask = internalTask;
    }
}
