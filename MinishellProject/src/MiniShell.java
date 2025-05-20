import java.util.Scanner;

public class MiniShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// Create Scanner to read input from user
        ShellCommandHandler handler = new ShellCommandHandler();

        System.out.println("Welcome to MiniShell!  Type 'help' for a list of commands.");

        while (true) {
            System.out.print(handler.getCurrentDirectory().getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;
            switch (command) {

                case "pwd": // Print current directory
                    handler.printWorkingDirectory();
                    break;
                case "ls": // List files and directories
                    handler.listDirectory();
                    break;
                case "cd":// Change directory
                    handler.changeDirectory(argument);
                    break;
                case "mkdir":// Create a new directory
                    handler.makeDirectory(argument);
                    break;
                case "touch":   // Create a new file
                    handler.createFile(argument);
                    break;
                case "help":  // Show help information
                    handler.printHelp();
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    return;// Exit the loop and program
            }
        }
    }
}