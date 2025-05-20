import java.io.File;// Importing File class to work with files and directories
import java.io.IOException;// Handles exceptions related to file operations

public class ShellCommandHandler {
    private File currentDirectory;

    public ShellCommandHandler() {
        currentDirectory = new File(System.getProperty("user.dir"));
    }
//====================(1)===============================
    public void printWorkingDirectory() {// Prints the absolute path of the current directory
        System.out.println(currentDirectory.getAbsolutePath());
    }
    //====================(2)===============================
    public void listDirectory() { // Lists all files and directories in the current directory
        File [] files = currentDirectory.listFiles();
        if(files!=null){
            for(int i = 0; i<files.length; i++){
                if(files[i].isDirectory()){
                    System.out.println("[DIR]"+files[i].getName()); // If it's a directory
                }
                else if(files[i].isFile()){
                    System.out.println("[FILE]"+files[i].getName());// If it's a file
                }
            }
        }
        else {
            System.out.println("This folder is empty or cannot be read");
        }
    }
    //====================(3)===============================
    public void changeDirectory(String name) {// Changes the current working directory
        if(name==null){// If name is null, show usage message: "Usage: cd [directory_name]"
            System.out.println("Usage: cd [directory_name]");
        } else if (name.equals("..")) {  // If name is "..", move to parent directory if possible
            File parent = currentDirectory.getParentFile();
            if(parent!=null&&parent.exists()){  // Otherwise, try to move to the specified directory

                currentDirectory=parent;
                System.out.println("Moved to: "+currentDirectory.getAbsolutePath());
            }
            else {

                System.out.println("No parent directory");
            }
        }
        else {// If directory doesn't exist, print error message: "Directory not found: [name]"
            File file = new File(currentDirectory,name);
            if(file.exists()&&file.isDirectory()){
                currentDirectory=file;
                System.out.println("Moved to: "+currentDirectory.getAbsolutePath());
            }
            else {
                System.out.println("Directory not found: "+name);
            }
        }
    }
    //====================(4)===============================
    public void makeDirectory(String name) {
        // If name is null, show usage message: "Usage: mkdir [directory_name]"
        if (name == null){
            System.out.println("Usage: mkdir [directory_name]");
            return;
        }
        // If directory already exists, print: "Directory already exists."
        File FUN4 = new File(currentDirectory , name) ;
        if(FUN4.exists()){
            System.out.println("Directory already exists");
            return;
        }
        // If directory creation is successful, print: "Directory created: [name]"
        // If directory creation fails, print: "Failed to create directory."
        else if (FUN4.mkdir()){
            System.out.println("Directory created: " + "[" + name+ "]");

        }
        else System.out.println("Failed to create directory.");

    }
    //====================(5)===============================
    public void createFile(String name) {// Creates a new empty file in the current directory
        if (name == null) {// If name is null, show usage message: "Usage: touch [file_name]"

            System.out.println("Usage: touch [file_name]");
        } else {
            try {
                File file = new File(currentDirectory, name); // If file already exists, print: "File already exists."

                if (file.exists()) {
                    System.out.println("File already exists.");
                } else {
                    boolean created = file.createNewFile();
                    if (created) {// If file creation is successful, print: "File created: [name]"

                        System.out.println("File created: " + name);
                    } else {
                        System.out.println("Failed to create file: " + name);
                    }
                }
            } catch (IOException e) {
                System.out.println("Failed to create file: " + name);
                System.out.println("Error details:   " +e.getMessage());//If file creation fails, print error message with exception details

            }
        }
    }
    //====================(6)===============================
    public void printHelp() {// Prints help information about available commands

        System.out.println("Available commands:");
        System.out.println("1. pwd - Shows the current directory.");
        System.out.println("2. ls - Lists all files and directories in the current directory.");
        System.out.println("3. cd [dir] - Changes to a specific directory. Use '..' to go up one level.");
        System.out.println("4. mkdir [dir] - Creates a new directory.");
        System.out.println("5. touch [file] - Creates a new file.");
        System.out.println("6. help - Shows this help information.");
        System.out.println("7. exit - Exits the program.");
    }
    //====================(7)===============================
    public File getCurrentDirectory() { // Returns the current working directory
        return currentDirectory;
    }
}