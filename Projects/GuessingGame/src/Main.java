public class Main {
    public static void main(String[] args) {
        GuessingGameController game = new GuessingGameController(new GuessingGameModel(), new GuessingGameView());
        while(true){
        if(game.gameIteration()) System.exit(0);
        else game.resetGame();
        }
    }
}