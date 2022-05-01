import java.util.Scanner;

public class strongNumber_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int startNumber = number;

        int sumFact = 0;
        while(number !=0){
            // wzimame poslednata cifra na chisloto
            int digit = number % 10;
            // namirame faktorieala
            int fact = 1;
            for (int i = 1; i <= digit; i++) {
                fact = fact * i;
            }
            //sumirame
            sumFact +=fact;

            //premahvame poslednata cifra ot chisloto
            number /=10;
        }
        if(sumFact == startNumber){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
