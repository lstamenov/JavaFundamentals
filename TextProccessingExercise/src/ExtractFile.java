import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        String[] directory = new Scanner(System.in).nextLine().split("\\\\");

        String file = directory[3];
        String[] fileData = file.split("\\.");

        System.out.printf("File name: %s%n",fileData[0]);
        System.out.printf("File extension: %s",fileData[1]);
    }
}
