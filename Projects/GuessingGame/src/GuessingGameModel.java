import java.util.ArrayList;
import java.util.Random;

public class GuessingGameModel {
    private int mysteriousNumber;
    private int userMinGuess = 0;
    private int userMaxGuess = 100;
    private int counter = 0;
    private ArrayList<Integer> previousTries = new ArrayList<Integer>();
    private Random random = new Random();

    public GuessingGameModel() {
        mysteriousNumber = random.nextInt(100);
    }

    public GuessingGameModel(int min, int max) {
        mysteriousNumber = random.nextInt(max-min) + min;
    }

    public int guess(int userGuess){
        counter++;
        if(userGuess==mysteriousNumber) return 0;
        return userGuess < mysteriousNumber ? 1 : -1;
    }

    public void resetMysteriousNumber(){
        mysteriousNumber = random.nextInt(100);
    }

    public void resetMysteriousNumber(int min, int max){
        mysteriousNumber = random.nextInt(max-min) + min;
    }

    public int getUserMinGuess() {
        return userMinGuess;
    }

    public int getUserMaxGuess() {
        return userMaxGuess;
    }

    public void setUserMaxGuess(int userMaxGuess) {
        this.userMaxGuess = userMaxGuess;
    }

    public void setUserMinGuess(int userMinGuess) {
        this.userMinGuess = userMinGuess;
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        this.counter = 0;
    }

    public ArrayList getPreviousTries() {
        return previousTries;
    }

    public void resetPreviousTries() {
        this.previousTries.clear();
    }

    public void addTry(Integer userGuess){
        previousTries.add(userGuess);
    }
}