import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniPlaning_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> lessons = Arrays.stream(sc.nextLine().split(", "))
                        .collect(Collectors.toList());

        String input = sc.nextLine();

        while(!input.equals("course start")){
            String [] tokens = input.split(":");

            switch (tokens[0]){
                case "Add":
                    if(!lessons.contains(tokens[0])){
                        lessons.add(tokens[1]);
                    }
                    break;
                case "Insert":
                    if(!lessons.contains(tokens[1])){
                        lessons.add(Integer.parseInt(tokens[2]), tokens[1]);
                    }
                    break;
                case "Remove":
                    if(!lessons.contains(tokens[1])){
                        break;
                    }else{
                        lessons.remove(tokens[1]);
                    }

                    break;
                case "Swap":
                    //Swap:Lists:Databases -> [ Swap, Lists, Databases ]
                    if(lessons.contains(tokens[1]) && lessons.contains(tokens[2])){
                        String lesson1 = input.split(":")[1];
                        String lesson2 = input.split(":")[2];
                        int index1 = lessons.indexOf(lesson1);
                        int index2 = lessons.indexOf(lesson2);
                        lessons.set(index1,lesson2);
                        lessons.set(index2,lesson1);
                    }
                    break;
                case "Exercise":
                    //Exercise:{lessonTitle} -> [exercise, lessonTitle ]
                    //Ако предмета го има добавяме (предмета - Exercise), след индекса на предмета.
                    // Ако предмета го няма Добавяме Lesson и след него Lesson - Exercise в края на листа.
                    int indexOfless  = lessons.indexOf(tokens[1]);
                    if(lessons.contains(tokens[1])){
                        if(indexOfless == lessons.size() -1){
                            int indexOfCurrentLesson = lessons.indexOf(tokens[1]);
                            lessons.add(indexOfCurrentLesson + 1,tokens[1] + "-Exercise");
                        }
                        else if (!lessons.get(indexOfless + 1).equals(tokens[1] + "-Exercise")){
                            int indexOfCurrentLesson = lessons.indexOf(tokens[1]);
                            lessons.add(indexOfCurrentLesson + 1,tokens[1] + "-Exercise");
                        }

                    }else if(!lessons.contains(tokens[1])){
                        lessons.add(tokens[1]);
                        lessons.add(tokens[1] + "-Exercise");
                    }
                    break;

            }
            input = sc.nextLine();
        }
        int i = 0;
        for (String lesson : lessons) {
            i++;
            System.out.println(i + "." + lesson);
        }
    }
}
