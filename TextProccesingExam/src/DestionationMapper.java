import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestionationMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "(=|\\/)(?<location>[A-Z][A-Za-z]{2,})\\1";

        String input = sc.nextLine();
        StringBuilder help = new StringBuilder();
        List<String> valid = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            help.append(matcher.group("location"));
            valid.add(matcher.group("location"));
        }
        input = help.toString();
        int size = input.length();

        System.out.println("Destinations: " + String.join(", ", valid));
        System.out.println("Travel Points: " + size);
    }
}