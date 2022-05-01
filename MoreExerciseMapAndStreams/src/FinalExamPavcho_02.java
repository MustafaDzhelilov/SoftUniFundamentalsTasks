import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinalExamPavcho_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String digits ="";
            String lowerCase = "";
            String upperCase = "";
            String symbols = "";
            StringBuilder encrypted = new StringBuilder();


            String regex = "(.+)>(?<digits>\\d{3,})\\|(?<lowerCase>[a-z]{3,})\\|(?<upperCase>[A-Z]{3,})\\|(?<symbols>[^<>]{3,})<\\1";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                digits= matcher.group("digits");
                lowerCase = matcher.group("lowerCase");
                upperCase = matcher.group("upperCase");
                symbols = matcher.group("symbols");
            }
            if(!digits.isEmpty()){
                encrypted.append(digits);
                encrypted.append(lowerCase);
                encrypted.append(upperCase);
                encrypted.append(symbols);
                System.out.println("Password: "+ encrypted);
            }else{
                System.out.println("Try another password!");
            }

        }
    }
}
