package com.example.mythreadpool.example2;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * https://bugstack.cn/md/java/interview/2020-12-09-%E9%9D%A2%E7%BB%8F%E6%89%8B%E5%86%8C%20%C2%B7%20%E7%AC%AC21%E7%AF%87%E3%80%8A%E6%89%8B%E5%86%99%E7%BA%BF%E7%A8%8B%E6%B1%A0%EF%BC%8C%E5%AF%B9%E7%85%A7%E5%AD%A6%E4%B9%A0ThreadPoolExecutor%E7%BA%BF%E7%A8%8B%E6%B1%A0%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86%EF%BC%81%E3%80%8B.html
 * @date 2024/9/13 10:43
 */
public class ThreadPoolTrader implements Executor {
    //用于记录线程池中线程数量
    private final AtomicInteger ctl = new AtomicInteger(0);
    private volatile int corePoolSize;
    private volatile int maximumPoolSize;
    private  BlockingQueue<Runnable> workQueue;
    public ThreadPoolTrader(int corePoolSize, int maximumPoolSize, BlockingQueue<Runnable> workQueue) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
    }




    @Override
    public void execute(Runnable command) {
        int c = ctl.get();
        if (c < corePoolSize) {
            if (!addWorker(command)) {
                reject();
            }
            return;
        }
        if (!workQueue.offer(command)) {
            if (!addWorker(command)) {
                reject();
            }
        }

    }

    private boolean addWorker(Runnable firstTask) {
        if (ctl.get() >= maximumPoolSize) {
            return false;
        }

        Worker worker = new Worker(firstTask);
        worker.thread.start();
        ctl.incrementAndGet();
        return true;
    }
    private final class Worker implements Runnable {
        final Thread thread;
        Runnable firstTask;

        public Worker(Runnable firstTask) {
            this.thread = new Thread(this);
            this.firstTask = firstTask;
        }


        @Override
        public void run() {
            Runnable task = firstTask;

            try {
                while (task != null || (task = getTask()) != null) {
                    task.run();
                    if (ctl.get() > maximumPoolSize) {
                        break;
                    }
                    task = null;
                }
            } finally {
                ctl.decrementAndGet();
            }
        }
        private Runnable getTask() {
            for (; ; ) {
                try {
                    System.out.println("workQueue.size：" + workQueue.size());
                    return workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void reject() {
        throw new RuntimeException("Error！ctl.count：" + ctl.get() + " workQueue.size：" + workQueue.size());
    }


    public static void main(String[] args) {
        ThreadPoolTrader threadPoolTrader = new ThreadPoolTrader(2, 2, new ArrayBlockingQueue<Runnable>(10));

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPoolTrader.execute(() -> {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务编号：" + finalI);
            });
        }
    }
}
