package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.List;


public class Graph extends AbstractGraph {
    
    private List<Vertex>[] adj;

    public Graph(int vertexNum) {
        if(vertexNum <= 0){
            throw new IllegalArgumentException("The number of vertex should be positive!");
        }

        this.vertexNum = vertexNum;
        for(int i = 0; i < vertexNum; i ++){
            adj[i] = new ArrayList<Vertex>();
        }
    }


    @Override
    public void addEdge(Vertex v, Vertex w) {
        if(v == null || w == null){
            throw new IllegalArgumentException("illegal vertex!");
        }
        
        // XXX

    }

}
