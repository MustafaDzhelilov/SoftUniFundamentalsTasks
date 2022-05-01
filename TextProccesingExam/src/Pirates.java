import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<String, List<Integer>> cities = new HashMap<>();

        while (!input.equals("Sail")){
            String [] tokensInput = input.split("\\|\\|");
            String city = tokensInput[0];
            int countOfPeople = Integer.parseInt(tokensInput[1]);
            int gold = Integer.parseInt(tokensInput[2]);
            if(!cities.containsKey(city)) {
                cities.put(city, new ArrayList<>());
                cities.get(city).add(countOfPeople);
                cities.get(city).add(gold);
            }else{
                int currentPeople = cities.get(city).get(0);
                int currentGold = cities.get(city).get(1);
                cities.get(city).set(0,currentPeople + countOfPeople);
                cities.get(city).set(1,currentGold + gold);
            }

            input = sc.nextLine();
        }

        String command = sc.nextLine();

        while (!command.equals("End")){
            String [] tokensCommand = command.split("=>");
            String commandName = tokensCommand[0];
            String commandCity = tokensCommand[1];

            switch (commandName){
                case "Plunder":
                    int commandPeople = Integer.parseInt(tokensCommand[2]);
                    int commandGold = Integer.parseInt(tokensCommand[3]);
                    int currentCountPeople = cities.get(commandCity).get(0);
                    int currentAmountGold = cities.get(commandCity).get(1);
                    cities.get(commandCity).set(0,currentCountPeople - commandPeople);
                    cities.get(commandCity).set(1, currentAmountGold - commandGold);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", commandCity, commandGold, commandPeople);

                    int currentPeople = cities.get(commandCity).get(0);
                    int currentGold = cities.get(commandCity).get(1);

                    if(currentPeople <= 0 || currentGold <= 0){
                        System.out.printf("%s has been wiped off the map!%n",commandCity);
                        cities.remove(commandCity);
                    }
                    break;
                case "Prosper":
                    int prosperGold = Integer.parseInt(tokensCommand[2]);
                    if(prosperGold < 0){
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }else if(prosperGold > 0){
                        int currentKgGold = cities.get(commandCity).get(1);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", prosperGold, commandCity, currentKgGold + prosperGold);
                        cities.get(commandCity).set(1, currentKgGold + prosperGold);
                    }
                    break;
            }

            command = sc.nextLine();
        }
        int mapSize = cities.size();
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",mapSize);
       // {town1} -> Population: {people} citizens, Gold: {gold} kg
        cities.entrySet().stream().sorted((h1, h2) -> Integer.compare(h2.getValue().get(1),h1.getValue().get(1))).forEach((kvp -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1))));
    }
}

/* cities.entrySet().stream().sorted((left, right) -> {
            int result = right.getValue().get(1).compareTo(left.getValue().get(1));
            if(result == 0){
                result = left.getKey().compareTo(right.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));

        */
