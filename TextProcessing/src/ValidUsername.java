import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> input = Arrays.stream(sc.nextLine()
                .split(", "))
                .filter(a -> a.length() >= 3)
                .filter(b -> b.matches("^[A-Za-z0-9_-]*$"))
                .filter(c -> c.length() <= 16)
                .map(String::toString)
                .collect(Collectors.toList());
        for (String a : input) {
            System.out.println(a);
        }
    }
}




