import java.util.Scanner;

public class TreasureFinder_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] key = sc.nextLine().split(" ");
        String message = sc.nextLine();
        StringBuilder help = new StringBuilder();
        String decryptedMessage = "";
        int difBetweenLength = 0;
        String newKey = "";
        String keyToString = "";

        while (!message.equals("find")){

            if(key.length < message.length()){
                if(message.length() % key.length == 0){
                    difBetweenLength = message.length() - key.length;
                    for (int i = 0; i <difBetweenLength / key.length ; i++) {
                        keyToString = String.join("", key);
                        help.append(keyToString);
                    }
                    help.append(keyToString); // добавяме още веднъж заради самия ключ
                    newKey = help.toString();
                    help.delete(0,help.length());

                }else if(message.length() % key.length != 0){
                    difBetweenLength = message.length() - key.length;
                    int residue = message.length() % key.length;
                    keyToString = String.join("", key);
                    String residueToString = keyToString.substring(0, residue);

                    for (int i = 0; i < ((difBetweenLength - residue) / key.length) ; i++) {
                        help.append(keyToString);
                    }
                    help.append(keyToString); // добавяме още веднъж заради самия ключ
                    help.append(residueToString);
                    newKey = help.toString();
                    help.delete(0,help.length());
                }

            }
            if(message.length() == newKey.length()){
                for (int i = 0; i < message.length(); i++) {
                    char symbolFromMessage = message.charAt(i);
                    int numberFromKey = Integer.parseInt(newKey.substring(i, i + 1));
                    int difBetweenCharacter = symbolFromMessage - numberFromKey;
                    symbolFromMessage = (char)difBetweenCharacter;
                    help.append(symbolFromMessage);
                }
                decryptedMessage = help.toString();
                help.delete(0,help.length());
            }
            String type = decryptedMessage.split("&")[1];
            String coordinate = decryptedMessage.substring((decryptedMessage.indexOf('<') + 1), decryptedMessage.indexOf('>'));
            System.out.println("Found " + type + " at " + coordinate);

            message = sc.nextLine();
        }
    }
}
