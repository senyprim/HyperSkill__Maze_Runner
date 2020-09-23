package maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MST {
    public static Edge[] getKruskalPath(Edge[] edges){
        List<Edge>path = new ArrayList<>();
        Arrays.sort(edges,Comparator.comparing(edge->edge.value));
        UnionFind<Point> unionFind = new UnionFind<>();
        for (Edge edge:edges){
            unionFind.add(edge.from);
            unionFind.add(edge.to);
            if (unionFind.isConnected(edge.from,edge.to)) continue;
            unionFind.union(edge.from, edge.to);
            path.add(edge);
        }
        return path.toArray(new Edge[0]);
    }
}
