import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(sc.nextLine());

        String command = sc.nextLine();
        int countForIncrease = 0;

        while (!command.equals("End of battle")){
            int toInteger = Integer.parseInt(command);
            if(initialEnergy - toInteger < 0){
                System.out.printf("Not enough energy! Game ends with %d won battles and 0 energy",countForIncrease);
                break;
            }
            countForIncrease++;
                initialEnergy -=toInteger;
                if(countForIncrease % 3 == 0){
                    initialEnergy = initialEnergy + countForIncrease;
                }
            command = sc.nextLine();
        }
        if(initialEnergy > 0){
            System.out.printf("Won battles: %d. Energy left: %d",countForIncrease,initialEnergy);
        }

    }
}
