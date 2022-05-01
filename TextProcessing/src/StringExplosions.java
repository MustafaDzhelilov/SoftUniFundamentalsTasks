import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringExplosions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(sc.nextLine());
        int strength = 0;

        for (int i = 0; i < sb.length(); i++) {
            char symbol = sb.charAt(i);
            if(symbol == '>' && Character.isDigit(sb.charAt(i+1))){
                strength += Character.getNumericValue(sb.charAt(i+1));
            }
                for (int j = 0; j < strength; j++) {
                    if(Character.isLetterOrDigit(sb.charAt(i+1))) {
                        sb.deleteCharAt(i + 1);
                        strength--;
                        i--;
                    }
            }

        }
        System.out.println(sb);

    }
}
