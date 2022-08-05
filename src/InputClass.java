import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class InputClass {
    static Scanner reader = new Scanner(System.in);
    static public String directory(){
        System.out.println("Enter path of directory");
        return reader.next();
    }
    static public String folder(){
        System.out.println("Enter Folder Name ");
        return reader.next();
    }
    static public String oldDirectoryName(){
        System.out.println("Enter path of old directory to Access Files");
        return reader.next();
    }
    static  public String oldFolderName(){
        System.out.println("Enter  old Folder Name to Access Files");
        return reader.next();
    }
    static public String renameFile(){
        System.out.println("Enter new Name of file for Rename");
        return reader.next();
    }
    static public String fileName(){
        System.out.println("Enter Name of file");
        return reader.next();
    }
}
