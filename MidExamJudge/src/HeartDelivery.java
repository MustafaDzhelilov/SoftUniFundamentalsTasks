import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = sc.nextLine();
        int currentIndex = 0;
        int indexToDecrease = 0;
        int count = 0;

        while (!command.equals("Love!")){
            String [] tokens = command.split(" ");
            String currentCommand = tokens[0];
            switch (currentCommand){
                case "Jump":

                    indexToDecrease = Integer.parseInt(tokens[1]);
                    indexToDecrease = indexToDecrease + currentIndex;

                    if(indexToDecrease >= numbers.size()){
                        indexToDecrease = 0;
                        int n = numbers.get(indexToDecrease);
                        if(n == 0){
                            System.out.println("Place " + indexToDecrease + " already had Valentine's day.");
                            break;
                        }
                        else if(n - 2 == 0){
                            n = n - 2;
                            numbers.set(indexToDecrease,n);
                            System.out.println("Place " + indexToDecrease + " has Valentine's day.");
                            break;
                        }else{
                            n = n - 2;
                            numbers.set(indexToDecrease,n);
                        }
                    }else{
                        int number = numbers.get(indexToDecrease);

                        if(number == 0){
                            System.out.println("Place " + indexToDecrease + " already had Valentine's day.");
                            break;
                        }
                        else if(number - 2 == 0){
                            number = number - 2;
                            numbers.set(indexToDecrease,number);
                            System.out.println("Place " + indexToDecrease + " has Valentine's day.");
                            break;
                        }else{
                            number = number - 2;
                            numbers.set(indexToDecrease,number);
                        }
                    }

                    break;
            }
            currentIndex = indexToDecrease;
            command = sc.nextLine();
        }
        System.out.println("Cupid's last position was " + indexToDecrease + ".");
        for (Integer number : numbers) {
            if (number == 0) {
                count++;
            }
        }
            if(count == numbers.size()){
                System.out.println("Mission was successful.");
            }else{
                int result = numbers.size() - count;
                System.out.println("Cupid has failed " + result + " places.");
            }


    }
}

