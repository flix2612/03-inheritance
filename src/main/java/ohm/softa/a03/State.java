package ohm.softa.a03;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected final static Logger logger = LogManager.getLogger();
    private int time;
    private final int duration;

    public State(int duration) {
        this.duration = duration;
    }

    public State tick(Cat cat) {
        time++;
        if(time == duration) {
            return successor(cat);
        }
        return this;
    }

    protected abstract State successor(Cat cat);

    public int getTime() {
        return time;
    }

    public int getDuration() {
        return duration;
    }

}
