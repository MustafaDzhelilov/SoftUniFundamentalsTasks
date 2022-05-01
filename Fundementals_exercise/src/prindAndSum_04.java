import java.util.Scanner;

public class prindAndSum_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNumber = Integer.parseInt(sc.nextLine());
        int endNumber = Integer.parseInt(sc.nextLine());

        int sum = 0;

        for (int i = startNumber; i <=endNumber ; i++) {
            sum +=i;
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.printf("Sum: %d",sum);
    }
}
