package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Depth First Search
 * 
 * @author Joe
 * 
 */
public class DFS {

    private Map<Vertex, Color> colorMap = new HashMap<Vertex, Color>();
    private Map<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();
    private Map<Vertex, Integer> discoverMap = new HashMap<Vertex, Integer>();
    private Map<Vertex, Integer> finishMap = new HashMap<Vertex, Integer>();

    private List<ArrayList<Vertex>> stronglyConnectedComponents = new ArrayList<ArrayList<Vertex>>();

    private static int time = 0;

    public void depthFirstSearch(Graph g) {

        for (Vertex v : g.getVertices()) {
            colorMap.put(v, Color.WHITE);
            parentMap.put(v, null);
        }

        time = 0;
        for (Vertex v : g.getVertices()) {
            if (colorMap.get(v) == Color.WHITE) {
                dfsVisit(g, v);
            }
        }

    }

    /**
     * Helper classes for SCC.java
     * 
     * @param g
     */
    public void depthFirstSearchByTopoSort(Graph g,
            final Map<Vertex, Integer> topoSortMap) {

        List<Vertex> sortedAdjVertices = g.getVerticesByTopoSort(topoSortMap);
        for (Vertex v : sortedAdjVertices) {
            colorMap.put(v, Color.WHITE);
            parentMap.put(v, null);
        }

        time = 0;
        for (Vertex v : sortedAdjVertices) {
            if (colorMap.get(v) == Color.WHITE) {
                dfsVisitByTopoSort(g, v, topoSortMap);
                System.out.println("colorMap: " + colorMap);
                collectBlackVertices(g);
            }
        }

    }

    private void collectBlackVertices(Graph g) {
        ArrayList<Vertex> component = new ArrayList<Vertex>();
        for (Vertex v : g.getVertices()) {
            if (colorMap.get(v) == Color.BLACK && isNewVertex(v)) {
                component.add(v);
            }
        }

        stronglyConnectedComponents.add(component);
    }

    private boolean isNewVertex(Vertex v) {
        for (List<Vertex> list : stronglyConnectedComponents) {
            if (list.contains(v)) {
                return false;
            }
        }

        return true;
    }

    private void dfsVisitByTopoSort(Graph g, Vertex v,
            final Map<Vertex, Integer> topoSortMap) {
        colorMap.put(v, Color.GRAY);
        discoverMap.put(v, ++time);
        for (Vertex w : g.getAdjByTopoSort(v, topoSortMap)) {
            if (colorMap.get(w) == Color.WHITE) {
                parentMap.put(w, v);
                dfsVisitByTopoSort(g, w, topoSortMap);
            }
        }
        colorMap.put(v, Color.BLACK);
        finishMap.put(v, ++time);

    }

    /**
     * Get finish time of each vertex in dfs.
     * 
     * @return
     */
    public Map<Vertex, Integer> getFinshTime() {
        return finishMap;
    }

    public Map<Vertex, Vertex> getParent() {
        return parentMap;
    }

    public  List<ArrayList<Vertex>> getStronglyConnectedComponents(){
        return stronglyConnectedComponents;
    }

    private void dfsVisit(Graph g, Vertex v) {
        colorMap.put(v, Color.GRAY);
        discoverMap.put(v, ++time);
        for (Vertex w : g.getAdj(v)) {
            if (colorMap.get(w) == Color.WHITE) {
                parentMap.put(w, v);
                dfsVisit(g, w);
            }
        }
        colorMap.put(v, Color.BLACK);
        finishMap.put(v, ++time);
    }

    public static void main(String[] args) {
        Graph graph = new DirectedGraph(6);

        Vertex u = new Vertex("u");
        Vertex v = new Vertex("v");
        Vertex w = new Vertex("w");
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");
        Vertex z = new Vertex("z");

        graph.addVertex(u);
        graph.addVertex(v);
        graph.addVertex(w);
        graph.addVertex(x);
        graph.addVertex(y);
        graph.addVertex(z);
        // System.out.println(instance);

        graph.addEdge(u, v);
        graph.addEdge(u, x);
        graph.addEdge(x, v);
        graph.addEdge(v, y);
        graph.addEdge(y, x);
        graph.addEdge(w, y);
        graph.addEdge(w, z);
        graph.addEdge(z, z);

        System.out.println(graph);
        System.out.println("Total edge number:" + graph.getEdgeNum());

        DFS instance = new DFS();
        instance.depthFirstSearch(graph);
        System.out.println(instance.parentMap);
        System.out.println(instance.discoverMap);
    }

}
