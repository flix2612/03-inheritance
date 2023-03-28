package ohm.softa.a03.States;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DigestingState extends State {

    private final int awakeTime;

    public DigestingState(int duration, int awakeTime) {
        super(duration);
        this.awakeTime = awakeTime;
    }

    @Override
    protected State successor(Cat cat) {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(cat.getAwake() - (getTime() + awakeTime));
    }
}
