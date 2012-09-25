/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.Comparator;

/**
 *
 * @author macbook
 */
public class Point{

    private int x;
    private int y;
    private Double theta;
    private Double r;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the theta
     */
    public Double getTheta() {
        return theta;
    }

    /**
     * @param theta the theta to set
     */
    public void setTheta(Double theta) {
        this.theta = theta;
    }

    /**
     * @return the r
     */
    public Double getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Double r) {
        this.r = r;
    }
}
