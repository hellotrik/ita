package com.joe.ita.graph;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    Node head = null;

    int bagNum = 0;

    public Bag() {
        ;
    }

    public Bag(Vertex v) {
        head = new Node(v, v);
        bagNum++;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(head).append("==>");
        String flag = "->";

        Node currentNode = head.next;
        while (currentNode != null) {
            sb.append(currentNode).append(flag);
            currentNode = currentNode.next;
        }
        sb.append("Nil");
        return sb.toString();
    }

    public void setHead(Vertex v) {
        head = new Node(v, v);
        bagNum++;
    }

    public Node getHead() {
        return head;
    }

    public void addNode(Vertex w) {
        Node wNode = new Node(head.getValue(), w);
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = wNode;
        bagNum++;
    }

    public void addEdge(Edge e) {
        Node wNode = new Node(head.getValue(), e);
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = wNode;
        bagNum++;
    }

    public List<Vertex> getAdjVertices() {
        List<Vertex> vertices = new ArrayList<Vertex>();
        Node currentNode = head.next;
        while (currentNode != null) {
            vertices.add(currentNode.getValue());
            currentNode = currentNode.next;
        }
        return vertices;
    }

    public boolean isEmpty() {
        return (bagNum == 0);
    }

    class Node {
        Vertex v = null;
        Edge e = null;

        Node next = null;

        public Node(Vertex headVertex, Vertex v) {
            this.v = v;
            this.e = new Edge(headVertex, v);
        }

        public Node(Vertex headVertex, Edge e) {
            this.e = e;
            v = e.getTheOtherVetex(headVertex);
        }

        public Vertex getValue() {
            return v;
        }

        public Node getNext() {
            return next;
        }

        public Edge getEdge() {
            return e;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(v.toString());
            if(e.getWeight() != 0){
                sb.append("_" + e.getWeight());
            }
            return sb.toString();
        }

    }

    public static void main(String[] args) {
        Bag emptyBag = new Bag();
        System.out.println(emptyBag);

        Vertex s = new Vertex("s");
        Vertex s1 = new Vertex("s1");
        Vertex s2 = new Vertex("s2");
        Vertex s3 = new Vertex("s3");

        Bag instance = new Bag(s);
        instance.addNode(s1);
        instance.addNode(s2);
        instance.addNode(s3);
        System.out.println(instance);
        System.out.println(instance.getAdjVertices());
    }

}
