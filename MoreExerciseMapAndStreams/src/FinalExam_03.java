import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FinalExam_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Map<String, Integer> sent = new TreeMap<>();
        Map<String, Integer> received = new TreeMap<>();

        int n = Integer.parseInt(sc.nextLine());

        String command = sc.nextLine();

        while (!command.equals("Statistics")){
            String [] tokens = command.split("=");
            String commandType = tokens[0];

            switch (commandType){
                case "Add":
                    String username = tokens[1];
                    int sentMessage = Integer.parseInt(tokens[2]);
                    int receivedMessage = Integer.parseInt(tokens[3]);
                    if(!sent.containsKey(username)){
                        sent.put(username, sentMessage);
                    }
                    if(!received.containsKey(username)){
                        received.put(username, receivedMessage);
                    }
                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];
                    if(sent.containsKey(sender) && received.containsKey(receiver)){
                        int intBefore = sent.get(sender);
                        sent.put(sender,intBefore + 1);
                        int intBeforeR = received.get(receiver);
                        received.put(receiver,intBeforeR + 1);
                        if((sent.get(sender) + received.get(sender)) == n){
                            sent.remove(sender);
                            received.remove(sender);
                            System.out.println(sender + " reached the capacity!");
                        }
                        if((received.get(receiver) + sent.get(receiver) == n)){
                            received.remove(receiver);
                            sent.remove(receiver);
                            System.out.println(receiver + " reached the capacity!");
                        }
                    }
                    break;
                case "Empty":
                    String usernameEmpty = tokens[1];
                    if(usernameEmpty.equals("All")){
                        sent.clear();
                        received.clear();
                    }
                    if(sent.containsKey(usernameEmpty) && received.containsKey(usernameEmpty)){
                        sent.remove(usernameEmpty);
                        received.remove(usernameEmpty);
                    }
                    break;
            }

            command = sc.nextLine();
        }
        System.out.println("Users count: " + received.size());

        received.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(users -> {
                    System.out.printf("%s - %d%n",users.getKey(), users.getValue() + sent.get(users.getKey()));
                });
    }
}
