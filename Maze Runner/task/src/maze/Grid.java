package maze;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    public class Point{
        public final int x;
        public final int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    final private Block[][] grid;
    final private int width;
    final private int height;
    public Grid(String labirint, Map<Character,Block> legend){
        String[]lines=labirint.split("\n");
        this.height=lines.length;
        this.width= lines[0].length();
        this.grid=new Block[height][width];
        for(int row=0;row<height;row++){
            Block[] line = lines[row]
                    .chars()
                    .mapToObj(ch->legend.get((char)ch))
                    .toArray(Block[]::new);

            grid[row] = line;
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(grid)
                .map(row->Arrays.stream(row).map(Block::toString).collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
