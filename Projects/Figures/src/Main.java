import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Using random to prove size independence
        Random r = new Random();
        System.out.println("*  *  *  *");
        System.out.println("*  Hello *");
        System.out.println("*  World *");
        System.out.println("*  *  *  *");
        System.out.println("\n\n");
        Square.draw(r.nextInt(20)+2);
        System.out.println("\n\n");
        Triangle.draw(r.nextInt(20)+2);
        System.out.println("\n\n");
        EquilateralTriangle.draw(r.nextInt(20)+2);
        System.out.println("\n\n");
        Romb.draw(r.nextInt(20)+3);
    }
}
