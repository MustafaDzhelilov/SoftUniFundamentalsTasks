    import java.util.Scanner;

    public class FinalExam_01 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String input = sc.nextLine();

            String command = sc.nextLine();

            while (!command.equals("Finish")){
                String [] tokens = command.split(" ");
                String commandType = tokens[0];

                switch (commandType){
                    case "Replace":
                        String old = tokens[1];
                        String newString = tokens[2];
                        if(input.contains(old)) {
                            input = input.replace(old, newString);
                            System.out.println(input);
                        }else{
                            continue;
                        }
                        break;
                    case "Cut":
                        int start = Integer.parseInt(tokens[1]);
                        int end = Integer.parseInt(tokens[2]);

                      /*  if(start == 0 && end == input.length() - 1){
                            System.out.println("Invalid indices!");
                            break;
                        }

                       */
                        if(start >= 0 && end < input.length()){
                            String substrictFromRemove = input.substring(start,end + 1);
                            while (input.contains(substrictFromRemove)) {
                                input = input.replace(substrictFromRemove, "");
                            }
                            System.out.println(input);
                        }else{

                            System.out.println("Invalid indices!");
                        }
                        break;
                    case "Make":
                        String type = tokens[1];
                        if(type.equals("Upper")){
                            input = input.toUpperCase();
                            System.out.println(input);
                        }else if(type.equals("Lower")){
                            input = input.toLowerCase();
                            System.out.println(input);
                        }
                        break;
                    case "Check":
                        String currentString = tokens[1];
                        if(input.contains(currentString)){
                            System.out.println("Message contains " + currentString);
                        }else{
                            System.out.println("Message doesn't contain " + currentString);
                        }
                        break;
                    case "Sum":
                        int startIndex = Integer.parseInt(tokens[1]);
                        int endIndex = Integer.parseInt(tokens[2]);
                        int sum = 0;
                        if(startIndex >= 0 && endIndex < input.length()) {
                            for (int i = startIndex; i <= endIndex; i++) {
                                char symbol = input.charAt(i);
                                sum += symbol;
                            }
                            System.out.println(sum);
                        }else{
                            System.out.println("Invalid indices!");
                        }

                        break;


                }
                command = sc.nextLine();
            }

        }
    }
