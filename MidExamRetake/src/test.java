import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> friends = Arrays.stream(sc.nextLine().split(", "))
                        .collect(Collectors.toList());

        String command = sc.nextLine();

        while (!command.equals("Report")){
            String [] tokens = command.split(" ");
            String currentCommand = tokens[0];

            switch (currentCommand){
                case "Blacklist":
                    String stringSecond = tokens[1];
                    if(friends.contains(stringSecond)){
                        String newName = "Blacklisted";
                        int index = friends.indexOf(stringSecond);
                        friends.set(index,newName);
                        System.out.println( stringSecond + " was blacklisted.");
                    }else{
                        System.out.println(stringSecond + "was not found.");
                    }
                    break;
                case "Error":
                    int in = Integer.parseInt(tokens[1]);
                    String name = friends.get(in);
                    if(!(name.equals("Blacklisted")) && !(name.equals("Lost"))){
                        String lost = "Lost";
                        int index1 = friends.indexOf(name);
                        friends.set(index1,lost);
                        System.out.println(name + " was lost due to an error.");
                    }
                    break;
                case "Change":
                    int currIndex = Integer.parseInt(tokens[1]);
                    String crNM = tokens[1];
                    String newNm = tokens[2];
                    if(!(currIndex < 0)  && !(currIndex > friends.size()) ){
                        System.out.println(friends.get(currIndex) + " changed his username to "+ newNm);
                        friends.set(currIndex,newNm);
                    }
                    break;

            }

            command = sc.nextLine();
        }
        int countBl = 0;
        int countLs = 0;
        for (int i = 0; i < friends.size(); i++) {
            String n = friends.get(i);
            if(n.equals("Blacklisted")){
                countBl++;
            }else if(n.equals("Lost")){
                countLs++;
            }
        }
        System.out.println("Blacklisted names: "+countBl);
        System.out.println("Lost names: "+countLs);
        String toPrint = friends.toString().replaceAll("[\\]\\[,]", "");
        toPrint = toPrint.replaceAll("\\s+", " ");
        System.out.println(toPrint);
    }

}
