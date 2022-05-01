import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double can = Double.parseDouble(sc.nextLine());
        double can1 = Double.parseDouble(sc.nextLine());
        double can2 = Double.parseDouble(sc.nextLine());
        double peopleCount = Double.parseDouble(sc.nextLine());

        double sumCanAnswers = can + can1 + can2;

        int result = (int)Math.ceil(peopleCount / sumCanAnswers);
        int breaks = result / 3;

        System.out.printf("Time needed: %dh.",result+breaks);
    }
}
