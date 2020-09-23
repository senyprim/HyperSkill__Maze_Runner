package maze;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Grid implements Serializable {
    final private int width;
    final private int height;
    Edge[] graf;
    transient Block[][] grid;
    public Grid(int width,int height){
        this.width=width;
        this.height=height;
        graf=Kruskal.getPath(new SquareGraf(width/2-(width%2==0?1:0),height/2-(height%2==0?1:0)).getEdges());
    }
    private void drawEdge(Edge edge){
        int x1=edge.from.x;
        int y1=edge.from.y;
        int x2=edge.to.x;
        int y2=edge.to.y;
        grid[y1*2+1][x1*2+1]=Block.EMPTY;
        grid[y2*2+1][x2*2+1]=Block.EMPTY;
        grid[y2+y1+1][x2+x1+1]=Block.EMPTY;
    }
    private void  generateGrid(){
        grid=new Block[height][width];
        for(int y=0;y<height;y++)
            for(int x=0;x<width;x++)
                grid[y][x]=Block.WALL;
        for(Edge edge:graf){
            drawEdge(edge);
        }
        grid[1][0]=Block.EMPTY;
        grid[height-2-(height%2==0?1:0)][width-1]=Block.EMPTY;
        if (width%2==0) grid[height-2-(height%2==0?1:0)][width-2]=Block.EMPTY;
    }

    @Override
    public String toString() {
        if (grid==null) generateGrid();
        return Arrays.stream(grid)
                .map(row->Arrays.stream(row).map(Block::toString).collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
