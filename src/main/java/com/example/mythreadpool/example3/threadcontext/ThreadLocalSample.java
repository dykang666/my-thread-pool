package com.example.mythreadpool.example3.threadcontext;

import java.util.HashMap;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/14 10:31
 */
public class ThreadLocalSample<T> {
    //核心存储容器，ThreadLocal需要考虑到多个线程并发，所以要考虑线程安全问题。
    final private HashMap<Thread, T> threadLocalMap = new HashMap<Thread, T>();

    public void set(T t) {
        synchronized (threadLocalMap) {
            Thread key = Thread.currentThread();
            threadLocalMap.put(key, t);
        }
    }

    public T get() {
        synchronized (threadLocalMap) {
            Thread currentThread = Thread.currentThread();
            return threadLocalMap.get(currentThread);
        }
    }

}
