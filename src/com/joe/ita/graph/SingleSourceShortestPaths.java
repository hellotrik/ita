package com.joe.ita.graph;

import java.util.HashMap;
import java.util.Map;

public class SingleSourceShortestPaths {

    Map<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();

    /* Upper bound on the weight of a shortest path from source s to v. */
    Map<Vertex, Integer> distanceMap = new HashMap<Vertex, Integer>();

    public void initSingleSource(Graph g, Vertex s) {
        for (Vertex v : g.getVertices()) {
            parentMap.put(v, null);
            distanceMap.put(v, Integer.MAX_VALUE);
        }

        distanceMap.put(s, 0);
    }

    public void relax(Vertex u, Vertex v, int w) {
        if(distanceMap.get(u) == Integer.MAX_VALUE){
            return;
        }
        
        if (distanceMap.get(v) > distanceMap.get(u) + w) {
            distanceMap.put(v, distanceMap.get(u) + w);
            parentMap.put(v, u);
        }
    }

}
