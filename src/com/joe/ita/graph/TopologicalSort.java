package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopologicalSort {

    private List<Map.Entry<Vertex, Integer>> sortByValue(
            Map<Vertex, Integer> finishTime) {
        List<Map.Entry<Vertex, Integer>> mappingList = new ArrayList<Map.Entry<Vertex, Integer>>(
                finishTime.entrySet());

        Collections.sort(mappingList,
                new Comparator<Map.Entry<Vertex, Integer>>() {
                    @Override
                    public int compare(Entry<Vertex, Integer> o1,
                            Entry<Vertex, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });

        return mappingList;
    }

    public List<Vertex> topologicalSort(Graph g) {
        List<Map.Entry<Vertex, Integer>> entrylist = topologicalSort2Entry(g);

        List<Vertex> list = new ArrayList<Vertex>();
        for(Map.Entry<Vertex, Integer> entry : entrylist){
            list.add(entry.getKey());
        }

        return list;
    }

    public List<Map.Entry<Vertex, Integer>>  topologicalSort2Entry(Graph g) {
        DFS dfs = new DFS();

        dfs.depthFirstSearch(g);
        Map<Vertex, Integer> finishTime = dfs.getFinshTime();
//        System.out.println(finishTime);
        List<Map.Entry<Vertex, Integer>> entrylist = sortByValue(finishTime);
        return entrylist;
    }
    
    public Map<Vertex, Integer> getFinishTime(Graph g){
        DFS dfs = new DFS();

        dfs.depthFirstSearch(g);
        Map<Vertex, Integer> finishTime = dfs.getFinshTime();
        return finishTime;
    }

    public static void main(String[] args) {
        Graph g = new DirectedGraph(9);

        Vertex v1 = new Vertex("undershorts");
        Vertex v2 = new Vertex("pants");
        Vertex v3 = new Vertex("belt");
        Vertex v4 = new Vertex("shirt");
        Vertex v5 = new Vertex("tie");
        Vertex v6 = new Vertex("jacket");
        Vertex v7 = new Vertex("socks");
        Vertex v8 = new Vertex("shoes");
        Vertex v9 = new Vertex("watch");

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addVertex(v8);
        g.addVertex(v9);

        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v4, v3);
        g.addEdge(v4, v5);
        g.addEdge(v5, v6);
        g.addEdge(v3, v6);
        g.addEdge(v7, v8);
        g.addEdge(v1, v8);
        g.addEdge(v2, v8);

        System.out.println(g);
        TopologicalSort instance = new TopologicalSort();
        instance.topologicalSort(g);

    }

}
