package ru.kpumuk.count;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaveCount {
    private Lock lock;
    private int count;

    public SaveCount() {
        this.lock = new ReentrantLock();
    }

    public void increment() {
        lock.lock();
        count++;
        lock.unlock();
    }

    public int getCount() {
        return count;
    }
}
