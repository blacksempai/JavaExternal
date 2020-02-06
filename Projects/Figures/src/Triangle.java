//@author Andriy Moskalenko
public class Triangle implements Figure {
    public static void draw(int n){
        System.out.print("*");
        System.out.print("\n");
        for (int i = 0; i < n-1; i++) {
            System.out.print("*");
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.print("\n");
        }
        for (int i = 0; i < n/2; i++) {
            System.out.print("*");
            System.out.print(" ");
        }
        //If the number is not an integer, the last 2 * must be without space
        for (int i = 0; i < n%2; i++) {
            System.out.print("*");
        }
        System.out.print("*");
    }
}
