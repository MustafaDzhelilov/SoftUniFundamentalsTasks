import java.util.Scanner;

public class monthPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = Integer.parseInt(sc.nextLine());

        if(month==1){
            System.out.printf("January");
        }
        else if(month==2){
            System.out.printf("February");
        }else if(month==3){
            System.out.printf("March");
        }else if(month==4){
            System.out.printf("April");
        }else if(month==5){
            System.out.printf("May");
        }else if(month==6){
            System.out.printf("June");
        }else if(month==7){
            System.out.printf("July");
        }else if(month==8){
            System.out.printf("August");
        }else if(month==9){
            System.out.printf("September");
        }else if(month==10){
            System.out.printf("October");
        }else if(month==11){
            System.out.printf("November");
        }else if(month==12){
            System.out.printf("December");
        }
        if(month < 1 || month > 12){
            System.out.printf("Error!");
        }
    }
}
