package ru.kpumuk.multithreading.queue;

public class SyncQueue {
    private boolean flag;

    public synchronized String writePing() {
        try {
            while (flag) {
                wait();
            }
            Thread.sleep(500);
            flag = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Ping";
    }

    public synchronized String writePong() {
        try {
            while (!flag) {
                wait();
            }
            Thread.sleep(500);
            flag = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Pong";
    }

}
