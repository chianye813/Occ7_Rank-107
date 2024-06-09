/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_ds;

/**
 *
 * @author TEOH YU XUAN
 */
public class Vertex<T extends Comparable<T>, N extends Comparable<N>>{
    T vertexInfo;
    int indeg;
    int outdeg;
    Vertex<T, N> nextVertex; //reference to next vertex
    Edge<T, N> firstEdge; //reference to first edge node
    
    public Vertex(){
        vertexInfo=null;
        indeg=0;
        outdeg=0;
        nextVertex=null;
        firstEdge=null;
    }
    public Vertex(T vinfo, Vertex<T, N> next){
        vertexInfo=vinfo;
        indeg=0;
        outdeg=0;
        nextVertex=next;
        firstEdge=null;
    }
}

