import java.util.Scanner;

public class vendingMachine_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        double sum =0;

        while (!command.equals("Start")){
            double coins = Double.parseDouble(command);
            if(coins !=0.1 && coins !=0.2 && coins !=0.5 && coins !=1 && coins!=2){
                System.out.printf("Cannot accept %.2f",coins);
            }else{
                sum +=coins;
            }
            command = sc.nextLine();

        }
        String product = sc.nextLine();

        while (!product.equals("End")){
            boolean hasMoney = true;
            switch (product){
                case "Nuts":
                    if(sum < 2){
                        System.out.println("Sorry, not enough money");
                        hasMoney=false;
                    }else{
                        sum -=2;
                    }
                    break;
                case "Water":
                    if(sum < 0.7){
                        System.out.println("Sorry, not enough money");
                        hasMoney=false;
                    }else{
                        sum -=0.7;
                    }
                    break;
                case "Crisps":
                    if(sum < 1.5){
                        System.out.println("Sorry, not enough money");
                        hasMoney=false;
                    }else{
                        sum -=1.5;
                    }
                    break;
                case "Soda":
                    if(sum < 0.8){
                        System.out.println("Sorry, not enough money");
                        hasMoney=false;
                    }else{
                        sum -=0.8;
                    }
                    break;
                case "Coke":
                    if(sum < 1){
                        System.out.println("Sorry, not enough money");
                        hasMoney=false;
                    }else{
                        sum -=1;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    hasMoney = false;
                    break;
            }
            if(!hasMoney){
                product = sc.nextLine();
                continue;
            }
            System.out.printf("Purchased %s%n",product);
            product = sc.nextLine();
        }
        System.out.printf("Change: %.2f",sum);

    }
}
