import java.util.Arrays;

/**
 * One-dimensional cellular automaton.
 * Original project by David J. Barnes and Michael Kölling.
 * Practice 8 - Part III.
 */
public class Automaton {
    private final int numberOfCells;
    private int[] state;
    // Question 11: 0 = original rule, 1 or 2 = other rules.
    private int rule = 0;

    public Automaton(int numberOfCells) {
        if (numberOfCells < 1) {
            throw new IllegalArgumentException("Need at least one cell");
        }
        this.numberOfCells = numberOfCells;
        // Question 12: one extra zero cell for the right edge.
        state = new int[numberOfCells + 1];
        reset();
    }

    public void print() {
        for (int i = 0; i < numberOfCells; i++) {
            System.out.print(state[i] == 1 ? "*" : " ");
        }
        System.out.println();
    }

    // Questions 6 and 9: conditional expressions replace the old
    // if-else blocks; left and center hold the old neighbor values.
    // Question 7: directly changing state[i] without saving old
    // values would change the results of later cells.
    // Question 8: keeping left and center avoids a second array.
    // Question 12: state[numberOfCells] is the permanent zero neighbor.
    public void update() {
        int left = 0;
        int center = state[0];
        for (int i = 0; i < numberOfCells; i++) {
            int right = state[i + 1];
            state[i] = calculateNextState(left, center, right);
            left = center;
            center = right;
        }
        state[numberOfCells] = 0;
    }

    // Question 10: put the calculation in its own method.
    // Question 11: allow the different example rules to be tested.
    public int calculateNextState(int left, int center, int right) {
        if (rule == 1) {
            return (left + right) % 2;
        }
        if (rule == 2) {
            return (center + right + center * right
                    + left * center * right) % 2;
        }
        return (left + center + right) % 2;
    }

    // Question 11: select rule 0, 1, or 2.
    public void setRule(int newRule) {
        if (newRule < 0 || newRule > 2) {
            throw new IllegalArgumentException("Rule must be 0, 1 or 2");
        }
        rule = newRule;
    }

    // Questions 3 and 4: resetting uses Arrays.fill and is repeatable.
    // Question 5: start with three active cells instead of one.
    public void reset() {
        Arrays.fill(state, 0);
        int middle = numberOfCells / 2;
        state[middle] = 1;
        if (middle > 0) {
            state[middle - 1] = 1;
        }
        if (middle + 1 < numberOfCells) {
            state[middle + 1] = 1;
        }
    }

    // Question 5: optional single-cell start for comparison.
    public void resetSingleCell() {
        Arrays.fill(state, 0);
        state[numberOfCells / 2] = 1;
    }
}
