import java.util.Scanner;

public class BonusSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countOfStudents = Integer.parseInt(sc.nextLine());
        int countOfLectures = Integer.parseInt(sc.nextLine());
        int initialBonus = Integer.parseInt(sc.nextLine());

        double totalBonus = Double.MIN_VALUE;
        double winnerAttendances = Double.MIN_VALUE;

        for (int i = 0; i < countOfStudents ; i++) {
            double attendances = Double.parseDouble(sc.nextLine());

            double result = attendances / countOfLectures;
            int result1 = (5 + initialBonus);
            double sum = Math.round(result * result1);

            if(sum > totalBonus){
                totalBonus = sum;
                winnerAttendances = attendances;
            }

        }
        System.out.printf("Max Bonus: %.0f.%n", totalBonus );
        System.out.printf("The student has attended %.0f lectures.",winnerAttendances);
    }
}
