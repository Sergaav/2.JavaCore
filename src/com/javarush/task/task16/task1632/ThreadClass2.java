package com.javarush.task.task16.task1632;

public class ThreadClass2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.currentThread().interrupt();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
