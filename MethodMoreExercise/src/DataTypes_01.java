import java.util.Scanner;

public class DataTypes_01 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);

        String typeOfNumber = sc.nextLine();
        String number = sc.nextLine();

        if(typeOfNumber.equals("int")){
           int i  = Integer.parseInt(number);
            i = i * 2;
            System.out.println(i);
        }else if(typeOfNumber.equals("real")){
            double i = Double.parseDouble(number);
            i = i  * 1.5;
            System.out.printf("%.2f",i);
        }else if(typeOfNumber.equals("string")){
            System.out.printf("$%s$",number);
        }
    }
}
