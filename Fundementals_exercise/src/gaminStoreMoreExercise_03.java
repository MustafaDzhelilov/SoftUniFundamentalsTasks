import java.util.Scanner;

public class gaminStoreMoreExercise_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double currentBalance = Double.parseDouble(sc.nextLine());
        double price = 0;
        double sumBought = 0;
        String game = sc.nextLine();

        while (!game.equals("Game Time")){


            switch (game){
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    if(price > currentBalance){
                        price=0;
                        System.out.println("Too Expensive");
                    }else{
                        System.out.printf("Bought %s%n",game);
                    }
                    break;
                case "CS: OG":
                    price = 15.99;
                    if(price > currentBalance){
                        price=0;
                        System.out.println("Too Expensive");
                    }else{
                        System.out.printf("Bought %s%n",game);
                    }
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    if(price > currentBalance){
                        price=0;
                        System.out.println("Too Expensive");
                    }else{
                        System.out.printf("Bought %s%n",game);
                    }
                    break;
                case "Honored 2":
                    price = 59.99;
                    if(price > currentBalance){
                        price=0;
                        System.out.println("Too Expensive");
                    }else{
                        System.out.printf("Bought %s%n",game);
                    }
                    break;
                case "RoverWatch":
                    price = 29.99;
                    if(price > currentBalance){
                        price=0;
                        System.out.println("Too Expensive");
                    }else{
                        System.out.printf("Bought %s%n",game);
                    }
                    break;
                default:
                    System.out.println("Not Found");
            }

            currentBalance -=price;
            sumBought +=price;
            game= sc.nextLine();


                if(game.equals("Game Time")){
                    if(currentBalance <= 0) {
                        System.out.println("Out of money!");
                    }else {
                        double dif = Math.abs(currentBalance);
                        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", sumBought, dif);
                    }
                }
        }
    }
}
