package com.example.mythreadpool.example3.threadpool;

import java.util.LinkedList;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/13 18:42
 */
public class LinkedRunableQueue implements RunableQueue{
    // 任务队列的最大容量
    private  int limit;

    // 若任务队列中的任务已经满了，则需要执行拒绝策略
    private  DenyPolicy denyPolicy;

    // 存放任务的队列
    private final LinkedList<Runnable> runnableList = new LinkedList<>();
    //线程池对象
    private  ThreadPool threadPool;

    public LinkedRunableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }
    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() > limit) {
                //任务队列达到上限，执行拒绝策略
                denyPolicy.reject(runnable, threadPool);
            } else {
                //将任务加入队列尾部
                runnableList.addLast(runnable);
                //唤醒所有被阻塞的线程，执行任务
                runnableList.notifyAll();
            }
        }
    }
    /**
     * 任务出队
     * @return
     */
    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    // 任务队列里面没有任务,则挂起到阻塞队列。
                    runnableList.wait();//wait方法会释放moniter锁
                } catch (InterruptedException e) {
                    // 线程被中断出现异常时，将该异常抛出
                    throw e;
                }
            }
            //取出队列中第一个任务
            return runnableList.removeFirst();
        }
    }
    /**
     * 返回当前任务队列中任务数量
     * @return
     */
    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
