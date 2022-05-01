import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] bannedWord = sc.nextLine().split(", ");
        String input =  sc.nextLine();


        for (String word : bannedWord) {
            if(input.contains(word)){
                String wordToStar = convertWordToStar(word);
                input = input.replace(word, wordToStar);
            }
        }
        System.out.println(input);
    }

    private static String convertWordToStar(String word) {
        StringBuilder wordStar = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            wordStar.append("*");
        }
            return  (wordStar.toString());
    }
}
