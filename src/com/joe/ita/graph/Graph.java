package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public abstract class Graph extends AbstractGraph {

    protected Bag[] adj;

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

    protected int findIndexInAdj(Vertex v) {

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

        for (Bag bag : adj) {
            sb.append(bag);
            sb.append(ITAUtils.lineSeparator);
        }

        return sb.substring(0, sb.lastIndexOf(ITAUtils.lineSeparator));
    }
    
    @Override
    public Vertex[] getVertices() {
        Vertex[] vertices = new Vertex[adj.length];
        for (int i = 0; i < adj.length; i++) {
            vertices[i] = adj[i].getHead().getValue();
        }
        return vertices;
    }

    public List<Vertex> getVerticesByTopoSort(final Map<Vertex, Integer> topoSortMap) {
        Vertex[] adjVertices = getVertices();
        List<Vertex> sortedAdjVertices = new ArrayList<Vertex>();
        for (Vertex v : adjVertices) {
            sortedAdjVertices.add(v);
        }

        sortList(topoSortMap, sortedAdjVertices);
        return sortedAdjVertices;
    }

    private void sortList(final Map<Vertex, Integer> topoSortMap,
            List<Vertex> needToSort) {
        Collections.sort(needToSort, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
                return topoSortMap.get(v2).compareTo(topoSortMap.get(v1));
            }
        });
    }

    @Override
    public List<Vertex> getAdj(Vertex v) {
        int index = findIndexInAdj(v);
        Bag bag = adj[index];

        return bag.getAdjVertices();
    }

    public List<Vertex> getAdjByTopoSort(Vertex v, final Map<Vertex, Integer> topoSortMap) {
        List<Vertex> adjs = getAdj(v);
        sortList(topoSortMap, adjs);
        return adjs;
    }

    /**
     * Get all bag of the graph.
     * @return
     */
    public List<Bag> getAllBag(){
        List<Bag> list = new ArrayList<Bag>();
        for(Bag bag : adj){
            list.add(bag);
        }
        return list;
    }
    
    /**
     * Get all edges of this graph.
     * @return
     */
    public List<Edge> getAllEdges() {
        List<Edge> edgeList = new ArrayList<Edge>();
        for(Bag bag : adj){
            List<Edge> edges = bag.getAdjEdges();
//            System.out.println("------edges:" + edges);
            for(Edge e : edges){
                if(!isExist(edgeList, e)){
                    edgeList.add(e);
                }
            }
//            System.out.println("------edgeList:" + edgeList);
        }
        return edgeList;
    }
    
    /**
     * 
     * @param list
     * @param e
     * @return
     */
    public abstract boolean isExist(List<Edge> list, Edge e);
}
