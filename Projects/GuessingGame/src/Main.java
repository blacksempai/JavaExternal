public class Main {
    public static void main(String[] args) {
        GuessingGameController game = new GuessingGameController(new GuessingGameModel(), new GuessingGameView());
        game.session();
    }
}