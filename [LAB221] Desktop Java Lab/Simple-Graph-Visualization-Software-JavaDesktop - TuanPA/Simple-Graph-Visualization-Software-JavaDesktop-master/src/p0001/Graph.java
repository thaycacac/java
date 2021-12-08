/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0001;
//taieubfibuefiusbe
import java.util.HashMap;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author tuans
 */
public class Graph {
    int sizeGraph;
    String[][] matrixGraph;
    int labelName;   
    HashMap<String, Integer> nameVertice;
    HashMap<String, Vector> propertiseVertice;
    Vector<Pair<String,String>> adjEdges;
    public Graph(){}
    public Graph(int numberVertices) {
        sizeGraph=numberVertices;
        labelName=0;
        matrixGraph=new String[sizeGraph][sizeGraph];
        propertiseVertice=new HashMap<>();
        nameVertice=new HashMap<>();
        adjEdges=new Vector<>();
    }
    //add vertice to graph and name it by number
    void addVertice(String name,String label,String color){
        nameVertice.put(name, labelName++);
        Vector temp=new Vector();temp.add(label);temp.add(color);
        propertiseVertice.put(name,temp);
    }
    //add edge to graph
    void addEdge(String u, String v, String label){
        adjEdges.add(new Pair<>(u,v));
        matrixGraph[nameVertice.get(u)][nameVertice.get(v)]=label;
    }
    
    //return label of edge
    String getLabelEdge(String u,String v){
        String temp=matrixGraph[nameVertice.get(u)][nameVertice.get(v)];
        return matrixGraph[nameVertice.get(u)][nameVertice.get(v)];
    }
    Boolean hasVertice(String vertice){
        return nameVertice.get(vertice)==null?false:true;
    }
    Boolean hasEdge(String vertice1, String vertice2){
        boolean ok1=(getLabelEdge(vertice1, vertice2)!=null?true:false);
        boolean ok2=(getLabelEdge(vertice2, vertice1)!=null?true:false);
        if (ok1 || ok2) return true;
        else return false;
        
    }
    Boolean hasCircle(String vertice1, String vertice2, String vertice3){
        return (hasEdge(vertice1, vertice2) 
                && hasEdge(vertice1, vertice3)
                && hasEdge(vertice3, vertice2));
    }
}
