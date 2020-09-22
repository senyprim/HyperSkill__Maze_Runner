package maze;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter the size of a maze");
        Scanner scanner = new Scanner(System.in);
        String[] param = scanner.nextLine().trim().split("\\s+");
        Grid grid = new Grid(Integer.parseInt(param[1]),Integer.parseInt(param[0]));
        System.out.println(grid.toString());

    }

}
