import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> contestAndPassword = new TreeMap<>();
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        Map<String, Integer> helpPoints = new LinkedHashMap<>();   // for a points total

        String input = sc.nextLine();

        while (!input.equals("end of contests")){
            String [] splitInput = input.split(":");
            String contestFromInput = splitInput[0];
            String passwordFromInput = splitInput[1];

                contestAndPassword.put(contestFromInput, passwordFromInput);

            input = sc.nextLine();
        }

        String command = sc.nextLine();

        while (!command.equals("end of submissions")){
            String[] splitCommand = command.split("=>");
            String contestFromCommand = splitCommand[0];
            String passwordFromCommand = splitCommand[1];
            String usernameFromCommand = splitCommand[2];
            int pointsFromCommand = Integer.parseInt(splitCommand[3]);

            // за потребителите
            if(contestAndPassword.containsKey(contestFromCommand) && contestAndPassword.get(contestFromCommand).equals(passwordFromCommand)){
                if(!users.containsKey(usernameFromCommand)){
                    users.put(usernameFromCommand, new LinkedHashMap<>());
                    users.get(usernameFromCommand).put(contestFromCommand, pointsFromCommand);
                }else{
                    Map<String, Integer> help = new LinkedHashMap<>();
                    help = users.get(usernameFromCommand);
                    if(help.containsKey(contestFromCommand)) {
                        if (pointsFromCommand > users.get(usernameFromCommand).get(contestFromCommand)) {
                            users.get(usernameFromCommand).put(contestFromCommand, pointsFromCommand);
                        } else {
                            command = sc.nextLine();
                            continue;
                        }
                    }else{
                        users.get(usernameFromCommand).put(contestFromCommand, pointsFromCommand);
                    }
                }
            }
            //за общия брой точки на даден участник --> със грешка
            if(!helpPoints.containsKey(usernameFromCommand) && contestAndPassword.containsKey(contestFromCommand)
                    && contestAndPassword.get(contestFromCommand).equals(passwordFromCommand)){
                helpPoints.put(usernameFromCommand, pointsFromCommand);
            }else if(helpPoints.containsKey(usernameFromCommand) && contestAndPassword.containsKey(contestFromCommand)
                    && contestAndPassword.get(contestFromCommand).equals(passwordFromCommand)){
                int pointsBefore = users.get(usernameFromCommand).get(contestFromCommand);
                if(pointsBefore == pointsFromCommand) {
                    int currentPoints = helpPoints.get(usernameFromCommand);
                    currentPoints += pointsFromCommand;
                    helpPoints.put(usernameFromCommand, currentPoints);
                }
            }
            command = sc.nextLine();
        }

        //Best candidate is {user} with total {total points} points.".
        int totalSum = 0;
        int sum = 0;
        String bestName ="";

        for (Map.Entry<String, Integer> entry : helpPoints.entrySet()) {
            sum += entry.getValue();
            if(sum > totalSum) {
                totalSum = sum;
                bestName = entry.getKey();
                sum =0;
            }
            }
        System.out.printf("Best candidate is %s with total %d points.%n",bestName , totalSum);

        //{user1 name}
        //#  {contest1} -> {points}
        //#  {contest2} -> {points}
        System.out.println("Ranking:");

        users.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });
        }
    }

// скрити тест
/* Java Advanced:funpass
Part Two Interview:success
Math Concept:asdasd
Java Web Basics:forrF
end of contests
Math Concept=>ispass=>Atanas=>290
Java Advanced=>funpass=>Atanas=>400
Java Advanced=>fun=>Atanas=>400
Part Two Interview=>success=>Atanas=>120
Part Two Interview=>success=>Atanas=>120
Java Advanced=>funpass=>Atanas=>90
Java Web Basics=>forrF=>Atanas=>280
Part Two Interview=>success=>Atanas=>0
Math Concept=>asdasd=>Atanas=>250
Java Advanced=>funpass=>Atanas=>120
Part Two Interview=>success=>Atanas=>200
end of submissions

 */