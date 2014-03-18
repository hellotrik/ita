package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST_Kruskal {

    public List<Edge> traverse(Graph g) {
        List<Edge> mst = new ArrayList<Edge>();

        DisjointSetForest dsf = new DisjointSetForest();
        for (Vertex v : g.getVertices()) {
            dsf.makeSet(v);
        }

        Queue<Edge> pq = new PriorityQueue<Edge>();
        for (Edge e : g.getAllEdges()) {
            pq.offer(e);
        }

        while (!pq.isEmpty()) {
            // System.out.print(pq.poll() + " ");
            Edge e = pq.poll();
            Vertex v = e.getV();
            Vertex w = e.getW();
            if (!dsf.findSet(v).equals(dsf.findSet(w))) {
                mst.add(e);
            }
            dsf.union(v, w);
        }

        return mst;
    }

    public static void main(String[] args) {

        String vertices = "a, b, c, d, e, f, g, h, i";

        String edges = "a--b_4, b--c_8, c--d_7, d--e_9, e--f_10, "
                + "f--g_2, g--h_1, h--a_8, b--h_11, h--i_7, i--g_6, i--c_2, c--f_4, f--d_14";
        Graph g = ITAUtils.newGraph(vertices, edges);
        System.out.println(g);
        System.out.println("edge num:" + g.getEdgeNum());
        System.out.println("vertex num:" + g.getVertexNum());
        //
        MST_Kruskal instance = new MST_Kruskal();
        System.out.println("Kruskal MST:" + instance.traverse(g));
    }

}
