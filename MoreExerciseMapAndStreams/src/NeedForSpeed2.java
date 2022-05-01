import java.util.*;

public class NeedForSpeed2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> carMileage = new TreeMap<>();
        Map<String, Integer> carFuel = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] carThemselves = sc.nextLine().split("\\|");
           // {car}|{mileage}|{fuel}
            String car = carThemselves[0];
            int mileage = Integer.parseInt(carThemselves[1]);
            int fuel = Integer.parseInt(carThemselves[2]);

            carMileage.put(car, mileage);
            carFuel.put(car, fuel);
        }
        String command = sc.nextLine();

        while (!command.equals("Stop")){
            String[] splitCommand = command.split(" : ");
            String commandName = splitCommand[0];
            String carName = splitCommand[1];

            switch (commandName){
                case "Drive":
                    int distance = Integer.parseInt(splitCommand[2]);
                    int commandFuel = Integer.parseInt(splitCommand[3]);
                    int currentMileage = carMileage.get(carName);
                    int currentFuel = carFuel.get(carName);
                    if(currentFuel >= commandFuel){
                        currentFuel = currentFuel - commandFuel;
                        carFuel.put(carName, currentFuel);
                        currentMileage = currentMileage + distance;
                        carMileage.put(carName, currentMileage);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",carName,distance,commandFuel);
                    }else{
                        System.out.printf("Not enough fuel to make that ride%n");
                    }
                    if(carMileage.get(carName) >= 100000){
                        carFuel.remove(carName);
                        carMileage.remove(carName);
                        System.out.printf("Time to sell the %s!%n",carName);
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(splitCommand[2]);
                    int currentFuell = carFuel.get(carName);
                    int max = 0;
                    if(currentFuell + refuel > 75){
                        max = 75;
                        carFuel.put(carName,max);
                    }else{
                        max = currentFuell + refuel;
                        carFuel.put(carName,max);
                    }
                    System.out.printf("%s refueled with %d liters%n",carName, max - currentFuell);
                    break;
                case "Revert":
                    int kilometars = Integer.parseInt(splitCommand[2]);
                    int currentKilometars= carMileage.get(carName);
                    currentKilometars = currentKilometars - kilometars;
                    carMileage.put(carName,currentKilometars);
                    System.out.printf("%s mileage decreased by %d kilometers%n",carName,kilometars);
                    currentKilometars = carMileage.get(carName);
                    if(currentKilometars < 10000){
                        currentKilometars = 10000;
                        carMileage.put(carName,currentKilometars);
                    }
                    break;
            }
            command = sc.nextLine();
        }
        //"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."

        carMileage.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(a -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",a.getKey(), a.getValue(), carFuel.get(a.getKey())));
    }
}
