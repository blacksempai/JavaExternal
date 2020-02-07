//@author Andrii Tyshkovets
public class Romb implements Figure {
    public static void draw(int n){
        int middle;
        if(n%2==0) {
            n=n+1;
            middle = (n/2)+1;
        } else {
            middle = (n / 2);
        }
        for (int i = 0; i < middle; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == middle-i || j == middle + i) {
                    System.out.print("*");
                    System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = middle-1; i > 0; i--) {
            for (int j = -1; j < n; j++) {
                if (j == middle-i || j == middle + i -2) {
                    System.out.print("*");
                    System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

}
