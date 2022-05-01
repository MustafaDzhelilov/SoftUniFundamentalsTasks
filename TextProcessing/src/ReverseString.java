import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringBuilder reverseString = new StringBuilder();
        String reverse = "";

        while (!input.equals("end")){

            for (int i = input.length() -1  ; i >= 0 ; i--) {
                char symbol = input.charAt(i);
                reverse +=symbol;
            }
            System.out.println(input + " = " + reverse);
            reverse = "";
            input = sc.nextLine();
        }
    }
}
