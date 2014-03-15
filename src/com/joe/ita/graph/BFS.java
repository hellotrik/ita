package com.joe.ita.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {

    private Map<Vertex, Color> colorMap = new HashMap<Vertex, Color>();
    private Map<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();
    private Map<Vertex, Integer> distanceMap = new HashMap<Vertex, Integer>();

    public void breadthFirstSearch(Graph g, Vertex s) {

        Vertex[] vertices = g.getVertices();
        for (Vertex v : vertices) {
            if (v.equals(s)) {
                continue;
            }
            colorMap.put(v, Color.WHITE);
            distanceMap.put(v, Integer.MAX_VALUE);
            parentMap.put(v, null);
        }

        Queue<Vertex> queue = new LinkedList<Vertex>();
        colorMap.put(s, Color.GRAY);
        distanceMap.put(s, 0);
        parentMap.put(s, null);
        queue.add(s);

        while (!queue.isEmpty()) {

            if (true) {
                System.out.println("queue:" + queue);
            }

            Vertex v = queue.poll();

            List<Vertex> adjVertices = g.getAdj(v);
            for (Vertex w : adjVertices) {
                if (colorMap.get(w) != Color.WHITE) {
                    continue;
                }
                colorMap.put(w, Color.GRAY);
                distanceMap.put(w, distanceMap.get(v) + 1);
                parentMap.put(w, v);
                queue.add(w);
            }

            colorMap.put(v, Color.BLACK);
        }

    }

    public static void main(String[] args) {
        Graph graph = new UnDirectedGraph(8);

        Vertex r = new Vertex("r");
        Vertex s = new Vertex("s");
        Vertex t = new Vertex("t");
        Vertex u = new Vertex("u");
        Vertex v = new Vertex("v");
        Vertex w = new Vertex("w");
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");

        graph.addVertex(r);
        graph.addVertex(s);
        graph.addVertex(t);
        graph.addVertex(u);
        graph.addVertex(v);
        graph.addVertex(w);
        graph.addVertex(x);
        graph.addVertex(y);
        // System.out.println(instance);

        graph.addEdge(r, v);
        graph.addEdge(r, s);
        graph.addEdge(s, w);
        graph.addEdge(w, t);
        graph.addEdge(w, x);
        graph.addEdge(t, u);
        graph.addEdge(t, x);
        graph.addEdge(x, x);
        graph.addEdge(x, y);
        graph.addEdge(u, y);

        System.out.println(graph);
        System.out.println("Total edge number:" + graph.getEdgeNum());

        BFS bfs = new BFS();
        bfs.breadthFirstSearch(graph, s);
        
        System.out.println(bfs.colorMap);
        System.out.println(bfs.parentMap);
        System.out.println(bfs.distanceMap);

    }

}
