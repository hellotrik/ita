package com.joe.ita.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetForest {

    Map<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();

    Map<Vertex, Integer> rankMap = new HashMap<Vertex, Integer>();

    public void makeSet(Vertex x) {
        parentMap.put(x, x);
        rankMap.put(x, 0);
    }

    public void union(Vertex x, Vertex y){
        link(findSet(x), findSet(y));
    }
    
    
    private void link(Vertex x, Vertex y) {
        int xRank = rankMap.get(x);
        int yRank = rankMap.get(y);
        if(xRank > yRank){
            parentMap.put(y, x);
        } else if (xRank < yRank) {
            parentMap.put(x, y);
        } else {
            parentMap.put(y, x);
            rankMap.put(x, xRank + 1);
        }
    }

    public Vertex findSet(Vertex x) {
        Vertex parent = parentMap.get(x);
        if (!x.equals(parent)) {
            parent = findSet(parent);
        }
        return parent;
    }

}
