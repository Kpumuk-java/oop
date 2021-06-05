package ru.kpumuk.multithreading;

import ru.kpumuk.multithreading.queue.SyncQueue;
import ru.kpumuk.multithreading.threads.Ping;
import ru.kpumuk.multithreading.threads.Pong;

public class main {
    public static void main(String[] args) {
        SyncQueue syncQueue = new SyncQueue();
        new Ping(syncQueue);
        new Pong(syncQueue);
    }
}
