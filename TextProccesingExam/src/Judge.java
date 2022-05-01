import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Judge {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Map<String , Map<String , Integer>> courseInfo = new LinkedHashMap<>();

            String input = sc.nextLine();
            while (!input.equals("no more time")){
                String[] tokens = input.split(" -> ");
                String username = tokens[0];
                String contest = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                courseInfo.putIfAbsent(contest , new LinkedHashMap<>());
                courseInfo.get(contest).putIfAbsent(username , 0);
                if (courseInfo.get(contest).get(username) < points){
                    courseInfo.get(contest).put(username , points);
                }
                input = sc.nextLine();
            }
            int[] num = new int[1];
            courseInfo
                    .forEach((key, value) -> {
                        num[0] = 0;
                        System.out.printf("%s: %d participants%n", key, value.size());
                        value
                                .entrySet()
                                .stream()
                                .sorted((s1, s2) -> {
                                    int result = s2.getValue().compareTo(s1.getValue());
                                    if (result == 0) {
                                        result = s1.getKey().compareTo(s2.getKey());
                                    }
                                    return result;
                                })
                                .forEach(s -> System.out.printf("%d. %s <::> %d%n", ++num[0], s.getKey(), s.getValue()));
                    });
            Map<String , Integer> studentInfo = new HashMap<>();
            for (Map.Entry<String, Map<String , Integer>> current : courseInfo.entrySet()){
                for (Map.Entry<String, Integer> student: current.getValue().entrySet()){
                    studentInfo.putIfAbsent(student.getKey() , 0);
                    int newPoints = studentInfo.get(student.getKey()) + student.getValue();
                    studentInfo.put(student.getKey() , newPoints);
                }
            }
            System.out.println("Individual standings:");
            studentInfo
                    .entrySet()
                    .stream()
                    .sorted((s1,s2) -> {
                        num[0] = 0;
                        int result = s2.getValue().compareTo(s1.getValue());
                        if ( result == 0){
                            result = s1.getKey().compareTo(s2.getKey());
                        }
                        return result;
                    })
                    .forEach(s -> System.out.printf("%d. %s -> %d%n", ++num[0] , s.getKey() , s.getValue()));

        }
    }

