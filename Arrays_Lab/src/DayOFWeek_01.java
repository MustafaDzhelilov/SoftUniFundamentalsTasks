import java.util.Scanner;

public class DayOFWeek_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        String[] dayOfWeek  = {"Monday", "Tuesday" , "Wednesday" , "Thursday" , "Friday" , "Saturday", "Sunday"};

        int  n = Integer.parseInt(sc.nextLine());

        if( n >= 1 && n <=7){
            System.out.println(dayOfWeek[n-1]);
        }else{
            System.out.println("Invalid day!");
        }


    }
}
