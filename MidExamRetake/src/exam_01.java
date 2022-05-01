import java.util.Scanner;

public class exam_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double budget = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        double priceOfFlour = Double.parseDouble(sc.nextLine()); // package
        double priceOfEgg = Double.parseDouble(sc.nextLine()); // single egg
        double priceOfApron = Double.parseDouble(sc.nextLine()); //single apron

        int flour = students;

        for (int i = 1; i <= students ; i++) {
            if( i % 5 == 0){
                flour--;
            }
        }
        double fl = flour * priceOfFlour;
        double resApron = priceOfApron * Math.ceil(students + (students * 0.20));
        double resEgg = students * priceOfEgg * 10;

        double sum = resApron + resEgg +  fl;

        if(budget >= sum){
            System.out.printf("Items purchased for %.2f$.",sum);
        }else if(sum > budget){
           double res = Math.abs(budget - sum);
            System.out.printf("%.2f$ more needed.",res);
        }


    }
}
