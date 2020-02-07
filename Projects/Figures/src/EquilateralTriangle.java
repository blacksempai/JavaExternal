//@author Radomyr Mykolenko
public class EquilateralTriangle implements Figure {
    public static void draw(int n){
        int h = n+2;
        int length = (h + (h - 1));
        for (int i = 1; i <= h; i++) { /*Малюємо рівносторонній трикутник*/
            for (int m = 1; m <= (h+(h-1)); m++) {
                if (i == 1) {
                    if (m == h) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    };
                }
                else {
                    if (i == h) {
                        System.out.print("*");
                    }
                    else {
                        if (m<(h-(i-1))||m>(h+(i-1))){
                            System.out.print(" ");
                        }
                        else {
                            if (m==(h-(i-1))||m==(h+(i-1))){
                                System.out.print("*");
                            }
                            else {
                                System.out.print(" ");
                            };
                        };
                    };
                };
            }
            System.out.print("\n");
        }
    }
}

