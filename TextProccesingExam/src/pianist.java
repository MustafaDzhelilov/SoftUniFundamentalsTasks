import java.util.*;

public class pianist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> pianoPieces = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] input = sc.nextLine().split("\\|");
            String pieces = input[0];
            String composer = input[1];
            String key = input[2];
            pianoPieces.put(pieces, new ArrayList<>());
            pianoPieces.get(pieces).add(composer);
            pianoPieces.get(pieces).add(key);
        }
        String command = sc.nextLine();

        while (!command.equals("Stop")){
            String [] tokens = command.split("\\|");
            String commandName = tokens[0];
            String piecesName = tokens[1];

            switch (commandName){
                case "Add":
                    String composerName = tokens[2];
                    String keyName = tokens[3];
                    if(pianoPieces.containsKey(piecesName)){
                        System.out.printf("%s is already in the collection!%n",piecesName);
                    }else{
                        pianoPieces.put(piecesName, new ArrayList<>());
                        pianoPieces.get(piecesName).add(composerName);
                        pianoPieces.get(piecesName).add(keyName);
                        System.out.printf("%s by %s in %s added to the collection!%n",piecesName, composerName, keyName);
                    }
                    break;
                case "Remove":
                    if(!pianoPieces.containsKey(piecesName)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piecesName);
                    }else{
                        pianoPieces.remove(piecesName);
                        System.out.printf("Successfully removed %s!%n",piecesName);
                    }
                    break;
                case "ChangeKey":
                    String newKey = tokens[2];
                    if(pianoPieces.containsKey(piecesName)){
                        pianoPieces.get(piecesName).set(1,newKey);
                        System.out.printf("Changed the key of %s to %s!%n",piecesName,newKey);
                    }else{
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piecesName);
                    }
                    break;
            }
            command = sc.nextLine();
        }
       // "{Piece} -> Composer: {composer}, Key: {key}"
        pianoPieces.entrySet().forEach((kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1))));
    }
}
