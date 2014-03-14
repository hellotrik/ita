package com.joe.ita.graph;

public class Bag {
    Node head = null;

    int bagNum = 0;

    public Bag() {
        ;
    }

    public Bag(Vertex v) {
        head = new Node(v);
        bagNum++;
    }

    public void setHead(Vertex v) {
        head = new Node(v);
        bagNum++;
    }
    
    public Node getHead(){
        return head;
    }
    
//    public Node getHead(){
//        
//    }
    
    public void addNode(Vertex w){
        Node wNode = new Node(w);
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = wNode;
    }

    class Node {
        Vertex v = null;
        Node next = null;

        public Node(Vertex v2) {
            v = v2;
        }
        
        public Vertex getValue(){
            return v;
        }
        
        public Node getNext(){
            return next;
        }

    }

}
