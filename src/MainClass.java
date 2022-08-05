import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainClass {
    static Scanner sc = new Scanner(System.in);
    static String choice;
    static void option() throws IOException {

        System.out.println("****************Enter Any Choice***************");
        System.out.println("Enter 1 for Create New Folder");
        System.out.println("Enter 2 for Create new folder and copy files to Old folder");
        System.out.println("Enter 3 for Delete File");
        System.out.println("Enter 4 for Exit");
        choice = sc.next();
        if (choice.equals("1")) {
            MainFileHandlingClass.folderCreate();
            option();
        } else if (choice.equals("2")) {
            MainFileHandlingClass.newFolderCreation();
            option();
        } else if (choice.equals("3")) {
            MainFileHandlingClass.deleteFunc();
            option();
        } else if (choice.equals("4")) {
            System.out.println("Good by");
            System.exit(0);
        } else {
            System.out.println("don't have this option please choice Available option");
            option();
        }
    }
    public static void main(String[] arr) throws IOException {
         option();
    }
}
