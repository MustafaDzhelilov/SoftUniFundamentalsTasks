import java.util.Scanner;

public class reverseString_04 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        String username = sc.nextLine();

        StringBuilder passwordBuilder = new StringBuilder();

        for (int position = username.length() - 1;position >=0 ; position--) {
            char currentSymbol = username.charAt(position);
            passwordBuilder.append(currentSymbol);
        }
        String password = passwordBuilder.toString();

        System.out.println(password);
    }
}
