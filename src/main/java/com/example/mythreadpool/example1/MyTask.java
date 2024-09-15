package com.example.mythreadpool.example1;

import java.util.Random;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/9/13 10:22
 */
public class MyTask implements Runnable{
    private String name;
    public String getName() {
        return name;
    }
    private Random random = new Random();
    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(1000) + 2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getId() + "sleep InterruptedException:" +
                    Thread.currentThread().isInterrupted());
        }
        System.out.println("task--- " + name + "---done!");
    }
}
