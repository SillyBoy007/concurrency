package com.example.learn.concurrency.c06_lock;

/**
 * 实现可重入锁
 */
public class ReentrantLockTest {
    boolean isLocked = false;
    Thread lockBy = null;
    int lockedCount = 0;
    public synchronized  void  lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (isLocked && lockBy != thread){
            wait();
        }
        isLocked = true;
        lockedCount ++;
        lockBy = thread;
    }
    public synchronized void unlock(){
        if (Thread.currentThread() == this.lockBy){
            lockedCount -- ;
            if (lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }
}
