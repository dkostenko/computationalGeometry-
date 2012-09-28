/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author macbook
 */
public class Graham extends javax.swing.JPanel {
    private ArrayList<Point> points = null;
    private ArrayList<Point> result = null;
    /**
     * Creates new form Graham
     */
    public Graham() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        if (points == null){
            return;
        } else {
            grphcs.setColor(Color.RED);
            for (int i = 0; i < points.size(); ++i) {
                if(points.get(i) == null){
                    break;
                }
                grphcs.drawRect(points.get(i).getX(), points.get(i).getY(),
                    1, 1);
            }
            
            if(result != null){
                grphcs.setColor(Color.RED);
                grphcs.drawRect(result.get(0).getX(), result.get(0).getY(),
                    5, 5);
                grphcs.setColor(Color.BLACK);
                for(int i=0; i<result.size(); ++i){
                    grphcs.drawRect(result.get(i).getX(), result.get(i).getY(),
                    3, 3);
                }
            }
        }
    }

    
    
    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    /**
     * @param result the result to set
     */
    public void setResult(ArrayList<Point> result) {
        this.result = result;
    }
}
