import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        input.close();
        System.out.println(n);
        for (int i=0; i<n; i++) {
            for (int j=n-i; j>0; j--) {
                System.out.print(" ");
            }
            for (int j=i*2+1; j>0; j--) {
                System.out.print("*");
            }
            for (int j=n-i; j>0; j--) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
