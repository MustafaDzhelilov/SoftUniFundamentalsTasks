import java.util.Scanner;

public class padawanEquipment_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double amount = Double.parseDouble(sc.nextLine());
        int countOfStudents = Integer.parseInt(sc.nextLine());
        double priceOfLightsaber = Double.parseDouble(sc.nextLine());
        double priceOfRobes = Double.parseDouble(sc.nextLine());
        double priceOfBelts = Double.parseDouble(sc.nextLine());


        double sumofLight = priceOfLightsaber * Math.ceil(countOfStudents * 1.1);
        double sumOfRobes = priceOfRobes * countOfStudents;
        double sumOfBelts = (countOfStudents - countOfStudents /6) * priceOfBelts ;

        double sumAll = sumofLight + sumOfRobes + sumOfBelts;
        if(sumAll <= amount){
            System.out.printf("The money is enough - it would cost %.2flv.%n",sumAll);
        }else{
            System.out.printf("Ivan Cho will need %.2flv more.",sumAll - amount);
        }
    }
}
