/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Model.Point;
import java.util.Comparator;
/**
 *
 * @author macbook
 */
public class SortByX implements Comparator<Point> {
    public int compare(Point p1, Point p2) {        
        if(p1.getX()<p2.getX()){
            return -1;
        }
        if(p1.getX()>p2.getX()){
            return 1;
        }
        if(p1.getX()==p2.getX()){
            if(p1.getY()>p2.getY()){
                return -1;
            }
            if(p1.getY()<p2.getY()){
                return 1;
            }
        }
        return 0;
    }
}
