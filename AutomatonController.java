/**
 * Automaton controller, based on the original by
 * David J. Barnes and Michael Kölling.
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

    // Questions 1 and 2: turn off "Clear screen at method call"
    // in BlueJ, then use step() and run() to see the pattern.
    public void run(int numSteps) {
        for (int step = 1; step <= numSteps; step++) {
            step();
        }
    }

    public void step() {
        auto.update();
        auto.print();
    }

    // Questions 3 and 5: resetting repeats the same starting pattern.
    public void reset() {
        auto.reset();
        auto.print();
    }

    // Question 5: compare a one-cell start with the three-cell start.
    public void resetSingleCell() {
        auto.resetSingleCell();
        auto.print();
    }

    // Question 11: try the alternative calculations.
    public void setRule(int rule) {
        auto.setRule(rule);
    }
}
