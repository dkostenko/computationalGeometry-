/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author macbook
 */
public class Point {

    private int x;
    private int y;
    private double r;
    private double theta;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.theta = Math.atan2(this.x, this.y);
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
     * @return the r
     */
    public double getR() {
        return r;
    }

    /**
     * @return the theta
     */
    public double getTheta() {
        return theta;
    }
}
