package com.joe.ita.graph;

public class DirectedGraph extends Graph {

    public DirectedGraph(int vertexNum) {
        super(vertexNum);
    }

    @Override
    public void addEdge(Vertex v, Vertex w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("illegal parameters, v or w can't be null!");
        }

        // find bags of v and w
        int vIndex = findIndexInAdj(v);
        // insert w into v's bag
        adj[vIndex].addNode(w);
        edgeNum++;
    }

    @Override
    public void addEdge(AbstractEdge e) {
        if (!(e instanceof DirectedEdge)) {
            throw new IllegalArgumentException(
                    "illegal parameter, e must be DirectedEdge");
        }

        DirectedEdge edge = (DirectedEdge) e;
        addEdge(edge.getStartVertex(), edge.getEndVertex());

    }
    public static void main(String[] args) {
        Graph instance = new DirectedGraph(5);

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
        // System.out.println(instance);

        instance.addEdge(a, e);
        instance.addEdge(d, e);
        instance.addEdge(c, d);
        instance.addEdge(b, a);
        instance.addEdge(b, e);
        instance.addEdge(b, c);
        instance.addEdge(b, d);

        System.out.println(instance);
        System.out.println("edge number:" + instance.getEdgeNum());
    }

    @Override
    public String getEdgesSeperator() {
        return ITAConstants.DIRECTED_EDGE_FLAG;
    }
}
