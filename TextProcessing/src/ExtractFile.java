import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] input = sc.nextLine().split("\\\\");

        String fileName = input[input.length -1];

        String[] last = fileName.split("\\.");

        System.out.println("File name: " + last[0] );
        System.out.println("File extension: " + last[1]);
    }
}
