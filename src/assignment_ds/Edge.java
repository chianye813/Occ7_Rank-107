/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

/**
 *
 * @author TEOH YU XUAN
 */
public class Edge<T extends Comparable<T>, N extends Comparable<N>> {
    Vertex<T,N> toVertex;
    N weight;
    Edge<T, N> nextEdge;
    
    public Edge(){
        toVertex=null;
        weight=null;
        nextEdge=null;
    }
    public Edge(Vertex<T, N>destination, N w, Edge<T,N>a){
        toVertex=destination;
        weight=w;
        nextEdge=a;
    }
    public Vertex<T,N> getDestination(){
        return toVertex;
    }
    public N getWeight() {
        return weight;
    }
}
