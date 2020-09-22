package maze;

import java.util.Objects;

public class Edge {
    public final double value;
    public final Point from;
    public final Point to;

    public Edge(double value, Point from, Point to) {
        this.value = value;
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return (Objects.equals(from, edge.from) &&
                Objects.equals(to, edge.to))|| //Для ненаправленного графа
                (Objects.equals(from, edge.to) &&
                        Objects.equals(to, edge.from));
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "["+from.x+","+from.y+"]-["+to.x+","+to.y+"]="+value;
    }
}
