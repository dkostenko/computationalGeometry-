/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Point;
import Model.SortByX;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author macbook
 */
public class NearestPoints_controller {

    private ArrayList<Point> points = null;
    
    public NearestPoints_controller() {
    }
    
    public ArrayList findNeares(){
        //Сортируем точки по Х
        Collections.sort(points, new SortByX()); 
        
        
        System.out.println("all points");
        for (int i = 0; i < points.size(); ++i) {
            System.out.println(points.get(i).getInfo());
        }
        System.out.println("===================");
        
        
        
        


        
        //NearestPoints_controller.findNearPoints(points);
        

        return null;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    
    public static ArrayList findNearPoints(ArrayList<Point> points){
        if(points.size()>3){
            ArrayList<Point> leftSide = new ArrayList<Point>();
            for (int i = 0; i < points.size()/2; ++i) {
                leftSide.add(points.get(i));
            }

            ArrayList<Point> rightSide = new ArrayList<Point>();
            for (int i = points.size()/2; i < points.size(); ++i) {
                rightSide.add(points.get(i));
            }        


            System.out.println("left points");
            for (int i = 0; i < leftSide.size(); ++i) {
                System.out.println(leftSide.get(i).getInfo());
            }
            System.out.println("===================");


            System.out.println("right points");
            for (int i = 0; i < rightSide.size(); ++i) {
                System.out.println(rightSide.get(i).getInfo());
            }
            System.out.println("===================");


            System.out.println("leftSide.size() = "+leftSide.size());
            System.out.println("rightSide.size() = "+rightSide.size());
            
            NearestPoints_controller.findNearPoints(leftSide);
            NearestPoints_controller.findNearPoints(rightSide);
        } else {
            if(points.size()==2){
            }
        }
                
        return null;
    }
    
}
