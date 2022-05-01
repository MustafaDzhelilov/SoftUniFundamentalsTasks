import java.util.Scanner;

public class login_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        StringBuilder passwordBuilder = new StringBuilder();

        for (int position = username.length() - 1;position >=0 ; position--) {
            char currentSymbol = username.charAt(position);
            passwordBuilder.append(currentSymbol);
        }
        String password = passwordBuilder.toString();
        String command = sc.nextLine();

        int count = 0;
        while (!command.equals(password)){
            count++;
            if(count==4){
                System.out.printf("User %s blocked!",username);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            command= sc.nextLine();
            if(command.equals(password)){
                System.out.printf("User %s logged in.",username);
            }
        }
    }
}
