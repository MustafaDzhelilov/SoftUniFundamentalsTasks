import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int peopleInQueue =Integer.parseInt(sc.nextLine());
        List<Integer> wagons = Arrays.stream(sc.nextLine().split( " "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int currentSpaceInposition = 0;
        int count = 0;

        for (int i = 0; i < wagons.size(); i++) {
            if(peopleInQueue == 0){
                break;
            }
            currentSpaceInposition = wagons.get(i);
            if(currentSpaceInposition == 4){
                count++;
            }else if(currentSpaceInposition < 4){
                for (int j = currentSpaceInposition; j < 4; j++) {
                    currentSpaceInposition++;
                    peopleInQueue--;
                    if(peopleInQueue == 0){
                        break;
                    }
                }
                wagons.set(i,currentSpaceInposition);
            }
        }

        /*if(count == wagons.size() || peopleInQueue == 0){
            String toPrint = wagons.toString().replaceAll("[\\]\\[,]", "");
            toPrint = toPrint.replaceAll("\\s+", " ");
            System.out.println(toPrint);
        }*/
            count =0;
        for (int i = 0; i < wagons.size(); i++) {
            int n = wagons.get(i);
            if( n == 4) {
                count++;
            }
        }
        if(peopleInQueue == 0 && count < wagons.size()){
            System.out.println("The lift has empty spots!");
            String toPrint = wagons.toString().replaceAll("[\\]\\[,]", "");
            toPrint = toPrint.replaceAll("\\s+", " ");
            System.out.println(toPrint);
        }
        if(peopleInQueue > 0 && count == wagons.size()){
            System.out.println("There isn't enough space! " + peopleInQueue + " people in a queue!");
            String toPrint = wagons.toString().replaceAll("[\\]\\[,]", "");
            toPrint = toPrint.replaceAll("\\s+", " ");
            System.out.println(toPrint);
        }
        if(count == wagons.size() && peopleInQueue == 0){
            String toPrint = wagons.toString().replaceAll("[\\]\\[,]", "");
            toPrint = toPrint.replaceAll("\\s+", " ");
            System.out.println(toPrint);
        }

    }
}



