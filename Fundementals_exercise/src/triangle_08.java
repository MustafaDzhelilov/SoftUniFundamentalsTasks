import java.util.Scanner;

public class triangle_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int row = 1; row <=n ; row++) {
            for (int column = 1; column <=row ; column++) {
                System.out.print(row+ " ");
            }
            System.out.println();
        }
    }
}
