import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            String currentInput = input[i];
            for (int j = 0; j < currentInput.length(); j++) {
                System.out.print(currentInput);
            }
        }
    }
}
