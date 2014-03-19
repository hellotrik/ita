package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraAlgorithm extends SingleSourceShortestPaths {

    public void ssst(Graph g, Vertex s) {

        initSingleSource(g, s);

        List<Vertex> visitedList = new ArrayList<Vertex>();

        Comparator<Vertex> comparator = new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                int d1 = distanceMap.get(o1);
                int d2 = distanceMap.get(o2);
                return (d1 < d2) ? -1 : ((d1 == d2) ? 0 : 1);
            }

        };
        Queue<Vertex> q = new PriorityQueue<Vertex>(g.getVertexNum(),
                comparator);

        for (Vertex v : g.getVertices()) {
            q.add(v);
        }
        
//        System.out.println(q);

        while (!q.isEmpty()) {
            Vertex v = q.poll();

            System.out.println("Current Vertex:" + v);
            visitedList.add(v);

            for (Vertex w : g.getAdj(v)) {
                relax(v, w, g.getWeight(v, w));
            }

            Queue<Vertex> q2 = new PriorityQueue<Vertex>(g.getVertexNum(),
                    comparator);
            q2.addAll(q);
            q.clear();
            q = q2;
//            System.out.println("" : + q);
//            q = new PriorityQueue<Vertex>(q);
        }

        System.out.println("===q:" + q);
        System.out.println("===S:" + visitedList);
    }

    public static void main(String[] args) {
        String vertices = "s, t, x, y, z";

        String edges = "s->t_10, s->y_5, t->x_1, t->y_2, x->z_4, z->x_6, z->s_7, "
                + "y->t_3, y->x_9, y->z_2";
        Graph g = ITAUtils.newGraph(vertices, edges);
        System.out.println(g);
        System.out.println("edge num:" + g.getEdgeNum());
        System.out.println("vertex num:" + g.getVertexNum());

        DijkstraAlgorithm da = new DijkstraAlgorithm();
        Vertex s = new Vertex("s");
        da.ssst(g, s);
        System.out.println("distanceMap:" + da.distanceMap);
        System.out.println("parentMap:" + da.parentMap);
        

    }

}
