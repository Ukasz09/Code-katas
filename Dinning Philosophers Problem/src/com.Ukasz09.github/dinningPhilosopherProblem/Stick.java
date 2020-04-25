package com.Ukasz09.github.dinningPhilosopherProblem;

import java.util.concurrent.Semaphore;

public class Stick {
    private final Semaphore available;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Stick() {
        available = new Semaphore(1);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void tryToTake() throws InterruptedException {
        available.acquire();
    }

    void release() {
        available.release();
    }
}