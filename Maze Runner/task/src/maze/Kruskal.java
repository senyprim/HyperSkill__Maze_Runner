package maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    private Edge[] edges;
    UnionFind<Point> unionFind;
    private List<Edge> path;
    public Kruskal(Edge[] edges){
        this.edges= edges;
        this.path = new ArrayList<>();
        Arrays.sort(this.edges,Comparator.comparing(edge->edge.value));
        unionFind = new UnionFind<>();
        for (Edge edge:edges){
            unionFind.add(edge.from);
            unionFind.add(edge.to);
            if (unionFind.isConnected(edge.from,edge.to)) continue;
            unionFind.union(edge.from, edge.to);
            path.add(edge);
        }
    }
    public List<Edge> getPath() {
        return path;
    }
}
