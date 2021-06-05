package ru.kpumuk.multithreading.threads;

import ru.kpumuk.multithreading.queue.SyncQueue;


public class Ping implements Runnable {
    SyncQueue syncQueue;

    public Ping(SyncQueue syncQueue) {
        this.syncQueue = syncQueue;
        new Thread(this, "Поток отвечающий за ping").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Первый поток пишет: " + syncQueue.writePing());
        }
    }
}
