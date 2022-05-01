import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        String str1 = input[0];
        String str2 = input[1];
        int str1Sum = 0;
        int str2Sum = 0;
        int result = 0;

        if (str1.length() == str2.length()) {
            for (int i = 0; i < str1.length(); i++) {
                    str1Sum = str1.charAt(i);
                for (int j = 0; j < str2.length(); j++) {
                    str2Sum = str2.charAt(j);
                    str1Sum = str1.charAt(i);
                    result += str1Sum * str2Sum;
                    i++;
                }
            }
        }else {
          //TODO..
        }
        System.out.println(result);
    }
}
