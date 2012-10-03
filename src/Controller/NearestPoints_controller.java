/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.NearestSort;
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
    private ArrayList<Point> result = null;
    private int[]X;
    private int[]Y;
    
    public NearestPoints_controller() {
    }
    
    public ArrayList findNeares(ArrayList points){
        result = new ArrayList<Point>();
        result = points;
        
        Collections.sort(points, new NearestSort());
        
        
        
        SortByX sortByX = new SortByX();
        Collections.sort(result, sortByX);
        
        
        
        X = new int[points.size()];
        Y = new int[points.size()];
        return result;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    
    
}
