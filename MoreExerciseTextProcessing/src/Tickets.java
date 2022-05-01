import java.util.Scanner;

public class Tickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", |\\s+, ");
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        boolean isLeft = false;
        boolean isRight = false;

        char quates = '"';

        for (String s : input) {
            String currentInput = s;
            if(currentInput.length() >= 20){
                String leftSide = currentInput.substring(0,(currentInput.length() / 2));
                String rightSide = currentInput.substring(currentInput.length() / 2);

                for (int i = 0; i < leftSide.length(); i++) {
                    char symbolLeft = leftSide.charAt(i);
                    if(symbolLeft == '@' || symbolLeft == '#' || symbolLeft == '$' || symbolLeft == '^'){
                        left.append(symbolLeft);
                        isLeft = true;
                    }
                    char symbolRight = rightSide.charAt(i);
                    if(symbolRight == '@' || symbolRight == '#' || symbolRight == '$' || symbolRight == '^'){
                        right.append(symbolRight);
                        isRight = true;
                    }
                }
                if(!isLeft && !isRight){
                    System.out.println("ticket " + quates+currentInput+quates + " - " + "no match");
                    break;
                }
                leftSide = left.toString();
                rightSide = right.toString();
                left.delete(0,left.length());
                right.delete(0,right.length());
                if((leftSide.length() == 6) || (leftSide.length() <= 9) && rightSide.length() == 6 || rightSide.length() <= 9){
                    if(leftSide.equals(rightSide)){
                        System.out.println("ticket " + quates+currentInput+quates + " - " + leftSide.length() + leftSide.charAt(0));
                    }
                }else if(leftSide.length() == 10 && rightSide.length() == 10){
                    if(leftSide.equals(rightSide)) {
                        System.out.println("ticket " + quates + currentInput + quates + " - " + leftSide.length() + leftSide.charAt(0) + " Jackpot!");
                    }
                }

            }else{
                System.out.println("invalid tickets");
            }


        }
    }
}
