import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * @author David J. Barnes and Michael Kölling
 * @version 7.1
 */
public class Automaton {
    private final int numberOfCells;
    private int[] state;

    public Automaton(int numberOfCells) {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells];
        state[numberOfCells / 2] = 1;
    }

    public void print() {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public void update() {
        int[] nextState = new int[state.length];
        for(int i = 0; i < state.length; i++) {
            int left, center, right;
            if(i == 0) {
                left = 0;
            }
            else {
                left = state[i - 1];
            }
            center = state[i];
            if(i + 1 < state.length) {
                right = state[i + 1];
            }
            else {
                right = 0;
            }
            nextState[i] = (left + center + right) % 2;
        }
        state = nextState;
    }

    public void reset() {
        Arrays.fill(state, 0);
        state[numberOfCells / 2] = 1;
    }
}
