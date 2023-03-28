package ohm.softa.a03.States;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class HungryState extends State {

    public HungryState(int duration) {
        super(duration);
    }

    @Override
    protected State successor(Cat cat) {
        logger.info("I've starved for a too long time...good bye...");
        return new DeathState(999);
    }

    public State feed(Cat cat) {
        return new DigestingState(cat.getDigest(), getTime());
    }
}