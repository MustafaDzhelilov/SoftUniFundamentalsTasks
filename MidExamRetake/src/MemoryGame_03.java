import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> sequence = Arrays.stream(sc.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = sc.nextLine();

        int count= 0;
        String numberOne = "";
        String numberTwo = "";
        boolean isif = false;

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            String zeroIndex = tokens[0];
            String firstIndex = tokens[1];
            count++;

            if (Integer.parseInt(zeroIndex) >= 0 && Integer.parseInt(firstIndex) >= 0 && Integer.parseInt(zeroIndex) < sequence.size() && Integer.parseInt(firstIndex) < sequence.size()) {
                numberOne = sequence.get(Integer.parseInt(zeroIndex));
                numberTwo = sequence.get(Integer.parseInt(firstIndex));
                if (numberOne.equals(numberTwo)) {
                    sequence.remove(Integer.parseInt(zeroIndex));
                    int currentIndexOfNumberTwo = sequence.indexOf(numberTwo);
                    sequence.remove(Integer.parseInt(Integer.toString(currentIndexOfNumberTwo)));
                    System.out.printf("Congrats! You have found matching elements - %s!%n", numberOne);
                } else {
                    System.out.println("Try again!");
                }
            } else if (Integer.parseInt(zeroIndex) < 0 || Integer.parseInt(firstIndex) >= sequence.size() || Integer.parseInt(zeroIndex) >= sequence.size() || Integer.parseInt(firstIndex) < 0
                    || Integer.parseInt(zeroIndex) == Integer.parseInt(firstIndex)) {
                //TODO..
                int length = sequence.size() / 2;
                String a = "a";
                sequence.add(length, Integer.toString(-count) + a);
                sequence.add(length + 1, Integer.toString(-count) + a);
                System.out.println("Invalid input! Adding additional elements to the board");

            }

            command = sc.nextLine();

            if (sequence.isEmpty()) {
                if (!command.equals("end")) {
                    isif =true;
                    System.out.printf("You have won in %d turns!", count);
                    break;
                }
            } else {
                if (command.equals("end")) {
                    System.out.println("Sorry you lose :(");
                    if (!sequence.isEmpty()) {
                        String toPrint = sequence.toString().replaceAll("[\\]\\[,]", "");
                        toPrint = toPrint.replaceAll("\\s+", " ");
                        System.out.println(toPrint);
                    }
                }
            }
        }
            if (sequence.isEmpty()) {
                if(!isif){
                    System.out.printf("You have won in %d turns!", count);
                }
            }

    }
}

