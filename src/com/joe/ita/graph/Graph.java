package com.joe.ita.graph;

public class Graph extends AbstractGraph {

    private Bag[] adj;

    private int index = 0;

    public Graph(int vertexNum) {
        if (vertexNum <= 0) {
            throw new IllegalArgumentException(
                    "The number of vertex should be positive!");
        }

        adj = new Bag[vertexNum];
        this.vertexNum = vertexNum;
        for (int i = 0; i < vertexNum; i++) {
            adj[i] = new Bag();
        }
    }

    @Override
    public void addEdge(Vertex v, Vertex w) {

        if (v == null || w == null) {
            throw new IllegalArgumentException("illegal vertex!");
        }

        // find bags of v and w
        int vIndex = findIndexInAdj(v);
        int wIndex = findIndexInAdj(w);
        // insert w into v's bag
        adj[vIndex].addNode(w);
        // insert v into w's bag
        adj[wIndex].addNode(v);
        //
        edgeNum++;
    }

    @Override
    public void addVertex(Vertex v) {
        if (isExist(v)) {
            return;
        }

        if (index < 0 || index >= this.vertexNum) {
            return;
        }

        Bag currentBag = adj[index++];
        currentBag.setHead(v);
    }

    private boolean isExist(Vertex v) {
        int index = findIndexInAdj(v);
        return index != -1;
    }

    private int findIndexInAdj(Vertex v) {

        for (int i = 0; i < adj.length; i++) {
            Bag bag = adj[i];
            if (bag.isEmpty()) {
                continue;
            }
            Vertex headV = bag.getHead().getValue();
            if (headV.equals(v)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String lineSeparator = java.security.AccessController
                .doPrivileged(new sun.security.action.GetPropertyAction(
                        "line.separator"));
        for (Bag bag : adj) {
            sb.append(bag);
            sb.append(lineSeparator);
        }

        return sb.substring(0, sb.lastIndexOf(lineSeparator));
    }

    public static void main(String[] args) {
        Graph instance = new Graph(5);

        Vertex a = new Vertex("1");
        Vertex b = new Vertex("2");
        Vertex c = new Vertex("3");
        Vertex d = new Vertex("4");
        Vertex e = new Vertex("5");
        instance.addVertex(a);
        instance.addVertex(b);
        instance.addVertex(c);
        instance.addVertex(d);
        instance.addVertex(e);
//        System.out.println(instance);

        instance.addEdge(a, e);
        instance.addEdge(d, e);
        instance.addEdge(c, d);
        instance.addEdge(b, a);
        instance.addEdge(b, e);
        instance.addEdge(b, c);
        instance.addEdge(b, d);

        System.out.println(instance);
    }

}
