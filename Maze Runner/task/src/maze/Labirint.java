package maze;

import java.util.*;

public class Labirint {
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    private final int width;
    private final int height;
    private Set<Edge> edges;
    public Labirint(int width,int height){
        this.width=width;
        this.height=height;
        edges=new HashSet<>();
        generateEdges();
    }
    private List<Point> getNeighborn(Point point){
        List<Point> neighborns= new ArrayList<>();
        if (point.x>0) neighborns.add(new Point(point.x-1,point.y));
        if (point.y>0) neighborns.add(new Point(point.x,point.y-1));
        if (point.x<this.width-1) neighborns.add(new Point(point.x+1,point.y));
        if (point.y<this.height-1) neighborns.add(new Point(point.x,point.y+1));
        return neighborns;
    }
    private void  generateEdges(){
        Random rnd = new Random();
        for(int y=0;y<this.height;y++){
            for(int x=0;x<this.width;x++){
                Point one = new Point(x,y);
                for(Point two:getNeighborn(one)){
                    double value = rnd.nextDouble();
                    Edge edge = new Edge(value,one,two);
                    edges.add(edge);
                }
            }
        }
    }
    public Edge[] getPath(){
        return new Kruskal(edges.toArray(new Edge[0]))
                .getPath()
                .toArray(new Edge[0]);
    }
}
