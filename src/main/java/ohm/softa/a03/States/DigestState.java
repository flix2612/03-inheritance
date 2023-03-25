package ohm.softa.a03.States;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DigestState extends State {

    private final int timeAwake;

    public DigestState(int duration, int timeAwake) {
        super(duration);
        this.timeAwake = timeAwake;
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(cat.getAwake() - (timeAwake + getDuration()));
    }
}
