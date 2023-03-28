package ohm.softa.a03;

import ohm.softa.a03.States.*;

public class Cat {

    // Awake => hungry, digesting, awake
    private int sleep;
    private int awake;
    private int digest;
    private State currentState;
    private String name;

    public Cat(String name, int sleep, int awake, int digest) {
        this.name = name;
        this.sleep = sleep;
        this.awake = awake;
        this.digest = digest;
        this.currentState = new SleepingState(sleep);
    }

    public void feed() {
        if (!isHungry()) {
            throw new IllegalStateException("Can't stuff a cat...");
        }
        currentState = ((HungryState) currentState).feed(this);
    }

    public void tick() {
        currentState = currentState.tick(this);
    }

    public boolean isAsleep() {
        return currentState instanceof SleepingState;
    }

    public boolean isPlayful() {
        return currentState instanceof PlayfulState;
    }

    public boolean isHungry() {
        return currentState instanceof HungryState;
    }

    public boolean isDigesting() {
        return currentState instanceof DigestingState;
    }

    public boolean isDead() {
        return currentState instanceof DeathState;
    }

    public int getSleep() {
        return sleep;
    }

    public int getDigest() {
        return digest;
    }

    public int getAwake() {
        return awake;
    }

    public String getName() {
        return name;
    }

}
