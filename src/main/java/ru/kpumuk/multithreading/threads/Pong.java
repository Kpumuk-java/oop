package ru.kpumuk.multithreading.threads;

import ru.kpumuk.multithreading.queue.SyncQueue;


public class Pong implements Runnable {
    SyncQueue syncQueue;

    public Pong(SyncQueue syncQueue) {
        this.syncQueue = syncQueue;
        new Thread(this, "Поток отвечающий за pong").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
                System.out.println("Второй поток пишет: " + syncQueue.writePong());
        }
    }
}