Mini PowerShell
This is a lightweight Java-based shell simulator that supports basic file system operations.
With this tool, you can navigate folders, list contents, create files or directories, and more — using commands like `cd`, `ls`, `mkdir`, `touch`, `pwd`, and others.

---

##  Overview

The purpose of this project is to gain hands-on experience with Java’s file handling and user input processing.
It mimics a command-line interface in a minimal and educational manner, making it easier to understand how shells like Bash or PowerShell handle commands.

---

##  Running the Program

To run this Java mini-shell, follow these steps:

1. Open your preferred IDE (like IntelliJ or VS Code).
   This project was originally tested using **IntelliJ**.

2. Create a new Java project and add these two files:

    * `MiniShell.java` → This contains the main method and manages user input.
    * `ShellCommandHandler.java` → This handles the actual commands and file operations.

### Compile Instructions

Use the terminal to compile and run:

```bash
cd [your-project-folder]
javac MiniShell.java ShellCommandHandler.java
java MiniShell
```

---

##  Example Usage

Here's how the shell behaves during execution:

```shell
C:\Users\Username > mkdir test
```

Creates a new directory named `test`
🡒 Output: `Directory created: test`

```shell
C:\Users\Username > cd test
```

Moves into the `test` directory
🡒 Output: `Moved to: C:\Users\Username\test`

```shell
C:\Users\Username\test > touch file.txt
```

Creates a new text file
🡒 Output: `File created: file.txt`

```shell
C:\Users\Username\test > ls
```

Lists contents of the current folder
🡒 Output: `[FILE] file.txt`

---

 Inside the Code

 `MiniShell.java`

This class acts as the entry point. It reads commands from the user, processes them, and calls the corresponding method in the handler class.

Example:

```java
String[] parts = input.split(" ", 2);
```

This separates the command from its argument using a space.

The program uses a `switch` statement to identify which command was entered.

---

###  `ShellCommandHandler.java`

This class defines the behavior of each supported command:

* `printWorkingDirectory()` — Shows the full path of the current folder.
* `listDirectory()` — Lists files and subdirectories.
* `changeDirectory(String name)` — Moves into another folder or goes up.
* `makeDirectory(String name)` — Creates a new folder.
* `createFile(String name)` — Makes an empty file in the current location.
* `printHelp()` — Lists all available commands and their usage.

---


Here are the commands supported by the Mini Shell:

```
pwd             → Show current working directory  
ls              → Display contents of current folder  
cd [name]       → Navigate to a specific folder or use '..' to go back  
mkdir [name]    → Create a directory  
touch [name]    → Create a file  
help            → Show available commands  
exit            → Exit the shell  
```

---

