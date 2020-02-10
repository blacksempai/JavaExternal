import javax.imageio.IIOException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GuessingGameView {
    public int requestNumber(){
        System.out.println("Enter integer number please.");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input = in.readLine();
            int number = Integer.parseInt(input);
            System.out.println(number);
            return number;
        }
        catch (IOException e){
            System.out.println("In catch block.");
            return -1;
        }
    }

    public void printRangeError(int min, int max){
        System.out.println("Your guess is out of range. Range is from: "+min+" to "+max+".");
    }

    public void printResults(boolean flag, ArrayList previousTries, int min, int max, int userGuess){
        System.out.println("Your previous tries: "+previousTries.toString()+".");
        System.out.println("Range is from: "+min+" to "+max+".");
        System.out.println("Your guess is: "+userGuess+".");
        if(flag){
            System.out.println("Mysterious Number is bigger. Try again:");
        }
        else {
            System.out.println("Mysterious Number is smaller. Try again:");
        }
    }

    public void printGameEnd(boolean flag, int i, int mysteriousNumber){
        if(flag){
            System.out.println("You win Mysterious Number is: "+mysteriousNumber+". Iterations:"+i+".");
        }
        else{
            System.out.println("You lose. Iterations:"+i+".");
        }
    }
}