import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> firstHands = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondHands = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

            if (!firstHands.isEmpty() && !secondHands.isEmpty()) {
                for (int i = 0; i < firstHands.size(); i++) {
                    if (firstHands.isEmpty() || secondHands.isEmpty()){
                        break;
                    }
                    int firstHandsCard = firstHands.get(i);
                    int secondHandsCard = secondHands.get(i);

                    if (firstHandsCard > secondHandsCard) {
                        firstHands.add(firstHandsCard);
                        firstHands.remove(i);
                        firstHands.add(secondHands.get(i));
                        secondHands.remove(i);
                        i = -1;
                    } else if (secondHandsCard > firstHandsCard) {
                        secondHands.add(secondHandsCard);
                        secondHands.remove(i);
                        secondHands.add(firstHands.get(i));
                        firstHands.remove(i);
                        i = -1;
                    }else if(firstHandsCard == secondHandsCard){
                        firstHands.remove(i);
                        secondHands.remove(i);
                        i = - 1;
                    }
                }
            }
            int sum = 0;
            String winName = "";
       if(firstHands.isEmpty()){
           for (Integer secondHand : secondHands) {
               sum +=secondHand;
               winName = "Second";
           }
       }else if(secondHands.isEmpty()){
           for (Integer firstHand : firstHands) {
               sum +=firstHand;
               winName = "First";
           }
       }
        System.out.printf("%s player wins! Sum: %d",winName,sum);
    }
}
