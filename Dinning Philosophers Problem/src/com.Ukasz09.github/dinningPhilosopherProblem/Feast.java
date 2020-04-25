package com.Ukasz09.github.dinningPhilosopherProblem;

public class Feast {
    private final int philosophersQty;
    private final Janitor janitor;
    private final Stick[] sticks;
    private final Philosopher[] philosophers;

    public Feast(int philosophersQty) {
        this.philosophersQty = philosophersQty;
        janitor = new Janitor(philosophersQty);
        sticks = new Stick[philosophersQty];
        addSticks();
        philosophers = new Philosopher[philosophersQty];
        addPhilosophers(sticks, janitor);
    }

    private void addSticks() {
        for (int i = 0; i < sticks.length; i++)
            sticks[i] = new Stick();
    }

    private void addPhilosophers(Stick[] sticks, Janitor janitor) {
        for (int i = 0; i < philosophers.length; i++)
            philosophers[i] = new Philosopher(i, sticks[i], sticks[(i + 1) % philosophersQty], janitor);
    }

    public void startFeast() {
        for (Philosopher philosopher : philosophers)
            philosopher.start();
    }
}
