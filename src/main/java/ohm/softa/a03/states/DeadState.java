package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Peter Kurfer
 * Created on 10/13/17.
 */
public class DeadState extends State {
    private static final Logger logger = LogManager.getLogger();
    DeadState() {
        super(1);
    }

    @Override
    public State successor(Cat cat) {
        // no lives left...
        return this;
    }
}