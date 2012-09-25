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
public class SortComparator implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        return p1.getTheta().compareTo(p2.getTheta());
    }
}