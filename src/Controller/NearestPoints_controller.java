/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
    
    public NearestPoints_controller() {
    }
    
    public ArrayList findNeares(){
        //Сортируем точки по Х
        Collections.sort(points, new SortByX()); 
        
        
        System.out.println("all points");
        for (int i = 0; i < points.size(); ++i) {
            System.out.println(points.get(i).getInfo());
        }
        System.out.println("===================");
        
        
        
        


        
        double[] result = NearestPoints_controller.findNearPoints(points);
        
//        System.out.println(" x1=" + result[0] + " === y1="+ result[1] + 
//                           " x2=" + result[2] + " === y2="+ result[3]);
//        System.out.println("===================");
        
        
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        result[0] = p1.getX();
        result[1] = p1.getY();
        result[2] = p2.getX();
        result[3] = p2.getY();
        result[4] = BasicFunctions.distance(p1.getX(), p1.getY(), p2.getX(), 
                                                                  p2.getY());
        for (int i = 0; i < points.size(); ++i) {
            for (int j = 0; j < points.size(); ++j) {
                if(i!=j){
                    if(BasicFunctions.distance(points.get(i).getX(),
                                               points.get(i).getY(),
                                               points.get(j).getX(),
                                               points.get(j).getY()) < result[4]){
                        result[0] = points.get(i).getX();
                        result[1] = points.get(i).getY();
                        result[2] = points.get(j).getX();
                        result[3] = points.get(j).getY();
                        result[4] = BasicFunctions.distance(points.get(i).getX(),
                                               points.get(i).getY(),
                                               points.get(j).getX(),
                                               points.get(j).getY());
                    }
                }
            }
        }
        
        
        ArrayList<Point> resultPoints = new ArrayList<Point>();
        resultPoints.add(new Point((int)result[0], (int)result[1]));
        resultPoints.add(new Point((int)result[2], (int)result[3]));
        
        return resultPoints;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    
    public static double[] findNearPoints(ArrayList<Point> addPoints){
        if(addPoints.size()<4){
            return brutForce(addPoints);
        } else {
            ArrayList<Point> xL = new ArrayList<Point>();
            for (int i = 0; i < addPoints.size()/2; ++i) {
                xL.add(addPoints.get(i));
            }
            
            ArrayList<Point> xR = new ArrayList<Point>();
            for (int i = addPoints.size()/2; i < addPoints.size(); ++i) {
                xR.add(addPoints.get(i));
            }
            
            int xm = addPoints.get(addPoints.size()/2).getX();
            
            
            double[] resultL = findNearPoints(xL);
            double[] resultR = findNearPoints(xR);
            double[] dminPairMin = resultR;
            
            double[] closest = dminPairMin;
            if(resultL[4]<resultR[4]){
                dminPairMin =  resultL;
            }
            ArrayList<Point> yS = new ArrayList<Point>();
            for (int i = 0; i < addPoints.size(); ++i) {
                if(Math.abs(xm - addPoints.get(i).getX()) < dminPairMin[4]){
                    yS.add(addPoints.get(i));
                }
                
            }
            
            for (int i = 0; i < yS.size(); ++i) {
                for (int j = 0; j < yS.size(); ++j) {
                    if(i!=j){
                        if(BasicFunctions.distance(yS.get(i).getX(),
                                                   yS.get(i).getY(),
                                                   yS.get(j).getX(),
                                                   yS.get(j).getY()) < closest[4]){
                            closest[0] = yS.get(i).getX();
                            closest[1] = yS.get(i).getY();
                            closest[2] = yS.get(j).getX();
                            closest[3] = yS.get(j).getY();
                            closest[4] = BasicFunctions.distance(yS.get(i).getX(),
                                                   yS.get(i).getY(),
                                                   yS.get(j).getX(),
                                                   yS.get(j).getY());
                        }
                    }
                }
            }
            
            
            return closest;
        }
    }
    
    static double[] brutForce(ArrayList<Point> addPoints){
        double[] result = new double[5];
        Point p1 = addPoints.get(0);
        Point p2 = addPoints.get(1);
        
        if(addPoints.size()==2){
            result[0] = p1.getX();
            result[1] = p1.getY();
            result[2] = p2.getX();
            result[3] = p2.getY();
            result[4] = BasicFunctions.distance(p1.getX(), p1.getY(),
                                    p2.getX(), p2.getY());
            
        } else {
            Point p3 = addPoints.get(2);
            double[] result12 = new double[5];
            double[] result13 = new double[5];
            double[] result23 = new double[5];
            
            result12[0] = p1.getX();
            result12[1] = p1.getY();
            result12[2] = p2.getX();
            result12[3] = p2.getY();
            result12[4] = BasicFunctions.distance(p1.getX(), p1.getY(),
                                    p2.getX(), p2.getY());
            
            result13[0] = p1.getX();
            result13[1] = p1.getY();
            result13[2] = p3.getX();
            result13[3] = p3.getY();
            result13[4] = BasicFunctions.distance(p1.getX(), p1.getY(),
                                    p3.getX(), p3.getY());
            
            result23[0] = p2.getX();
            result23[1] = p2.getY();
            result23[2] = p3.getX();
            result23[3] = p3.getY();
            result23[4] = BasicFunctions.distance(p2.getX(), p2.getY(),
                                    p3.getX(), p3.getY());
            
            if(result12[4] < result13[4]){
                if(result12[4] < result23[4]){
                    result = result12;
                } else {
                    result = result23;
                }
            } else {
                if(result13[4] < result23[4]){
                    result = result13;
                } else {
                    result = result23;
                }
            }
        }
        return result;
    }
    
}
