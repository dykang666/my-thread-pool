package com.example.mythreadpool.example3.threadpool;

/**
 * @author kangdongyang
 * @version 1.0
 * @description: // RunnableDenyException，用于通知任务提交者，任务队列已经无法再接受新的任务。
 * @date 2024/9/13 17:02
 */
public class RunnableDenyException extends RuntimeException {
    RunnableDenyException(String message) {
        super(message);
    }
}
