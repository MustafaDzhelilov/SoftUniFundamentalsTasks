import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                        .map(Integer::parseInt).collect(Collectors.toList());

        String command = sc.nextLine();
        int shoot = -1;

        while (!command.equals("End")){
            int index = Integer.parseInt(command);

            if(index < numbers.size()){
                int currentNumber = numbers.get(index);
                numbers.remove(index);
                for (int i = 0; i < numbers.size(); i++) {
                    int n = numbers.get(i);
                    if(n == -1){

                    }else{
                        if(n > currentNumber){
                            n= n - currentNumber;
                            numbers.set(i,n);
                        }else if(n < currentNumber){
                            n = n + currentNumber;
                            numbers.set(i,n);
                        }else if(n == currentNumber){
                            n = n + currentNumber;
                            numbers.set(i,n);
                        }
                    }
                }
                currentNumber = shoot;
                numbers.add(index,currentNumber);
            }
            command = sc.nextLine();
        }
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int m = numbers.get(i);
            if(m == -1){
                count++;
            }
        }
        String toPrint = numbers.toString().replaceAll("[\\]\\[,]", "");
        toPrint = toPrint.replaceAll("\\s+"," ");
        System.out.printf("Shot targets: %d -> %s",count,toPrint);
    }
}
