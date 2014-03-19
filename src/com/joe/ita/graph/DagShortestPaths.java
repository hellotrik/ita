package com.joe.ita.graph;

import java.util.List;

public class DagShortestPaths extends SingleSourceShortestPaths {

    private void ssst(Graph g, Vertex s) {
        TopologicalSort ts = new TopologicalSort();
        List<Vertex> sortedVertices = ts.topologicalSort(g);

        System.out.println("sorted vertices:" + sortedVertices);
        
        initSingleSource(g, s);
        System.out.println("after init:" + distanceMap);
        System.out.println("after init:" + parentMap);

        for (Vertex v : sortedVertices) {
            List<Vertex> adjList = g.getAdjByTopoSort(v, ts.getFinishTime(g));
            
            System.out.println("v:" + v + "==>" + adjList);
            for (Vertex w : adjList) {
                int weight = g.getWeight(v, w);
                relax(v, w, weight);
            }
            System.out.println("after init:" + distanceMap);
        }

    }

    public static void main(String[] args) {
        String vertices = "r,  x, s, t, y, z";

        String edges = "r->s_5, r->t_3, s->t_2, s->x_6, t->x_7, t->y_4, t->z_2, x->y_-1, "
                + "x->z_1, y->z_-2";
        Graph g = ITAUtils.newGraph(vertices, edges);
        System.out.println(g);
        System.out.println("edge num:" + g.getEdgeNum());
        System.out.println("vertex num:" + g.getVertexNum());

        DagShortestPaths dsp = new DagShortestPaths();
        Vertex s = new Vertex("s");
        dsp.ssst(g, s);

        System.out.println(dsp.distanceMap);
        System.out.println(dsp.parentMap);
    }

}
