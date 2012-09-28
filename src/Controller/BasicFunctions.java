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
public class BasicFunctions {
    
    /**
     * @return Куда сворачивают 2 последовательных отрезка Px--Py и Py--Pz?
     * | (Pz - Px) * (Py - Px) |
     * Если результат отрицательный, то переход от направленного отрезка
     * Px--Py к направленному отрезку Px--Pz осуществляется против часовой
     * стрелки.
     * Если положительный - по часовой.
     */
    public static int direction(Point x, Point y, Point z){
        Point a = new Point(z.getX() - x.getX(), z.getY() - x.getY());
        Point b = new Point(y.getX() - x.getX(), y.getY() - x.getY());
        return (a.getX() * b.getY() - a.getY() * b.getX());
    }
}
