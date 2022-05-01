import java.util.Scanner;

public class theatrePromotion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String typeOfDay = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        int price = 0;

        switch (typeOfDay){
            case "Weekday":
                if(age >=0 && age <= 18){
                    price=12;
                }else if(age >18 && age <=64){
                    price=18;
                }else if(age >64 && age <=122){
                    price=12;
                }
                break;
            case "Weekend":
                if(age >=0 && age <= 18){
                    price=15;
                }else if(age >18 && age <=64){
                    price=20;
                }else if(age >64 && age <=122){
                    price=15;
                }
                break;
            case "Holiday":
                if(age >=0 && age <= 18){
                    price=5;
                }else if(age >18 && age <=64){
                    price=12;
                }else if(age >64 && age <=122){
                    price=10;
                }
                break;

        }
        if(age < 0 || age >122){
            System.out.printf("Error!");

        }else if(!typeOfDay.equals("Holiday")&&!typeOfDay.equals("Weekday")&&!typeOfDay.equals("Weekend")){
            System.out.printf("Error!");
        }
        else{
            System.out.printf("%d$",price);
        }

    }
}
