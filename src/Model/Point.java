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
    private int segment_num;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String getInfo(){
        return "X="+this.x+"  Y="+this.y+"  segment_num="+this.segment_num;
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

    /**
     * @return the segment_num
     */
    public int getSegment_num() {
        return segment_num;
    }

    /**
     * @param segment_num the segment_num to set
     */
    public void setSegment_num(int segment_num) {
        this.segment_num = segment_num;
    }
}
