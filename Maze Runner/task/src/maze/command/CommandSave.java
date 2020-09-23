package maze.command;

import maze.Grid;
import maze.Shell;

import java.io.*;

public class CommandSave {
    Shell shell;
    public CommandSave(Shell shell) {
        this.shell=shell;
    }
    public void run(){
        String filename=shell.scanner.nextLine();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            out.writeObject(shell.grid);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
