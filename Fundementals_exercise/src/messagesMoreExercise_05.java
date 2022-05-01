import java.util.Scanner;

public class messagesMoreExercise_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countLetters = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <=countLetters ; i++) {
            int inputNumbers = Integer.parseInt(sc.nextLine());
            String numberAsText = Integer.toString(inputNumbers);
            int digitsCount = numberAsText.length();
            int mainDigit = inputNumbers % 10;
            int offset = (mainDigit - 2) * 3;
            if(mainDigit == 8 || mainDigit == 9){
                offset++;
            }
            int letterIndex = offset + digitsCount - 1;
            if(inputNumbers == 0){
                System.out.print(" ");
            }else{
                System.out.print((char)(letterIndex + 97));
            }
        }

    }
}
