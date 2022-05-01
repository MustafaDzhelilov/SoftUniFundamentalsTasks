import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String [] inputString = input.split("\\s+");
        double sum = 0;
        double total =0;

        for (String word : inputString) {
            char firstLetter = word.charAt(0);
            char lastLetter = word.charAt(word.length() - 1);
            double number = Double.parseDouble(word.substring(1, word.length() - 1));

            if(Character.isUpperCase(firstLetter)){
                sum = number / (firstLetter - 64);
                number = sum;
            }else{
                sum = number * (firstLetter - 96);
                number = sum;
            }
            if(Character.isUpperCase(lastLetter)){
                sum = number - (lastLetter - 64);
                number = sum;
            }else{
                sum = number + (lastLetter - 96);
                number = sum;
            }
            total += sum;
        }
        System.out.printf("%.2f",total);
    }

}
