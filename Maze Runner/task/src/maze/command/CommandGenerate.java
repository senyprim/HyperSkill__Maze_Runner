package maze.command;

import maze.Grid;
import maze.Shell;

public class CommandGenerate  {
    private Shell shell;
    public CommandGenerate(Shell shell) {
        this.shell=shell;
    }
    public void run(){
        System.out.println("Enter the size of a new maze");
        int size = Integer.parseInt(shell.scanner.nextLine());
        shell.grid=new Grid(size,size);
        System.out.println(shell.grid.toString());
    }
}
