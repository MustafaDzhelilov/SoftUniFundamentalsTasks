import java.util.Scanner;

public class ASCIISumator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String first = sc.nextLine();
        String last = sc.nextLine();
        String text = sc.nextLine();

        char one = first.charAt(0);
        char second = last.charAt(0);

        int sum = 0;

        for (int i = one + 1; i < second - 1; i++) {
            char symbol = (char) i;
            int number = symbol;

            for (int j = 0; j < text.length(); j++) {
                char current = text.charAt(j);
                if (number == current) {
                    sum += current;
                }
            }
        }
        System.out.println(sum);
    }
}
