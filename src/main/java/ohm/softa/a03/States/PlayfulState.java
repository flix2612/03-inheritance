package ohm.softa.a03.States;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class PlayfulState extends State {

    public PlayfulState(int duration) {
        super(duration);
    }

    @Override
    protected State successor(Cat cat) {
        logger.info("Yoan... getting tired!");
        return new SleepingState(cat.getSleep());
    }
}
