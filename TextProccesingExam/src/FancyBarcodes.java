import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "(?<seperatorBegin>@#+)(?<word>[A-Za-z0-9]+)(?<seperatorEnd>@#+)";
        String allRegex = "^@#+(?=[A-Z])([A-Za-z0-9]{6,})(?<=[A-Z])@#+$";
        String allDigits = "\\d";

        Pattern pattern = Pattern.compile(allRegex);
        Pattern pattern1 = Pattern.compile(allDigits);
        StringBuilder digitsFromSequence = new StringBuilder();
        int countOfInput = Integer.parseInt(sc.nextLine());
        String validInput = "";

        for (int i = 0; i < countOfInput; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                validInput = matcher.group();
            }else{
                System.out.println("Invalid barcode");
                continue;
            }
            Matcher matcher1 = pattern1.matcher(validInput);

            while (matcher1.find()) {
                digitsFromSequence.append(matcher1.group());
            }
            if (digitsFromSequence.length() != 0) {
                System.out.println("Product group: " + digitsFromSequence);
                digitsFromSequence.delete(0,digitsFromSequence.length());
            } else{
                System.out.println("Product group: " + "00");
            }

        }
    }
}
