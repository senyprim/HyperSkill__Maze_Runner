package maze;

import java.io.Serializable;
import java.util.*;

public class SquareGraf {
    private final int width;
    private final int height;
    private Set<Edge> edges;

    public SquareGraf(int width, int height){
        this.width=width;
        this.height=height;
        edges=new HashSet<>();
        generateEdges();
    }

    private void  generateEdges(){
        Random rnd = new Random();
        for(int y=0;y<this.height;y++){
            for(int x=0;x<this.width;x++){
                Point one = new Point(x,y);
                if (x<this.width-1){
                edges.add(new Edge(rnd.nextDouble(),one,new Point(x+1,y)));
                }
                if (y<this.height-1){
                edges.add(new Edge(rnd.nextDouble(),one,new Point(x,y+1)));
                }
            }
        }
    }

    public Edge[] getEdges() {
        return edges.toArray(new Edge[0]);
    }
}
