import java.util.Scanner;

public class rageExpenses_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countLostGame = Integer.parseInt(sc.nextLine());
        double headsetPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());
        double keyboardPrice = Double.parseDouble(sc.nextLine());
        double displayPrice = Double.parseDouble(sc.nextLine());

        double sumHeadset = Math.floor(1.0 * countLostGame / 2) * headsetPrice;
        double sumMouse = Math.floor(1.0 * countLostGame / 3) * mousePrice;
        double sumKeyboard = Math.floor(1.0 * countLostGame /6) * keyboardPrice;
        double sumDisplay = Math.floor(1.0 * countLostGame / 12) * displayPrice;

        double allExpenses = sumHeadset + sumMouse + sumKeyboard + sumDisplay;

        System.out.printf("Rage expenses: %.2f lv.",allExpenses);
    }
}
