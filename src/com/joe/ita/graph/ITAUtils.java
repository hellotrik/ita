package com.joe.ita.graph;

import java.util.List;

public class ITAUtils {
    public static String lineSeparator = getLineSeparator();

    public static String getLineSeparator() {
        String lineSeparator = java.security.AccessController
                .doPrivileged(new sun.security.action.GetPropertyAction(
                        "line.separator"));
        return lineSeparator;
    }

    public static Graph newGraph(String vertices, String edges) {
        vertices = vertices.replaceAll("\\s*", "");
        edges = edges.replaceAll("\\s*", "");

        // System.out.println(vertices);
        String[] vertexArr = vertices.split(",");
        String[] edgeArr = edges.split(",");

        int vertexNum = vertexArr.length;
        Graph g = null;
        if (isDirected(edges)) {
            g = new DirectedGraph(vertexNum);
        } else {
            g = new UnDirectedGraph(vertexNum);
        }

        addVertices(g, vertexArr);
        // System.out.println(g);

        addEdge(g, edgeArr);

        return g;
    }

    private static void addEdge(Graph g, String[] edgeArr) {
        for (String e : edgeArr) {
            String[] vw = e.split(g.getEdgesSeperator());
            // System.out.println(vw[1]);
            g.addEdge(new Vertex(vw[0]), new Vertex(vw[1]));
        }

    }

    private static void addVertices(Graph g, String[] vertexArr) {
        for (String v : vertexArr) {
            g.addVertex(new Vertex(v));
        }
    }

    private static boolean isDirected(String edges) {
        return edges.contains(ITAConstants.DIRECTED_EDGE_FLAG);
    }

    public static Graph transpose(Graph g) {
        List<Bag> bags = g.getAllBag();
        Graph instance = new DirectedGraph(bags.size());

        for (Bag bag : bags) {
            instance.addVertex(bag.getHead().getValue());
        }

        for (Bag bag : bags) {
            Vertex v = bag.head.getValue();
            List<Vertex> wList = bag.getAdjVertices();
            for (Vertex w : wList) {
                instance.addEdge(w, v);
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        String vertices = "a, b, c";
        String edges = "a->b, c->b";
        Graph g = newGraph(vertices, edges);
        System.out.println(g);

        System.out.println("transpose g:" + transpose(g));
    }

}
