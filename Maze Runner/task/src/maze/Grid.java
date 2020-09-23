package maze;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Grid implements Serializable {
    final private int width;
    final private int height;
    final private Point start;
    final private Point end;
    private final int widthGraf;
    private final int heightGraf;
    private Edge[] graf;
    private Edge[] path;
    transient Block[][] grid;

    public Point getStart() {
        return start;
    }
    public Point getEnd() {
        return end;
    }
    public Edge[] getPath() {
        return path;
    }
    public void setPath(Edge[] path) {
        this.path = path;
        generateGrid();
    }
    public Edge[] getGraf() {
        return graf;
    }

    public Grid(int width,int height){
        this.width=width;
        this.height=height;
        this.widthGraf=width/2-(width%2==0?1:0);
        this.heightGraf=height/2-(height%2==0?1:0);
        this.start=new Point(0,0);
        this.end = new Point(widthGraf-1,heightGraf-1);
        graf= MST.getKruskalPath(new SquareGraf(widthGraf,heightGraf).getEdges());
    }

    private void drawEdge(Edge edge,Block block){
        int x1=edge.from.x;
        int y1=edge.from.y;
        int x2=edge.to.x;
        int y2=edge.to.y;
        grid[y1*2+1][x1*2+1]=block;
        grid[y2*2+1][x2*2+1]=block;
        grid[y2+y1+1][x2+x1+1]=block;
    }
    private void drawStartEnd(Point point,Block block){
        if (point.x==0) grid[point.y*2+1][point.x*2]=block;
        if (point.x==widthGraf-1) {
            grid[point.y*2+1][width-1]=block;
            if (width%2==0) grid[point.y*2+1][width-2]=block;
        }
    }
    private void  generateGrid(){
        grid=new Block[height][width];
        for(int y=0;y<height;y++)
            for(int x=0;x<width;x++)
                grid[y][x]=Block.WALL;

                for (Edge edge : graf) {
                    drawEdge(edge, Block.EMPTY);
                }

        if (path!=null) {
            for(Edge edge:path){
                drawEdge(edge,Block.PATH);
            }
        }
        drawStartEnd(start,path==null?Block.EMPTY:Block.PATH);
        drawStartEnd(end,path==null?Block.EMPTY:Block.PATH);

    }
    @Override
    public String toString() {
        if (grid==null) generateGrid();
        return Arrays.stream(grid)
                .map(row->Arrays.stream(row).map(Block::toString).collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}
