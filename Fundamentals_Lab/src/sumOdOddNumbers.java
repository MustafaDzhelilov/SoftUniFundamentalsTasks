import java.util.Scanner;

public class sumOdOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());
        int sum = 0;
        int count = 0;
        for (int i = 1; i <=100; i+=2) {
            count++;

            if(count>number){
                break;
            }
            sum=sum+i;
            System.out.println(i);
        }
        System.out.printf("Sum: %d",sum);
    }
}
