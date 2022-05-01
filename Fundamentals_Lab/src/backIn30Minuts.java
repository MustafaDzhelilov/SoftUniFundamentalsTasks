import java.util.Scanner;

public class backIn30Minuts {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int hour = Integer.parseInt(sc.nextLine());
            int minutes = Integer.parseInt(sc.nextLine());

            int minResult = minutes+30;


            if(minResult >=60){
                hour++;
                minResult=minResult-60;
            }
            if(hour > 23){
                hour=0;
            }

            System.out.printf("%d:%02d",hour,minResult);
        }
}
