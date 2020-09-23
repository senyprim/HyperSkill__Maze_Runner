package maze;

import maze.command.CommandGenerate;
import maze.command.CommandLoad;
import maze.command.CommandSave;

import java.util.Scanner;

public class Shell {
    public final Scanner scanner;
    private boolean exit=false;
    public Grid  grid;

    public Shell(Scanner scanner){
        this.scanner=scanner;
    }
    public void run(){
        while(!exit){
            System.out.println(
                    "=== Menu ===\n" +
                    "1. Generate a new maze\n" +
                    "2. Load a maze");
            if (grid!=null) System.out.println(
                    "3. Save the maze\n" +
                    "4. Display the maze"
            );
            System.out.println("0. Exit");

            int input = Integer.parseInt(scanner.nextLine());

            switch (input){
                case 0: exit=true;break;
                case 1: new CommandGenerate(this).run();break;
                case 2: new CommandLoad(this).run();break;
                case 3: new CommandSave(this).run();break;
                case 4: System.out.println(grid.toString());break;
                default:throw new IllegalArgumentException("Incorrect option. Please try again");
            }
            System.out.println();
        }
        System.out.println("Bye!");
    }
}
