import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
public class MainFileHandlingClass {
    static File directory, textFile;
    static FileOutputStream fout;
    static boolean success = false;
    static String dir, folderName, fileName;
    static File finalDirectory;
    private static void inputOperations() {
        dir = InputClass.directory();
        folderName = InputClass.folder();
        directory = new File(dir + "/" + folderName);
    }
    private static File fileFolderName() {
        return new File(directory + "/" + fileName + ".txt");
    }
    private static File directoryFolderName() {
        return new File(dir + "/" + folderName);
    }
    static void folderCreate() {
        inputOperations();
        System.out.println(directory);
        if (directory.exists()) {
            throw new FileFolderCreatedException("Folder All ready Exist ");
        }
        System.out.println("Directory not exists, creating now.......");
        success = directory.mkdir();
        if (!success) {
            throw new FileFolderCreatedException("Folder not Created");
        }
        System.out.printf("Successfully created new directory : %s%s%n", dir, folderName);
        try {
            fileName = InputClass.fileName();
            textFile = fileFolderName();
            if (textFile.exists()) {
                throw new FileFolderCreatedException("File already exists.....");
            }
                System.out.println("No such file exists, creating now......");
                success = textFile.createNewFile();
                if (success) {
                    System.out.printf("Successfully created new file: %s%n", textFile);
                } else {
                    throw new FileFolderCreatedException("File not SuccessFully Created");
                }
            // Write the data in file
            fout = new FileOutputStream(textFile);
            String s = "I am completing Java Training Module";
            byte[] b = s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("successfully save.");
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    //new Folder Creation Again
    static void newFolderCreation() throws IOException {
        inputOperations();
        if (directory.exists()) {
            throw new FileFolderCreatedException("Folder All ready Exist Created");
        }
            System.out.println("Directory not exists, creating now......");
            success = directory.mkdir();
            if (success) {
                System.out.printf("Successfully created new directory : %s%s%n", dir, folderName);
                dir = InputClass.oldDirectoryName();
                folderName = InputClass.oldFolderName();
                File[] listOfFiles = null;
                File folder = null;
                folder =directoryFolderName();
                listOfFiles = folder.listFiles();
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        finalDirectory = new File(directory + "/" + file.getName());
                        try {
                            Files.copy(file.toPath(), finalDirectory.toPath());
                            System.out.println("successfully Copy File. from Old Directory");
                            PrintWriter printWriter = new PrintWriter(new FileOutputStream(finalDirectory, true));
                            String s = "I am in progress to complete it";
                            final String newLine = System.getProperty("line.separator");
                            printWriter.write(newLine + s);
                            printWriter.close();
                            fileName = InputClass.renameFile();
                            File newName = fileFolderName();
                            boolean renamed = finalDirectory.renameTo(newName);
                            if (!renamed) {
                                throw new FileFolderCreatedException("SuccessFully not Saved");
                            }
                            System.out.println("successfully save.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                throw new FileFolderCreatedException("Folder not Created");
            }
    }
    static void deleteFunc() throws FileNotFoundException {
      inputOperations();
        if (!directory.exists()) {
            throw new FileFolderCreatedException("Folder not Exist");
        }

        if (directory.exists()) {
            fileName = InputClass.fileName();
            textFile = fileFolderName();
            if (textFile.exists()) {
                System.out.println("successfully deleted");
                textFile.delete();
            } else {
                throw new FileFolderCreatedException("File not Exist ...");
            }
        }

    }
}

