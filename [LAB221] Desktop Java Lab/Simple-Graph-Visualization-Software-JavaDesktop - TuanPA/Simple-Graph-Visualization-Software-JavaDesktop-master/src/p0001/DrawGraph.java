/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0001;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author tuans
 */
public class DrawGraph extends Canvas{
    //canvas create after paint graph
    final Canvas canvas;
    final int INT_SIZE=5;
    Graph graph;
    Boolean firstPaint=false;
    //list of axis point to draw
    HashMap<String, Pair> saveVerticesAxis;
    HashMap<String, Pair> sizeVertices;
    Vector<Vector> saveEdges;
    public DrawGraph() {
        this.setSize(300, 300);
        canvas = this;
        saveVerticesAxis=new HashMap<>();
        sizeVertices=new HashMap<>();
        saveEdges=new Vector<>();
    }
    public DrawGraph(Graph graph){
        this.setSize(300,300);
        this.graph=graph;
        canvas=this;
        saveVerticesAxis=new HashMap<>();
        sizeVertices=new HashMap<>();
        saveEdges=new Vector<>();
    }
    //return canvas of drawGraph
    public Canvas getCanvas(){
        return canvas;
    }
    private void initGraphic(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, this.getWidth()*10, this.getHeight()*10);
    }
    private void initAxis(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        Iterator it=graph.nameVertice.entrySet().iterator();
        //loop to paint all element
        while (it.hasNext()){
            Map.Entry pair=(Map.Entry) it.next();
            String name=(String) pair.getKey();
            Vector propertise=graph.propertiseVertice.get(name);
            String label=(String) propertise.get(0);
            String color=(String) propertise.get(1);
//            int x=getRanNum(0,250,'X');
//            int y=getRanNum(0,250,'Y');
//            saveVerticesAxis.put(name,new Pair<>(x,y));
            Pair<Integer,Integer> pairAxis;
            pairAxis=generateAxis(name);
            saveVerticesAxis.put(name, pairAxis);
            String text=label;
            FontMetrics fm=g2.getFontMetrics();
            
            int w=fm.stringWidth(text);
            int h=fm.getAscent();
            sizeVertices.put(name, new Pair(h*4,w*2));
        }
        
    }
    
    //if has not axis of element, random axis to draw it
    public void paint(Graphics g){
        if (firstPaint==false){
            g.create();
            initGraphic(g);
            initAxis(g);
            //firstPaintToImage(g);
            paintWithSavedData(g);
            firstPaint=true;
        }else{
            initGraphic(g);
            paintWithSavedData(g);
        }
        
    }
    //if has axis of element, use it to draw it
    public void paintWithSavedData(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
        Iterator it=graph.nameVertice.entrySet().iterator();
        int position=0;
        //loop to paint all edges
        for (Pair edge:graph.adjEdges){
            String u=(String) edge.getKey();
            String v=(String) edge.getValue();
            String label=graph.getLabelEdge(u, v);
            int x1=(int) saveVerticesAxis.get(u).getKey();
            int y1=(int) saveVerticesAxis.get(u).getValue();
            int height1=(int) sizeVertices.get(u).getKey();
            int width1=(int) sizeVertices.get(u).getValue();
            int x2=(int) saveVerticesAxis.get(v).getKey();
            int y2=(int) saveVerticesAxis.get(v).getValue();
            int height2=(int) sizeVertices.get(v).getKey();
            int width2=(int) sizeVertices.get(v).getValue();
            //drawFullfill(g, "", "", "white", x1, y1);
            //drawFullfill(g, "", "", "white", x2, y2);
            drawArrow(g, x1+width1/2, y1+height1/2, x2+width2/2, y2+height2/2, label);
        }
        //loop to paint all vertices
        while (it.hasNext()){
            Map.Entry pair=(Map.Entry) it.next();
            String name=(String) pair.getKey();
            Vector propertise=graph.propertiseVertice.get(name);
            String label=(String) propertise.get(0);
            String color=(String) propertise.get(1);
            Pair saved=(Pair) saveVerticesAxis.get(name);
            int x=(int) saved.getKey();
            int y=(int) saved.getValue();
            drawFullfill(g, name, "", "white", x, y);
            drawVertice(g,name,label,color,x,y);
            position++;
        }
        
        
    }
    //process draw vertice into graphic with its information
    private void drawFullfill(Graphics g, String name, String label, String color,int x,int y) {
        Graphics2D g2 = (Graphics2D) g;
        Color colorBorder;
        //get color type from string type 
        try {
            Field field = Class.forName("java.awt.Color").getField(color);
            colorBorder = (Color)field.get(null);
        } catch (Exception e) {
            colorBorder = null; // Not defined
        }
        g2.setColor(colorBorder);
        //set border for vertice
        float thickness=3;
        Stroke oldStroke=g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));
        //set width and height for text inside vertice
        String text=label;
        FontMetrics fm=g2.getFontMetrics();
        int w=fm.stringWidth(text);
        int h=fm.getAscent();

        int height=(int) sizeVertices.get(name).getKey();
        int width=(int) sizeVertices.get(name).getValue();
        
        g2.fillOval(x, y,width, height);

        g2.setStroke(oldStroke);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("TimesNewRoman", Font.BOLD, 13));
        //draw string inside vertice
        g2.drawString(text, x+(w/2), y+(h*2));
    }
    //process draw vertice into graphic with its information
    private void drawVertice(Graphics g, String name, String label, String color,int x,int y) {
        Graphics2D g2 = (Graphics2D) g;
        Color colorBorder;
        //get color type from string type 
        try {
            Field field = Class.forName("java.awt.Color").getField(color);
            colorBorder = (Color)field.get(null);
        } catch (Exception e) {
            colorBorder = null; // Not defined
        }
        g2.setColor(colorBorder);
        //set border for vertice
        float thickness=3;
        Stroke oldStroke=g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));
        //set width and height for text inside vertice
        String text=label;
        FontMetrics fm=g2.getFontMetrics();
        int w=fm.stringWidth(text);
        int h=fm.getAscent();

        int height=(int) sizeVertices.get(name).getKey();
        int width=(int) sizeVertices.get(name).getValue();
        
        g2.drawOval(x, y,width, height);

        g2.setStroke(oldStroke);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("TimesNewRoman", Font.BOLD, 13));
        //draw string inside vertice
        g2.drawString(text, x+(w/2), y+(h*2));
    }
    //process draw arrow for (x1,y1) to (x2,y2) into graphic
    private void drawArrow(Graphics g, int x1, int y1, int x2, int y2,String label) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        int ARR_SIZE = 10;
        //set border for line
        float thickness=2;
        Stroke oldStroke=g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(Color.BLACK);
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        //transform the draw
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g2.transform(at);
        
        // Draw horizontal arrow starting in (0, 0)
        g2.drawLine(0, 0, len, 0);
        g2.fillPolygon(new int[] {len/2, len/2-ARR_SIZE, len/2-ARR_SIZE},
                      new int[] {0, -ARR_SIZE, ARR_SIZE}, 3);
        
        //set old status of graphic
        g2.setStroke(oldStroke);
        try {
            g2.transform(at.createInverse());
        } catch (NoninvertibleTransformException ex) {
            Logger.getLogger(DrawGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
        g2.drawString(label, (x1+x2)/2+8, (y1+y2)/2);
    }
    //return random number from min to max
    private int getRanNum(int min, int max, char label) {
        while (true){
            int number = new Random().nextInt(max - min) +min;
            if (check(number,label)){
                return number;
            }
        }
    }

    private boolean check(int number,char label) {
        Iterator it=saveVerticesAxis.entrySet().iterator();
        Boolean ok=false;
        while (it.hasNext()){
            Map.Entry pair=(Map.Entry) it.next();
            Pair value = (Pair) pair.getValue();
            int x=(int) value.getKey();
            int y=(int) value.getValue();
            int numGet=(label=='X')?x:y;
            if (Math.abs(numGet-number)<50){
                return false;
            }
        }
        return true;
    }

    private Pair<Integer, Integer> generateAxis(String name) {
        Pair<Integer,Integer> pair=null;
        for (int xAxis=0;xAxis<=250;xAxis++){
            for (int yAxis=0;yAxis<=250;yAxis++){
                if (checkDistance(xAxis,yAxis)){
                    pair=new Pair(xAxis,yAxis);
                    Pair pairVertices=checkCircle(name);
                    if (pairVertices!=null){
                        pair=getAxisForCirle3Element(pairVertices);
                    }
                    break;
                }
            }
            if (pair!=null) break;
        }
        return pair;
    }

    private boolean checkDistance(int xAxis, int yAxis) {
        Iterator it=saveVerticesAxis.entrySet().iterator();
        Boolean ok=false;
        while (it.hasNext()){
            Map.Entry pair=(Map.Entry) it.next();
            Pair value = (Pair) pair.getValue();
            int x=(int) value.getKey();
            int y=(int) value.getValue();
            Double distance=Math.sqrt((xAxis-x)*(xAxis-x)+(yAxis-y)*(yAxis-y));
            if (distance<=120) return false;
        }
        return true;
    }

    private Pair checkCircle(String name) {
        Iterator it1=saveVerticesAxis.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry pair1=(Map.Entry) it1.next();
            String name1=(String) pair1.getKey();
            Iterator it2=saveVerticesAxis.entrySet().iterator();
            while(it2.hasNext()){
                Map.Entry pair2=(Map.Entry) it2.next();
                String name2=(String) pair2.getKey();
                if (name1.equals(name2))
                    continue;
                if (graph.hasCircle(name, name1, name2)){
                    return new Pair(name1, name2);
                }
            }
        }
        return null;
    }
    private double distance(int x1,int y1,int x2,int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    private Pair getAxisForCirle3Element(Pair pairVertices) {
        String nameVertice1=(String) pairVertices.getKey();
        String nameVertice2=(String) pairVertices.getValue();
        int xAxis1=(int) saveVerticesAxis.get(nameVertice1).getKey();
        int yAxis1=(int) saveVerticesAxis.get(nameVertice1).getValue();
        int xAxis2=(int) saveVerticesAxis.get(nameVertice2).getKey();
        int yAxis2=(int) saveVerticesAxis.get(nameVertice2).getValue();
        int xMidPoint=(xAxis1+xAxis2)/2;
        int yMidPoint=(yAxis1+yAxis2)/2;
        for (int x=0;x<=250;x++){
            for (int y=0;y<=250;y++){
                double dis1=distance(x, y, xAxis1, yAxis1);
                double dis2=distance(x,y, xAxis2, yAxis2);
                if (Math.abs(dis2-dis1)<10 && distance(x, y, xMidPoint, yMidPoint)>distance(xAxis1, yAxis1, xAxis2, yAxis2)/2){
                    if (checkDistance(x, y))
                    return new Pair(x, y);
                }
            }
        }
        return null;
    }
}
