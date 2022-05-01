import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FinalExamPavcho_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Map<String, Integer> likes = new TreeMap<>();
        Map<String, Integer> comments = new TreeMap<>();

        String command = sc.nextLine();

        while (!command.equals("Log out")){
            String [] tokens = command.split(":\\s+");
            String commandType = tokens[0];
            String username = tokens[1];


            switch (commandType){
                case "New follower":
                    if(likes.containsKey(username)){
                        break;
                    }else {
                        likes.put(username,0);
                        comments.put(username,0);
                    }
                    break;
                case "Like":
                    int countOfLike = Integer.parseInt(tokens[2]);
                    if (likes.containsKey(username)){
                        int currentLikes = likes.get(username) + countOfLike;
                        likes.put(username, currentLikes);
                    }else {
                        likes.put(username,countOfLike);
                        comments.put(username,0);
                    }

                    break;
                case "Comment":

                    if (comments.containsKey(username)){
                        int currentComments= comments.get(username) + 1;
                        comments.put(username, currentComments);
                    }else {
                        comments.put(username,1);
                        likes.put(username,0);
                    }
                    break;
                case "Blocked":
                    String usernameB = tokens[1];

                    if(likes.containsKey(usernameB) && comments.containsKey(usernameB)){
                        likes.remove(usernameB);
                        comments.remove(usernameB);
                    }else {
                        System.out.println(usernameB +" doesn't exist.");
                    }
                    break;
            }

            command = sc.nextLine();
        }
        Map<String, Integer> total = new TreeMap<>();
        for (Map.Entry<String,Integer> entry : comments.entrySet()){
            total.put(entry.getKey(), (likes.get(entry.getKey())+ comments.get(entry.getKey())));
        }
        System.out.println(likes.size() + " followers");
        total.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(users -> {
                    System.out.printf("%s: %d%n",users.getKey(), users.getValue());
                });

    }
}
