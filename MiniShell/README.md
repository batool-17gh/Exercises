General description of the project
This is a software program that allows the user to perform basic and simple operations on files and directories by typing specific commands.
The program functions like a mini command-line shell, where the user inputs commands to interact with the file system.
The user can check the current directory using the "pwd" command.
The user can navigate between different directories using the "cd" command followed by the name of the directory.
It is possible to create new files using the "touch" command, which takes the name of the file to be created.
The user can also create new folders using the "mkdir" command with the desired folder name.
To view the contents of the current directory, the user can use the "ls" command.
There is also a "help" command that displays explanations for all available commands.
To close the program and exit, the user can use the "exit" command.
The program responds to each command with a clear message indicating the result of the action.

• Instructions on how to compile and run the code
Open the project using the IntelliJ IDEA development environment.
Inside the environment, locate the file named "MiniShell.java".
Click the run button to compile and execute the code.
Once the program is running, a command-line interface will appear.
Type one of the supported commands:
pwd
mkdir
cd
touch
ls
help
exit
Make sure to type each command correctly to ensure proper execution and accurate results.

Example of command execution:

pwd
C:\Users\Student\Desktop\MiniShell

mkdir Projects
Directory created: [Projects]

cd Projects

touch README.txt
File created: [README.txt]

ls
[FILE] README.txt
