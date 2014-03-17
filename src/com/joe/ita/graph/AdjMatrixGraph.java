package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjMatrixGraph extends AbstractGraph {

    private int[][] adj;

    private List<Vertex> vertices;

    public AdjMatrixGraph(int vertexNum) {
        if (vertexNum <= 0) {
            throw new IllegalArgumentException(
                    "The number of vertex should be positive!");
        }

        this.vertexNum = vertexNum;
        adj = new int[vertexNum][vertexNum];
        vertices = new ArrayList<Vertex>(vertexNum);
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                adj[i][j] = 0;
            }
        }
    }

    @Override
    public void addVertex(Vertex v) {
        if (isExist(v)) {
            return;
        }
        vertices.add(v);
    }

    @Override
    public void addEdge(Vertex v, Vertex w) {

        if (v == null || w == null) {
            throw new IllegalArgumentException("illegal vertex!");
        }

        int vIndex = findIndexInAdj(v);
        int wIndex = findIndexInAdj(w);

        adj[vIndex][wIndex] = 1;
        edgeNum++;
        adj[wIndex][vIndex] = 1;
        edgeNum++;

    }

    private int findIndexInAdj(Vertex v) {

        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).equals(v)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isExist(Vertex v) {
        return vertices.contains(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                sb.append(adj[i][j]);
                if(j != vertexNum - 1){
                    sb.append(" ");
                }
            }
            if(i != vertexNum - 1){
                sb.append(ITAUtils.lineSeparator);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AbstractGraph instance = new AdjMatrixGraph(5);

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
    }

    @Override
    public Vertex[] getVertices() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Vertex> getAdj(Vertex v) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addEdge(Edge e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getEdgesSeperator() {
        // TODO Auto-generated method stub
        return null;
    }


}
