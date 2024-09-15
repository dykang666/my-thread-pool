package com.example.mythreadpool.example3.threadpool1.core;


import com.example.mythreadpool.example3.threadpool1.RunnableQueue;
import com.example.mythreadpool.example3.threadpool1.ThreadPool;
import com.example.mythreadpool.example3.threadpool1.deny.DenyPolicy;

import java.util.LinkedList;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:  任务队列
 * @date 2024/9/14 22:12
 */
public class LinkedRunnableQueue implements RunnableQueue {
    private  int limit;//任务队列最大容量
    private DenyPolicy denyPolicy;//拒绝策略
    private ThreadPool threadPool;//线程池对象
    //任务队列的缓存由此LinkedList实现
    private  LinkedList<Runnable> runnableList = new LinkedList<>();

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }
    /**
     * 任务入队
     * @param runnable
     */
    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList){
            if(runnableList.size()>=limit){
                //任务队列达到上限，执行拒绝策略
                denyPolicy.reject(runnable,threadPool);
            }else {
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
    public Runnable take() {
        synchronized (runnableList){
            while (runnableList.isEmpty()){
                try {
                    //任务队列空了，将线程挂起
                    runnableList.wait();
                }catch (Exception e){
                    e.printStackTrace();
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
        synchronized (runnableList){
            return runnableList.size();
        }
    }
}
