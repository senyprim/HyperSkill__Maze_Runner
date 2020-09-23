package maze.command;

import maze.Grid;
import maze.Shell;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;

public class CommandLoad {
    Shell shell;
    public CommandLoad(Shell shell) {
        this.shell=shell;
    }
    public void run(){
        String filename= shell.scanner.nextLine();
        if (!new File(filename).isFile()){
            System.out.println("The file "+filename+" does not exist");
            return;
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            this.shell.grid = (Grid) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot load the maze. It has an invalid format");
        }
    }
}
