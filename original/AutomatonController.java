/**
 * Set up and control an elementary cellular automaton.
 * @author David J. Barnes and Michael Kölling
 * @version 7.1
 */
public class AutomatonController {
    private Automaton auto;

    public AutomatonController(int numberOfCells) {
        auto = new Automaton(numberOfCells);
        auto.print();
    }

    public AutomatonController() {
        this(50);
    }

    public void run(int numSteps) {
        for(int step = 1; step <= numSteps; step++) {
            step();
        }
    }

    public void step() {
        auto.update();
        auto.print();
    }

    public void reset() {
        auto.reset();
        auto.print();
    }
}
