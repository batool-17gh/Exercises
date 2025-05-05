import java.util.Scanner;

public class MiniShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShellCommandHandler handler = new ShellCommandHandler();

        System.out.println("Welcome to MiniShell! Type 'help' for a list of commands.");

        while (true) {
            // הצגת הספרייה הנוכחית
            System.out.print(handler.getCurrentDirectory().getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;

            // ניהול הפקודות
            switch (command) {
                case "pwd":
                    // הדפסת הנתיב המוחלט של התיקייה הנוכחית
                    handler.printWorkingDirectory();
                    break;

                case "ls":
                    // הצגת כל הקבצים והתיקיות בתיקייה הנוכחית
                    handler.listDirectory();
                    break;

                case "cd":
                    // שינוי תיקייה, אם המשתמש הזין תיקייה נאה
                    if (argument != null) {
                        handler.changeDirectory(argument);
                    } else {
                        System.out.println("Usage: cd [directory_name]"); // אם לא הוזן שם תיקייה
                    }
                    break;

                case "mkdir":
                    // יצירת תיקייה חדשה
                    if (argument != null) {
                        handler.makeDirectory(argument);
                    } else {
                        System.out.println("Usage: mkdir [directory_name]"); // אם לא הוזן שם תיקייה
                    }
                    break;

                case "touch":
                    // יצירת קובץ חדש
                    if (argument != null) {
                        handler.createFile(argument);
                    } else {
                        System.out.println("Usage: touch [file_name]"); // אם לא הוזן שם קובץ
                    }
                    break;

                case "help":
                    // הצגת כל הפקודות הזמינות והסבר עליהן
                    handler.printHelp();
                    break;

                case "exit":
                    // יציאה מהתוכנית
                    System.out.println("Goodbye!");
                    return;  // יוצא מהלופ ומסיים את התוכנית

                default:
                    // אם הפקודה לא ידועה
                    System.out.println("Unknown command: " + command + "  ...Type 'help' to see available commands .");
                    break;
            }
        }
    }
}