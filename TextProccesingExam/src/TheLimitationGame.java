import java.util.Scanner;

public class TheLimitationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String encryptedMessage = sc.nextLine();
        String command = sc.nextLine();

        while (!command.equals("Decode")){
            String [] splitCommand = command.split("\\|");
            String instruction = splitCommand[0];

            switch (instruction){
                case "Move":
                    int numberForMove = Integer.parseInt(splitCommand[1]);
                    String substring = encryptedMessage.substring(0,(numberForMove));
                    String endOfString = encryptedMessage.substring(numberForMove);
                    StringBuilder help = new StringBuilder();
                    help.append(endOfString);
                    help.append(substring);
                    encryptedMessage = help.toString();
                    help.delete(0,help.length());
                    break;
                case "Insert":
                    int iexToInsert = Integer.parseInt(splitCommand[1]);
                    String strToInsert = splitCommand[2];
                    StringBuilder helpToInsert = new StringBuilder();
                    helpToInsert.append(encryptedMessage);
                    helpToInsert.insert(iexToInsert, strToInsert);
                    encryptedMessage = helpToInsert.toString();
                    helpToInsert.delete(0,helpToInsert.length());
                    break;
                case "ChangeAll":
                    String oldSymbol = splitCommand[1];
                    String newSymbol = splitCommand[2];
                    char old = oldSymbol.charAt(oldSymbol.length()-1);
                    char newS = newSymbol.charAt(newSymbol.length()-1);
                    encryptedMessage =encryptedMessage.replace(old,newS);
                    break;
            }

            command = sc.nextLine();
        }
        System.out.println("The decrypted message is: "+ encryptedMessage);
    }
}
