import java.util.Scanner;

public class vacation_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countOfPeople = Integer.parseInt(sc.nextLine());
        String typeOfGroup = sc.nextLine();
        String typeOfDay = sc.nextLine();

        double price = 0;

        switch (typeOfDay){
            case "Friday":
                if(typeOfGroup.equals("Students")){
                    price =8.45;
                    if(countOfPeople >=30){
                        price = price-(price*0.15);
                    }
                    break;
                }
                if(typeOfGroup.equals("Business")){
                    price =10.90;
                    if(countOfPeople >=100){
                        countOfPeople = countOfPeople-10;
                    }
                    break;
                }
                if(typeOfGroup.equals("Regular")){
                    price =15;
                    if(countOfPeople >=10 && countOfPeople <=20){
                        price = price-(price*0.05);
                    }
                    break;
                }
            case "Saturday":
                if(typeOfGroup.equals("Students")){
                    price =9.80;
                    if(countOfPeople >=30){
                        price = price-(price*0.15);
                    }
                    break;
                }
                if(typeOfGroup.equals("Business")){
                    price =15.60;
                    if(countOfPeople >=100){
                        countOfPeople = countOfPeople-10;
                    }
                    break;
                }
                if(typeOfGroup.equals("Regular")){
                    price =20;
                    if(countOfPeople >=10 && countOfPeople <=20){
                        price = price-(price*0.05);
                    }
                    break;
                }
            case "Sunday":
                if(typeOfGroup.equals("Students")){
                    price =10.46;
                    if(countOfPeople >=30){
                        price = price-(price*0.15);
                    }
                    break;
                }
                if(typeOfGroup.equals("Business")){
                    price =16;
                    if(countOfPeople >=100){
                        countOfPeople = countOfPeople-10;
                    }
                    break;
                }
                if(typeOfGroup.equals("Regular")){
                    price =22.50;
                    if(countOfPeople >=10 && countOfPeople <=20){
                        price = price-(price*0.05);
                    }
                    break;
                }

        }
        double sum = countOfPeople * price;
        System.out.printf("Total price: %.2f",sum);

    }
}
