package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST_Prim {

    Map<Vertex, Integer> keyMap = new HashMap<Vertex, Integer>();

    Map<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();

    public static void main(String[] args) {
        String vertices = "a, b, c, d, e, f, g, h, i";

        String edges = "a--b_4, b--c_8, c--d_7, d--e_9, e--f_10, "
                + "f--g_2, g--h_1, h--a_8, b--h_11, h--i_7, i--g_6, i--c_2, c--f_4, f--d_14";
        Graph g = ITAUtils.newGraph(vertices, edges);
        System.out.println(g);
        System.out.println("edge num:" + g.getEdgeNum());
        System.out.println("vertex num:" + g.getVertexNum());

        MST_Prim instance = new MST_Prim();
        Vertex a = new Vertex("a");
        System.out.println("Prim MST:" + instance.traverse(g, a));

    }

    private List<Edge> traverse(Graph g, Vertex a) {
        List<Edge> mst = new ArrayList<Edge>();

        Vertex[] vertexList = g.getVertices();
        Comparator<Vertex> comparator = new Comparator<Vertex>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
                int key1 = keyMap.get(v1);
                int key2 = keyMap.get(v2);
                return (key1 < key2) ? -1 : ((key1 == key2) ? 0 : 1);
            }

        };

        Queue<Vertex> queue = new PriorityQueue<Vertex>(vertexList.length,
                comparator);

        for (Vertex v : vertexList) {
            keyMap.put(v, Integer.MAX_VALUE);
            parentMap.put(v, null);
        }

        keyMap.put(a, 0);

        for (Vertex v : vertexList) {
            queue.add(v);
        }

//        System.out.println("keyMap:" + keyMap);
        printQueue(queue);

        while (!queue.isEmpty()) {
//            System.out.println();
            Vertex v = exactMin(queue);

//            System.out.println("v:" + v);
            for (Vertex w : g.getAdj(v)) {
//                System.out.println("w:" + w);
                int wWeight = g.getWeight(v, w);
                if (queue.contains(w) && wWeight < keyMap.get(w)) {
                    parentMap.put(w, v);
                    keyMap.put(w, wWeight);
                }

            }
//            System.out.println("...keyMap:" + keyMap);
            Queue<Vertex> queue2 = new PriorityQueue<Vertex>(vertexList.length,
                    comparator);
            queue2.addAll(queue);
            queue.clear();
            queue = queue2;
//            System.out.println("...queue's next:" + queue.peek());
        }

        for (Map.Entry<Vertex, Vertex> entry : parentMap.entrySet()) {
            Vertex v = entry.getKey();
            Vertex w = entry.getValue();
            if (w == null) {
                continue;
            }
            Edge e = new Edge(v, w, g.getWeight(v, w));
            mst.add(e);
        }

        return mst;
    }

    private void printQueue(Queue<Vertex> queue) {
        Queue<Vertex> q = new PriorityQueue<Vertex>(queue);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Vertex v = q.poll();
            sb.append(v).append(" ");
        }
        // System.out.println(sb);

    }

    private Vertex exactMin(Queue<Vertex> queue) {
        return queue.poll();
    }

}
