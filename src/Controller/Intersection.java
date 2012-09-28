/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Point;
import java.util.ArrayList;

/**
 *
 * @author macbook
 */
public class Intersection {
    private ArrayList<Point> points = null;

    public Intersection() {
    }

    public boolean isIntersection(){
        int d1 = BasicFunctions.direction(points.get(2), 
                                          points.get(3), 
                                          points.get(0));
        int d2 = BasicFunctions.direction(points.get(2), 
                                          points.get(3), 
                                          points.get(1));
        int d3 = BasicFunctions.direction(points.get(0), 
                                          points.get(1), 
                                          points.get(2));
        int d4 = BasicFunctions.direction(points.get(0), 
                                          points.get(1), 
                                          points.get(3));
        
        if(((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) && 
                ((d3 > 0 && d4 < 0) ||(d3 < 0 && d4 > 0))){
            return true;
        } else {
            if (d1==0 && onSegment(points.get(2), 
                                   points.get(3), 
                                   points.get(0))){
                return true;
            } else {
                if (d2==0 && onSegment(points.get(2), 
                                       points.get(3), 
                                       points.get(1))){
                    return true;
                } else {
                   if (d3==0 && onSegment(points.get(0), 
                                          points.get(1), 
                                          points.get(2))){
                       return true;
                   } else {
                       if (d4==0 && onSegment(points.get(0), 
                                              points.get(1), 
                                              points.get(3))){
                           return true;
                       } else {
                           return false;
                       }
                   }
                }
            }
        }
    }

    
    private boolean onSegment(Point i, Point j, Point k){
        if(Math.min(i.getX(), j.getX()) <= k.getX() && 
                k.getX() <= Math.max(i.getX(), j.getX()) &&
                Math.min(i.getY(), j.getY()) <= k.getY() &&
                k.getY() <= Math.max(i.getY(), j.getY())
                ){
            return true;
        } else {
          return false;  
        }

    }
    
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
