/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0001;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import javafx.util.Pair;
import java.awt.Color;
import java.lang.reflect.Field;
/**
 *
 * @author tuans
 */
public class AnalizeGraphInput {
    //snippet code has information about graph
    String inforGraph;
    //list information of all vertices
    HashMap<String, Pair<String,String>> inforVertices;
    //list information of all edges
    Vector<Pair<String,Pair<String,String>>> inforEdges;
    
    Graph graph;
    
    public AnalizeGraphInput(String text) throws Exception{
        inforGraph=text;
        inforVertices=new HashMap<>();
        inforEdges=new Vector();
        text=text.trim();
        if (text.length()==0){
            throw new Exception("You have not input anything\n"
                    + "Please input by form:\n"
                    + "NAME_GRAPH{\n"
                    + " vertice_name[label=\"{NOT_BLANK}\", color=\"{NOT_BLANK}\"}"
                    + "\n vertice->vertice[label=\"{NOT_BLANK}\"\n}");
        }
    }
    //return name of a graph from snippet code
    public String getNameGraph(){
        String name="";
        //name of graph is string before '{' character
        for (int i=0;i<inforGraph.length();i++){
            if (inforGraph.charAt(i)=='{') break;
            name+=inforGraph.charAt(i);
        }
        return name;
    }
    
    //process analize snippet code
    public void analize() throws Exception{
        StringTokenizer st=new StringTokenizer(inforGraph,"\n");
        int countLine=0;
        //loop all line of snippet code to read information
        while (st.hasMoreTokens()){
            String temp=st.nextToken();
            temp=temp.trim();
            countLine++;
            if (temp.length()>2 &&temp.substring(0, 2).equals("//")) continue;
            //a line is about vertice if has label and color
            if (temp.contains("label")&&temp.contains("color")){
                analizeVertice(countLine,temp);
            }
            //a line is about edge if has label
            else if (temp.contains("label")){
                analizeEdge(countLine,temp);
            }else{
                //not valid line
                if (temp.length()!=0 && !temp.contains(getNameGraph()) && !temp.equals("}")){
                    throw new Exception("Line "+countLine+""
                    +"\nInvalid syntax: "+temp
                    +"\nJust enter 2 syntax:\n"
                    + " vertice_name[label=\"{NOT_BLANK}\", color=\"{NOT_BLANK}\"}"
                    + "\n vertice->vertice[label=\"{NOT_BLANK}\"\n}");
                }
            }
        }
    }
    //return graph from information snippet code after analize
    public Graph createGraph() throws Exception{ 
        Graph graph=new Graph(getNumberVertices());
        Iterator it=inforVertices.entrySet().iterator();
        //loop to create vertices
        while (it.hasNext()){
            Map.Entry pair=(Map.Entry)it.next();
            String name=(String) pair.getKey();
            Pair propertise=(Pair) pair.getValue();
            String label=(String) propertise.getKey();
            String color=(String) propertise.getValue();
            graph.addVertice(name, label, color);
        }
        //loop to create edges
        for (Pair element:inforEdges){
            String u=(String) element.getKey();
            Pair temp=(Pair) element.getValue();
            String v=(String) temp.getKey();
            if (!graph.hasVertice(u)){
                throw new Exception("Vertice "+u+" not exist");
            }
            if (!graph.hasVertice(v)){
                throw new Exception("Vertice "+v+" not exist");
            }
            String label=(String) temp.getValue();
            graph.addEdge(u, v, label);
        }
        return graph;
    }
    //return size of graph = number vertices
    public int getNumberVertices(){
        return inforVertices.size();
    }
    //analize information of a vertice: name, label, color
    private void analizeVertice(int countLine, String inforVertice) throws Exception {
        boolean startLabel=false;
        boolean startColor=false;
        boolean startName=false;

        String labelVertice="",nameVertice="",colorVertice="";       
        StringTokenizer st=new StringTokenizer(inforVertice,"\t\"[] ");
        //read information from string after split
        while (st.hasMoreTokens()){
            String temp=st.nextToken();
            if (!startName){
                nameVertice=temp;
                startName=true;
                continue;
            }
            try{
                if (!startLabel && temp.contains("label")){
                    labelVertice=st.nextToken();
                    startLabel=true;
                    continue;
                }
                if (!startColor && temp.contains("color")){
                    colorVertice=st.nextToken();
                    startColor=true;
                    Color color=null;

                    Field field=Class.forName("java.awt.Color").getField(colorVertice);
                    color=(Color)field.get(null);
                    break;
                } 
            }catch (Exception e){
                if (labelVertice.equals("")||colorVertice.equals("")){
                    throw new Exception("Line "+countLine+"\n"
                            + "\nYour input propertise is blank.\n"
                            + "Just input vertice_name["
                            + "label=\"{NOT_BLANK}\",color=\"{NOT_BLANK}\"]");
                }else{
                    throw new Exception("Line "+countLine+"\n"
                            + "Your color is invalid");
                }
            }
        }
        inforVertices.put(nameVertice, new Pair<>(labelVertice,colorVertice));
    }
    //analize information of an edge: from vertice, to vertice, label
    private void analizeEdge(int countLine,String edge) throws Exception {
        StringTokenizer st=new StringTokenizer(edge,"\t\"->[] ");
        String u="",v="",label="";
        //read information from string after split
        while (st.hasMoreTokens()){
            String temp=st.nextToken();
            if (u.compareTo("")==0){
                u=temp;
                continue;
            }
            if (v.compareTo("")==0){
                v=temp;
                continue;
            }
            try{
                if (temp.contains("label")){
                    label=st.nextToken();
                    break;
                }
            }catch(Exception e){
                throw new Exception("Line "+countLine+"\n"+
                    "Your input propertise is blank.\n"
                    + "Just input vertice->vertice["
                    + "label=\"{NOT_BLANK}\"]");
            }
            
            
        }
        Pair pair1=new Pair(v, label);
        inforEdges.add(new Pair(u,pair1));     
    }
}
