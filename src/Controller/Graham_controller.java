/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Point;
import Model.SortComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author macbook
 */
public class Graham_controller {
    private ArrayList<Point> points = null;
    private ArrayList<Point> s = null;

    public Graham_controller() {
    }
    
    public ArrayList doGraham(){
        System.out.println("===" + points.size());
        
        s = new ArrayList<Point>();
        int with_min_y=0;
        for(int i=1; i<points.size(); ++i){
            if(points.get(i).getY() < points.get(i-1).getY()){
                with_min_y=i;
            }
        }
        
        for(int i=0; i<points.size(); ++i){
            if(points.get(with_min_y).getY() == points.get(i).getY() && 
                    points.get(i).getX() < points.get(with_min_y).getX() ){
                with_min_y = i;
                break;
            }
        }
        
        
      
        for(int i=0; i<points.size(); ++i){
            points.get(i).setTheta(Math.atan2(
                    points.get(i).getX() - points.get(with_min_y).getX(), 
                    points.get(i).getY() - points.get(with_min_y).getY())
                    );
            if(points.get(i).getTheta() == 0){
                s.add(points.get(i));
                points.remove(i);
            }
        }
        
        
        SortComparator comparator = new SortComparator();
        Collections.sort(points, comparator);
        
        s.add(points.get(0));
        s.add(points.get(1));
        
        for(int i=2; i<points.size(); i++){
            Point p1 = top();
            Point p2 = next_to_top();
            Point p0 = points.get(i);
            int xl = p0.getX() - p1.getX();
            int yl = p0.getY() - p1.getY();
            
            int xll = p2.getX() - p1.getX();
            int yll = p2.getY() - p1.getY();
            
            while (xl*yll - xll*yl >= 0){
                s.remove(s.size()-1);
            }
            s.add(points.get(i));
        }
        
        
        return s;
    }
    
    private Point top(){
        return s.get(s.size()-1);
    }
    
    private Point next_to_top(){
        return s.get(s.size()-1);
    }

    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
