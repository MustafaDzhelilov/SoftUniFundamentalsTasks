import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringBuilder encryptedString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            symbol = (char)(symbol + 3);
            encryptedString.append(symbol);
        }
        System.out.println(encryptedString);
    }
}
