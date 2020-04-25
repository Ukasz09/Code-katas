package com.Ukasz09.github.dinningPhilosopherProblem;

import java.util.concurrent.Semaphore;

public class Janitor {
    private final Semaphore semaphore;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Janitor(int philosophersQty) {
        semaphore = new Semaphore(philosophersQty - 1, true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void personRequestToEat() throws InterruptedException{
        semaphore.acquire();
    }

    public void personFinishedEating() {
        semaphore.release();
    }
}
