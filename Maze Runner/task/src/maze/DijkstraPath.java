package maze;

import java.util.*;

public class DijkstraPath {
    private static class Node{
        Point point;
        List<Edge> shortestPath;
        double distance =Double.MAX_VALUE;
        Map<Node,Double> edges;

        Node(Point point){
            this.point=point;
            this.edges=new HashMap<>();
            this.shortestPath=new LinkedList<>();
            this.edges = new HashMap<>();
        }
        public void addEdge(Node node,Double value){
            this.edges.put(node,value);
        }
        public Point getPoint() {
            return point;
        }
        public double getDistance() {
            return distance;
        }
        public Map<Node, Double> getEdges() {
            return edges;
        }
        public void setDistance(double distance) {
            this.distance = distance;
        }
        public void setShortestPath(List<Edge> shortestPath) {
            this.shortestPath = shortestPath;
        }
        public List<Edge> getShortestPath() {
            return shortestPath;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(point, node.point);
        }

        @Override
        public int hashCode() {
            return this.getPoint().hashCode();
        }
    }


    private static void addEdge(Map<Point, Node> graf, Point from, Point to, Double value){
        Node nodeFrom = graf.get(from);
        Node nodeTo = graf.get(to);
        if (nodeFrom==null) {
            nodeFrom = new Node(from);
            graf.put(from,nodeFrom);
        }
        if (nodeTo==null) {
            nodeTo = new Node(to);
            graf.put(to,nodeTo);
        }
        nodeFrom.addEdge(nodeTo,value);
    }


    public static Edge[] getPath(Edge[] edges,Point start,Point end){
        //Формируем узлы
        Map<Point, Node> graf = new HashMap<>();
        for(Edge edge:edges){
            addEdge(graf,edge.from,edge.to,edge.value);
            addEdge(graf,edge.to,edge.from,edge.value);
        }
        //Формируем таблицу непосещенных
        Set<Node>  unSet = new HashSet<>();//TreeSet<>(Comparator.comparingDouble(Node::getDistance));
        Node first=graf.get(start);
        first.setDistance(0D);
        unSet.add(first);
        //Формируем таблицу посещенныx
        Set<Node>  set = new HashSet<>();

        while(!unSet.isEmpty()){
            //Находим наименьший в непосещенных
            Node from = unSet.stream().min(Comparator.comparing(Node::getDistance)).get();
            unSet.remove(from);
            //Пробегаем по граням
            for(Map.Entry<Node,Double> edge:from.getEdges().entrySet()){
                if (set.contains(edge.getKey())) continue;
                Node to = edge.getKey();
                //Если путь до этой грани меньше чем заданный меняем
                if (to.getDistance()>(edge.getValue()+from.getDistance())){
                    to.setDistance(from.getDistance()+edge.getValue());
                    List<Edge> shortestPath = new LinkedList<>(from.getShortestPath());
                    shortestPath.add(new Edge(edge.getValue(), from.getPoint(),to.getPoint()));
                    to.setShortestPath(shortestPath);
                    unSet.add(to);
                }
            }
            set.add(from);
        }
        return graf.get(end).getShortestPath().toArray(Edge[]::new);
    }
}
