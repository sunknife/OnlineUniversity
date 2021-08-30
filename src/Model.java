import java.util.ArrayList;
import java.util.Random;

public class Model {
    public final static int MIN_VALUE = 0;
    public final static int MAX_VALUE = 100;
    private int upperMargin = MAX_VALUE;
    private int lowerMargin = MIN_VALUE;

    public void setLowerMargin(int lowerMargin) {
        this.lowerMargin = lowerMargin;
    }

    public void setUpperMargin(int upperMargin) {
        this.upperMargin = upperMargin;
    }

    public int getLowerMargin() {
        return lowerMargin;
    }

    public int getUpperMargin() {
        return upperMargin;
    }

    private int chosenNumber;
    private ArrayList<Integer> tries = new ArrayList<>();

    public void generateChosenNumber() {
        chosenNumber = rand();
    }

    public int getChosenNumber() {
        return chosenNumber;
    }

    public ArrayList<Integer> getTries() {
        return tries;
    }

    public void addTry(int input) {
        tries.add(input);
    }

    private int rand(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    private int rand() {
        return rand(MIN_VALUE, MAX_VALUE);
    }
}
