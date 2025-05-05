import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
    private File currentDirectory;

    public ShellCommandHandler() {
        // تخزين الموقع الحالي
        currentDirectory= new File( System.getProperty("user.dir"));
        // הקונסטרוקטור נוצר כדי לשמור את הערך ההתחלתי למשתנה currentDirectory

    }

    //========================( 1 )==============================
    public void printWorkingDirectory() {
        System.out.println(currentDirectory.getAbsolutePath());
    }
    //getAbsolutePath(): פונקציה שמחזירה את הנתיב המוחלט של קובץ או תיקייה
//=========================( 2 )==================================
    public void listDirectory() {
        // פונקציה להדפסת כל הקבצים והתיקיות בספריה הנוכחית
        File [] files = currentDirectory.listFiles();
        if(files != null){
            for (int i=0;i< files.length;i++){
                if(files[i].isDirectory()){
                    //isDirectory(): פונקציה זו בודקת אם האובייקט מתייחס לתיקיה. אם כן, היא מחזירה true, אחרת מחזירה false.
                    System.out.println("[DIR]" + files[i].getName());
                }
                else if (files[i].isFile()){
//isFile(): פונקציה זו בודקת אם האובייקט מתייחס לקובץ. אם כן, היא מחזירה true, אחרת מחזירה false.
                    System.out.println("[FILE]" + files[i].getName());


                }
            }
        }
        else System.out.println("null");
    }
    //=========================( 3 )=================================
    public void changeDirectory(String name) {
        // TODO: Implement the change directory command
        // If name is null, show usage message: "Usage: cd [directory_name]"
        if (name == null) {
            System.out.println("Usage: cd [directory_name]");
            return;
        }
        // If name is "..", move to parent directory if possible
        if (name.equals("..")) {
            File parent = currentDirectory.getParentFile();
            if (parent == null) {
                System.out.println("No parent directory");
            } else {
                currentDirectory = parent;
            }
        }


        // Otherwise, try to move to the specified directory

        // If directory doesn't exist, print error message: "Directory not found: [name]"
        else {
            File FUN3 = new File(currentDirectory, name);
            if (FUN3.exists() && FUN3.isDirectory()) {
                currentDirectory = FUN3;
            } else {
                System.out.println("Directory not found: "  +  "[" + name + "]");

            }
        }
    }
    //===========================( 4 )====================================
    public void makeDirectory(String name) {
        // TODO: Implement the make directory command
        // If name is null, show usage message: "Usage: mkdir [directory_name]"
        if (name == null){
            System.out.println("Usage: mkdir [directory_name]");
            return;
        }
        // If directory already exists, print: "Directory already exists."
        File FUN4 = new File(currentDirectory , name) ;
        if(FUN4.exists()){
            //exists(): פונקציה זו בודקת אם הקובץ או התיקיה קיימים במערכת. אם כן, מחזירה true, אחרת מחזירה false.
            System.out.println("Directory already exists");
            return;
        }
        // If directory creation is successful, print: "Directory created: [name]"
        // If directory creation fails, print: "Failed to create directory."
        else if (FUN4.mkdir()){
            //mkdir(): פונקציה זו יוצרת תיקיה בנתיב שנבחר.
            System.out.println("Directory created: " + "[" + name+ "]");

        }
        else System.out.println("Failed to create directory.");

    }
    //===============================( 5 )=====================================
    public void createFile(String name) {
        // TODO: Implement the create file command
        // If name is null, show usage message: "Usage: touch [file_name]"
        if(name==null){
            System.out.println("Usage: touch [file_name]");
        }
        // If file already exists, print: "File already exists."
        File FUN5 = new File(currentDirectory,name);
        if (FUN5.exists()){
            System.out.println("File already exists.");
        }
        else {
            // If file creation is successful, print: "File created: [name]"
            try {
                //ניסיון ליצור את הקובץ
                if (FUN5.createNewFile()){
                    System.out.println("File created:" + "[" + name+ "]");
                }
                else {
                    //   אם לא נוצר הקובץ ללא חריגה
                    // If file creation fails, print an error message
                    System.out.println(" Failed to create file.");
                }
            } catch (IOException e){
                //טיפול בשגיאה בעת יצירת הקובץ
                System.out.println("Error: " + e.getMessage());
            }
        }

        //If file creation fails, print error message with exception details




    }
    //=================================( 6 )=======================================
    public void printHelp() {
        //بنعرض كل كود مع وظيفته
        //printHelp(): הפונקציה מציגה את כל הפקודות הזמינות בתוכנית עם תיאור לכל פקודה.
        // TODO: Implement help command to print information about all available commands
        // List all commands with their descriptions

        System.out.println("Available commands:");
        System.out.println("1. pwd - Shows the current directory.");
        System.out.println("2. ls - Lists all files and directories in the current directory.");
        System.out.println("3. cd [dir] - Changes to a specific directory. Use '..' to go up one level.");
        System.out.println("4. mkdir [dir] - Creates a new directory.");
        System.out.println("5. touch [file] - Creates a new file.");
        System.out.println("6. help - Shows this help information.");
        System.out.println("7. exit - Exits the program.");

    }
    //====================================(7)================================
    public File getCurrentDirectory() {
        // TODO: Return the current directory
        return currentDirectory; // Replace this with your implementation
        //getCurrentDirectory(): פונקציה זו מחזירה את תיקיית העבודה הנוכחית
    }
}