package com.joe.ita.graph;

import java.util.HashMap;
import java.util.Map;

public class BFS {
    
    private Map<Vertex, Color> colorMap = new HashMap<Vertex, Color>();
    private Map<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();
    private Map<Vertex, Integer> distanceMap = new HashMap<Vertex, Integer>();
    

    public void breadthFirstSearch(Graph g, Vertex s){
        // get all vertices
        
    }
    
    public static void main(String[] args) {
        Graph instance = new Graph(8);

        Vertex r = new Vertex("r");
        Vertex s = new Vertex("s");
        Vertex t = new Vertex("t");
        Vertex u = new Vertex("u");
        Vertex v = new Vertex("v");
        Vertex w = new Vertex("w");
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");
        
        instance.addVertex(r);
        instance.addVertex(s);
        instance.addVertex(t);
        instance.addVertex(u);
        instance.addVertex(v);
        instance.addVertex(w);
        instance.addVertex(x);
        instance.addVertex(y);
//        System.out.println(instance);

        instance.addEdge(r, v);
        instance.addEdge(r, s);
        instance.addEdge(s, w);
        instance.addEdge(w, t);
        instance.addEdge(w, x);
        instance.addEdge(t, u);
        instance.addEdge(t, x);
        instance.addEdge(x, x);
        instance.addEdge(x, y);
        instance.addEdge(u, y);

        System.out.println(instance);
        System.out.println("Total edge number:" + instance.getEdgeNum());
        
        
    }

}
