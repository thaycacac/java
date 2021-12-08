/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0001;

import java.awt.Graphics2D;
import javax.swing.JOptionPane;

/**
 *
 * @author tuans
 */
public class ControlScreen {
    P0001 screen;

    public ControlScreen() {
    }

    ControlScreen(P0001 screenTemp) {
        screen=screenTemp;
    }
    
    public void visualize(){
        screen.getPnGraph().removeAll();
        screen.getPnGraph().repaint();
        try{
            AnalizeGraphInput analize=new AnalizeGraphInput(screen.getTxtInput().getText().toString());
            String name=analize.getNameGraph();
            screen.getTxtLabelGraph().setText("Graph - "+name);
            analize.analize();
            screen.setGraph(analize.createGraph());
            //graph=analize.createGraph();
            DrawGraph draw=new DrawGraph(screen.getGraph());
            screen.setCanvas((DrawGraph) draw.getCanvas());
            Graphics2D g=(Graphics2D) screen.getCanvas().getGraphics();
            //pnGraph.paintComponents(g);
            //canvas.update(getGraphics());

            screen.getPnGraph().add(screen.getCanvas());
            screen.getPnGraph().repaint();
        } catch (Exception e){
            JOptionPane.showMessageDialog(screen, e.getMessage());
        }
        
    }
}
