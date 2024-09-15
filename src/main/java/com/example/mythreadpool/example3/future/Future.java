package com.example.mythreadpool.example3.future;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/13 17:30
 */
public interface Future<T> {
    //返回計算的结果，该方法会陷入阻塞状态
    T get() throws InterruptedException;

    //判断任务是否已经被执行结束
    boolean done();

}
