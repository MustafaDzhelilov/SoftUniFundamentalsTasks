import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String digitRegex = "\\d";

        String regex = "(?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))";

        Pattern pattern1 = Pattern.compile(digitRegex);
        Pattern pattern2 = Pattern.compile(regex);
        int sum = 1;

        List<String> emoji = new ArrayList<>();
        List<String> allEmoji = new ArrayList<>();

        Matcher matcher1 = pattern1.matcher(input);

        while (matcher1.find()){
            int digits = Integer.parseInt(matcher1.group(0));
            sum = sum * digits;
        }

        Matcher matcher2 = pattern2.matcher(input);

        while (matcher2.find()){
            String name1 = matcher2.group("name");

            int sumChar = 0;

            for (int i = 2; i < name1.length() - 2; i++) {
                char sign = name1.charAt(i);
                sumChar += (int)sign;
            }
            allEmoji.add(name1);

            if(sumChar > sum){
                emoji.add(name1);
            }
        }

        System.out.printf("Cool threshold: %d%n",sum);
        System.out.printf("%d emojis found in the text. The cool ones are:%n",allEmoji.size());

        for (String a: emoji
        ) {
            System.out.printf("%s%n",a);
        }


    }
}
