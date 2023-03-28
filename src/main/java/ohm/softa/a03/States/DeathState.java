package ohm.softa.a03.States;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DeathState extends State {

    public DeathState(int duration) {
        super(duration);
    }

    @Override
    protected State successor(Cat cat) {
        return new DeathState(9999);
    }
}
