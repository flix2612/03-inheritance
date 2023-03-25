package ohm.softa.a03;


import ohm.softa.a03.States.*;

public class Cat {

	/*
	CAT:
	 - 3 Sleep
	 - 5 Awake
	 - 2 Digest

	--- Sleeping ---
	1 x
	2 x
	3 -> Hungry -> Awake
	4 x
	5 feed() -> Digest, time: t, duration: t + digest
	6 x
	7 -> Playful -> awake - time
	8 -> Sleep

	 */


	private final int sleep;
	private final int awake;
	private final int digest;
	private State currentState;
	private final String name;

	public Cat (String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.currentState = new SleepingState(sleep);
	}

	public void feed() {
		if(isHungry()) {
			currentState = ((HungryState)currentState).feed(this);
		} else {
			throw new IllegalStateException("Can't stuff a cat...");
		}
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
		return currentState instanceof DigestState;
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

	@Override
	public String toString() {
		return name;
	}
}
