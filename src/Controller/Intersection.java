/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Point;

/**
 *
 * @author macbook
 */
public class Intersection {
    private Point[] points = null;

    public Intersection() {
    }

    public boolean isIntersection(){
        int d1 = direction(points[2], points[3], points[0]);
        int d2 = direction(points[2], points[3], points[1]);
        int d3 = direction(points[0], points[1], points[2]);
        int d4 = direction(points[0], points[1], points[3]);
        
        if(((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) && 
                ((d3 > 0 && d4 < 0) ||(d3 < 0 && d4 > 0))){
            return true;
        } else {
            if (d1==0 && onSegment(points[2], points[3], points[0])){
                return true;
            } else {
                if (d2==0 && onSegment(points[2], points[3], points[1])){
                    return true;
                } else {
                   if (d3==0 && onSegment(points[0], points[1], points[2])){
                       return true;
                   } else {
                       if (d4==0 && onSegment(points[0], points[1], points[3])){
                           return true;
                       } else {
                           return false;
                       }
                   }
                }
            }
        }
    }
    private int direction(Point x, Point y, Point z){
        Point a = new Point(z.getX() - x.getX(), z.getY() - x.getY());
        Point b = new Point(y.getX() - x.getX(), y.getY() - x.getY());
        return (a.getX() * b.getY() - a.getY() * b.getX());
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
    
    public void setPoints(Point[] points) {
        this.points = points;
    }
}
