package view;

import Controller.Graham_controller;
import Model.Point;
import Controller.Intersection;
import java.util.ArrayList;
import javax.swing.JDialog;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class MainFrame extends javax.swing.JFrame {

//    private Point[] points = new Point[4];
//    List<String> list = Arrays.asList("1", "2", "3");
    private ArrayList<Point> points = new ArrayList<Point>();
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        drawPanel1.setPoints(points);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        drawPanel1 = new view.DrawPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        graham1 = new view.Graham();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        drawPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawPanel1MousePressed(evt);
            }
        });

        jButton2.setText("Заново");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Результат");

        org.jdesktop.layout.GroupLayout drawPanel1Layout = new org.jdesktop.layout.GroupLayout(drawPanel1);
        drawPanel1.setLayout(drawPanel1Layout);
        drawPanel1Layout.setHorizontalGroup(
            drawPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(drawPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jButton2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 166, Short.MAX_VALUE)
                .add(jLabel1)
                .add(21, 21, 21))
        );
        drawPanel1Layout.setVerticalGroup(
            drawPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, drawPanel1Layout.createSequentialGroup()
                .addContainerGap(298, Short.MAX_VALUE)
                .add(drawPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2)
                    .add(jLabel1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Пересечение", drawPanel1);

        graham1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                graham1MousePressed(evt);
            }
        });

        jButton1.setText("Заново");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton3.setText("Запустить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout graham1Layout = new org.jdesktop.layout.GroupLayout(graham1);
        graham1.setLayout(graham1Layout);
        graham1Layout.setHorizontalGroup(
            graham1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(graham1Layout.createSequentialGroup()
                .add(jButton1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 141, Short.MAX_VALUE)
                .add(jButton3)
                .addContainerGap())
        );
        graham1Layout.setVerticalGroup(
            graham1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, graham1Layout.createSequentialGroup()
                .addContainerGap(298, Short.MAX_VALUE)
                .add(graham1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton3))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Полигон", graham1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drawPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawPanel1MousePressed
        if (points.size() < 4) {
            points.add(new Point(evt.getX(), evt.getY()));
            repaint();
        }
        if (points.size() == 4) {
            Intersection intersection = new Intersection();
            intersection.setPoints(points);
            jLabel1.setText(intersection.isIntersection()?
                    "Пересекает":"Не пересекает");
        }
    }//GEN-LAST:event_drawPanel1MousePressed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        System.out.println(jTabbedPane1.getSelectedIndex());
        switch(jTabbedPane1.getSelectedIndex()){
            case 0: 
                points = new ArrayList<Point>();
                drawPanel1.setPoints(points);
                jLabel1.setText("Результат");
                break;
            case 1:
                points = new ArrayList<Point>();
                graham1.setPoints(points);
                graham1.setResult(null);
                jButton3.setEnabled(false);
                break;
            default: break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        points = new ArrayList<Point>();
        drawPanel1.setPoints(points);
        jLabel1.setText("Результат");
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void graham1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graham1MousePressed
        boolean may_add = true;
        for(int i=0; i<points.size(); ++i){
            if(points.get(i).getX() == evt.getX() && 
                    points.get(i).getY() == evt.getY()){
                may_add = false;
                break;
            }
        }
        
        if (may_add) {
            points.add(new Point(evt.getX(), evt.getY()));
        }

        if(points.size() == 3){
            jButton3.setEnabled(true);
        }
        repaint();
    }//GEN-LAST:event_graham1MousePressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //очистка Грехема
        points = new ArrayList<Point>();
        graham1.setPoints(points);
        graham1.setResult(null);
        repaint();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Graham_controller graham = new Graham_controller();
        graham.setPoints(points);
        ArrayList<Point> result_points = graham.doGraham();
        if(result_points!=null){
            graham1.setResult(result_points);
            repaint();
        } else {
            System.out.println("Не достаточно точек!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.DrawPanel drawPanel1;
    private view.Graham graham1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
