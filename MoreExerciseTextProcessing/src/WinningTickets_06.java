import java.util.Scanner;

public class WinningTickets_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String [] tokens = input.split(", |\\s+, ");
        String ticket = "";
        char quates = '"';
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        int sumLeft = 0;
        int sumRight = 0;
        char symbol = 0;

        for (int i = 0; i < tokens.length; i++) {
            ticket = tokens[i];
            if(ticket.length() >= 20){
                String leftSide = ticket.substring(0, ((ticket.length() / 2 ) ));
                String rightSide = ticket.substring(ticket.length() / 2 ) ;

                for (int j = 0; j < leftSide.length(); j++) {
                    char symbolFromLeft = leftSide.charAt(j);
                    char symbolFromRight = rightSide.charAt(j);

                    if(symbolFromLeft == '@' || symbolFromLeft == '#' || symbolFromLeft == '$' || symbolFromLeft == '^'){
                        sumLeft += 1;
                        left.append(symbolFromLeft);
                    }
                    if(symbolFromRight == '@' || symbolFromRight == '#' || symbolFromRight == '$' || symbolFromRight == '^'){
                        sumRight += 1;
                        right.append(symbolFromRight);
                    }
                }
                String lf = left.toString();
                String rght = right.toString();
                left.delete(0,left.length());
                right.delete(0, rght.length());
                if((sumLeft >= 6 && sumLeft <= 9) && (sumRight >= 6 && sumRight <= 9)){
                    if(lf.equals(rght)) {
                        System.out.println("ticket " + quates + ticket + quates + " - " + sumLeft + lf.charAt(0));
                        sumLeft = 0;
                        sumRight = 0;
                    }
                }else if(sumLeft >= 10 && sumRight >= 10){
                    if(lf.equals(rght)) {
                        System.out.println("ticket " + quates + ticket + quates + " - " + sumLeft + lf.charAt(0) + " Jackpot!");
                        sumLeft = 0;
                        sumRight = 0;
                    }
                }else if(sumLeft == 0 || sumRight == 0){
                    System.out.println("ticket " + quates+ticket+quates + " - " + "no match");
                }

            }else {
                System.out.println("invalid ticket");
            }
        }
    }
}
