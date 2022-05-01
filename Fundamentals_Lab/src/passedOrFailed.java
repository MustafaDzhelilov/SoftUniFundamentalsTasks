import java.util.Scanner;

public class passedOrFailed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double grade = Double.parseDouble(sc.nextLine());

        if(grade >= 3.00){
            System.out.printf("Passed!");
        }else{
            System.out.printf("Failed!");
        }
    }
}

