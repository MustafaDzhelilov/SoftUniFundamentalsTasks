import java.util.Scanner;

public class multiplicationTableX2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int i = Integer.parseInt(sc.nextLine());

        if(i>10) {
            System.out.printf("%d X %d = %d%n", n, i, n * i);
        }

        for ( ; i <= 10; i++) {

            System.out.printf("%d X %d = %d%n", n, i, n * i);
        }
    }
}
