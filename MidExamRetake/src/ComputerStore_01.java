import java.util.Scanner;

public class ComputerStore_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String typeOfClient = sc.nextLine();
        double sum = 0;

        while (typeOfClient.equals("regular") || typeOfClient.equals("special")){
           int price = Integer.parseInt(typeOfClient);

           if(price > 0){
               sum +=price;
           }else{
               System.out.println("Invalid price!");
           }

            typeOfClient = sc.nextLine();
        }
        double result = sum * 0.20;
        if(typeOfClient.equals("special")){
            sum = sum - sum * 0.10;
            if(sum <= 0){
                System.out.println("Invalid order!");
            }else{
                if(sum <= 0){
                    System.out.println("Invalid order!");
                }
                System.out.println("Congratulations you've just bought a new computer!");
                System.out.println("Price without taxes: " + sum+"$");
                System.out.println("Taxes: " + result+"$");
                System.out.println("-----------");
                System.out.print("Total price: " + (sum + result)+"$");
            }
        }
    }
}
