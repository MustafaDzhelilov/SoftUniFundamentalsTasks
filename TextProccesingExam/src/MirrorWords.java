import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // първо намираме валидните двойки думи - съхраняваме ги някъде
        // после принтираме  броя на валидните двойките думи
        // правим проверка на дължината на лявата дума с дясната
        // после проверяваме дали валидните двойки думи първата дума дали е обърната отзада напред като втора дума и ги съхраняваме някъде
        // принтираме които отговарят на предпоследнотот условие

        String regex = "(@|#)(?<one>[A-Za-z]{3,})(\\1)(\\1)(?<two>[A-Za-z]{3,})(\\1)";
        Pattern pattern = Pattern.compile(regex);

        String input = sc.nextLine();

        Matcher matcher = pattern.matcher(input);
        List<String> validPairsWords = new ArrayList<>();
        List<String> mirrorWords = new ArrayList<>();
        String leftWord ="";
        String rightWord ="";
        StringBuilder leftWordReverse = new StringBuilder();


        while (matcher.find()){
            validPairsWords.add(matcher.group());
            leftWord = matcher.group("one");
            rightWord = matcher.group("two");

            if(leftWord.length() == rightWord.length()){
                for (int j = leftWord.length() -1; j >= 0 ; j--) {
                    char symbol = leftWord.charAt(j);
                    leftWordReverse.append(symbol);
                }
                    String leftWordReverseToString = leftWordReverse.toString();
                    leftWordReverse.delete(0,leftWordReverse.length());

                    if(leftWordReverseToString.equals(rightWord)){
                        mirrorWords.add(leftWord);
                        mirrorWords.add(rightWord);
                    }
            }
        }
        if(validPairsWords.isEmpty()){
            System.out.println("No word pairs found!");
        }else{
            System.out.println(validPairsWords.size() + " word pairs found!");
        }

        if(mirrorWords.isEmpty()){
            System.out.println("No mirror words!");
        }else{
            System.out.println("The mirror words are:");
            for (int i = 0; i < mirrorWords.size(); i++) {
                String word = mirrorWords.get(i);
                System.out.print(word);
                if(!(i == mirrorWords.size() -1)){
                    System.out.print(" <=> ");
                }
                i =i + 1;
                System.out.print(mirrorWords.get(i));
                if(i % 2 != 0){
                    if(!(i == mirrorWords.size() -1)){
                        System.out.print(", ");
                    }
                }

            }




        }

        }
    }

