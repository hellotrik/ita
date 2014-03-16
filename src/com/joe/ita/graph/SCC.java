package com.joe.ita.graph;

public class SCC {

    public static void main(String[] args) {
        Graph graph = new DirectedGraph(8);

        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");
        Vertex h = new Vertex("h");
        
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addVertex(h);

        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(c, d);
        graph.addEdge(d, c);
        graph.addEdge(e, a);
        graph.addEdge(b, e);
        graph.addEdge(b, f);
        graph.addEdge(c, g);
        graph.addEdge(d, h);
        graph.addEdge(h, h);
        graph.addEdge(e, f);
        graph.addEdge(f, g);
        graph.addEdge(g, f);
        graph.addEdge(g, h);

        System.out.println("vertex num:" + graph.getVertexNum());
        System.out.println("edge num:" + graph.getEdgeNum());
    }

}
