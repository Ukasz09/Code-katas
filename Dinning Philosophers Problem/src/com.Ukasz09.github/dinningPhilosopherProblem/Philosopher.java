package com.Ukasz09.github.dinningPhilosopherProblem;

import com.Ukasz09.github.Logger;

public class Philosopher extends Thread {
    private final static String MEDITATE_SUFFIX_MSG = " is meditating...";
    private final static String FINISHED_MEDITATING_SUFFIX_MSG = " has just finished meditating";
    private final static String EATING_SUFFIX_MSG = " is eating...";
    private final static int SLEEP_RANGE = 5000;

    private final Stick leftStick, rightStick;
    private final Janitor janitor;

    public Philosopher(int number, Stick rightStick, Stick leftStick, Janitor janitor) {
        super("Philosopher" + number);
        this.rightStick = rightStick;
        this.leftStick = leftStick;
        this.janitor = janitor;
    }

    private void meditateThenEat() throws InterruptedException {
        meditate();
        eatThenMeditate();
    }

    private void meditate() throws InterruptedException {
        System.out.println(getName() + MEDITATE_SUFFIX_MSG);
        sleep(getRandomPhilosopherActionTime());
        System.out.println(getName() + FINISHED_MEDITATING_SUFFIX_MSG);
    }

    private int getRandomPhilosopherActionTime() {
        return (int) (Math.random() * SLEEP_RANGE);
    }

    private void eatThenMeditate() throws InterruptedException {
        janitor.personRequestToEat();
        tryToTakeSticks();
        eat();
        releaseSticks();
        janitor.personFinishedEating();
        meditateThenEat();
    }

    private void eat() throws InterruptedException {
        System.out.println(getName() + EATING_SUFFIX_MSG);
        sleep(getRandomPhilosopherActionTime());
    }

    private void tryToTakeSticks() throws InterruptedException {
        leftStick.tryToTake();
        rightStick.tryToTake();
    }

    private void releaseSticks() {
        leftStick.release();
        rightStick.release();
    }

    @Override
    public void run() {
        try {
            meditateThenEat();
        } catch (InterruptedException e) {
            Logger.logError(e.getClass(), "Interrupted");
            e.printStackTrace();
        }
    }
}