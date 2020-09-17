package maze;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String labirint=
                "1111111111\n" +
                "0010101001\n"+
                "1010001011\n"+
                "1000111000\n"+
                "1010000011\n"+
                "1010100011\n"+
                "1010111011\n"+
                "1010001001\n"+
                "1111111111";
        Map<Character,Block> legend= new HashMap(){{
            put('0',Block.EMPTY);
            put('1',Block.WALL);
        }};
        Grid grid = new Grid(labirint,legend);
        System.out.println(grid.toString());

    }
}
