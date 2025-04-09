package ee.mainor.classroom.greeting.service;

public class Game {
    private final int numberToGuess;
    private int attempts;

    public Game() {
        this.numberToGuess = (int) (Math.random() * 100) + 1;
        this.attempts = 0;
    }

    public String guess(int number) {
        attempts++;
        if (number < numberToGuess) {
            return "Nr is bigger";
        } else if (number > numberToGuess) {
            return "Nr is smaller";
        } else {
            return "Correct, it took you " + attempts + " times";
        }
    }
}
