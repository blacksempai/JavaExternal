public class GuessingGameController {
    private GuessingGameModel model;
    private GuessingGameView view;

    public GuessingGameController(GuessingGameModel model, GuessingGameView view) {
        this.model = model;
        this.view = view;
    }

    public void session(){
        while(true){
            if(gameIteration()) System.exit(0);
            else resetGame();
        }
    }

    public boolean gameIteration(){
        int userNumber = view.requestNumber();
        while (userNumber>model.getUserMaxGuess()||userNumber<model.getUserMinGuess()){
            view.printRangeError(model.getUserMinGuess(),model.getUserMaxGuess());
            userNumber = view.requestNumber();
        }
        model.addTry(userNumber);
        int guess = model.guess(userNumber);
        if(model.getCounter()>9){
            view.printGameEnd(false, model.getCounter(), userNumber);
            return false;
        }
        if(guess==0) {
            view.printGameEnd(true, model.getCounter(), userNumber);
            return true;
        }
        else if(guess==1){
            model.setUserMinGuess(userNumber);
            view.printResults(true, model.getPreviousTries(), model.getUserMinGuess(), model.getUserMaxGuess(), userNumber);
        }
        else if(guess==-1){
            model.setUserMaxGuess(userNumber);
            view.printResults(false, model.getPreviousTries(), model.getUserMinGuess(), model.getUserMaxGuess(), userNumber);
        }
        return gameIteration();
    }

    public void resetGame(){
        model.setUserMinGuess(0);
        model.setUserMaxGuess(100);
        model.resetCounter();
        model.resetMysteriousNumber();
    }
}