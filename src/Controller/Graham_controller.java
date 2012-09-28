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
//    private ArrayList<Point> additi = null;

    public Graham_controller() {
    }
    
    public ArrayList doGraham(){        
        s = new ArrayList<Point>();
        
        int min_by_y = 0;
        for(int i=0;i<points.size();++i){
            if(points.get(i).getY() < points.get(min_by_y).getY()){
                min_by_y = i;
            }
        }
        //Нашел точку, которая минимальна по Y
        
        int n=0;
        for(int i=0; i<points.size();i++){
            if(points.get(i).getY() == points.get(min_by_y).getY() && 
               points.get(i).getX() == points.get(min_by_y).getX()     
               ){
                min_by_y = i;
            }
        }
        //Нашел точку, которая такая же по Y, но меньше по X
        
        s.add(points.get(min_by_y));
        
        
        for(int i=0; i<points.size(); ++i){
            points.get(i).setTheta(Math.atan2(points.get(i).getX() - 
                                              points.get(min_by_y).getX(), 
                                              points.get(i).getY() - 
                                              points.get(min_by_y).getY())
                                  );
            points.get(i).setR(Math.sqrt(points.get(i).getX()*
                                         points.get(i).getX() + 
                                         points.get(i).getY()*
                                         points.get(i).getY())
                              );
        }
        //Задал полярные углы и радиусы всем точкам относительно той, у которой 
        // минимальный Y
        

        
        if(points.size()<3){
            //если точек меньше 3х мы не можем запустить алгоритм
            return null;
        }
        SortComparator mySort = new SortComparator();
        Collections.sort(points, mySort);
        //Сортирую по полярному углу
        
        
//        System.out.println("points.size before = "+points.size());
        
        for(int i=0; i<points.size(); ++i){
            if(points.get(i).getTheta() == 0){
                points.remove(i);
                break;
            }
        }
        
//        System.out.println("points.size after = "+points.size());
        
        
        
        //Начинаем алгоритм
        s.add(points.get(0));
        s.add(points.get(1));
        s.add(points.get(2));
        
        
        for (int i = 3; i < points.size(); ++i) {
                while(BasicFunctions.direction(next_to_top(), 
                                            top(), 
                                            points.get(i))<0){
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
        return s.get(s.size()-2);
    }

    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}
