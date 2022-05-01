import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEngima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countOfInput = Integer.parseInt(sc.nextLine());

        String regexForLetters = "[starSTAR]";
        Pattern pattern = Pattern.compile(regexForLetters);
        String withStar ="";
        String name = "";
        String letter = "";
        StringBuilder help = new StringBuilder();
        StringBuilder forLetters = new StringBuilder();

        for (int i = 0; i < countOfInput; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                withStar = matcher.group();
                forLetters.append(withStar);
            }
            String builderForLetterToString = forLetters.toString();
           int lengthOfWithStar = builderForLetterToString.length();

            for (int j = 0; j < input.length(); j++) {
                char currentLetter = input.charAt(j);
                int newLetterInt = currentLetter - lengthOfWithStar;
                currentLetter = (char)newLetterInt;
                help.append(currentLetter);
            }
            String  newMessages = help.toString();
            String regex = "@(?<planet>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attack>[AD])![^@!:>-]*->(?<soldiersCount>[0-9]+)";

            Pattern pattern1 = Pattern.compile(regex);
            Matcher matcher1 = pattern1.matcher(newMessages);



            if(matcher1.find()){
                name = matcher.group("planet");
                letter = matcher.group("attack");
            }


            int sumForA = 0;
            int sumForB = 0;
            if(letter.equals("A")){
                System.out.printf("Attacked planets: %d -> %s",sumForA,name);
                sumForA++;
            }else if(letter.equals("D")){
                System.out.printf("Destroyed planets: %d -> %s",sumForB,name);
                sumForB++;
            }
        }

    }
}
