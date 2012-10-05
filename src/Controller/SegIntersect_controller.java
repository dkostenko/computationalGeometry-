/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Point;
import Model.SortByX;
import Model.SortComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author macbook
 */
public class SegIntersect_controller {
    private ArrayList<Point> points = null;
    private ArrayList<Point> addP = null;
    private int[] arrT;
    
    public SegIntersect_controller() {
    }
    
    public boolean isSegIntersect(){
        //инициализируем все необходимое
        addP = new ArrayList<Point>();
        addP.addAll(points);
        arrT = new int[addP.size()+1];
        for (int i = 0; i < arrT.length; ++i) {
            arrT[i] = -1;
        }
        
        
        System.out.println("Не отсортированный массив точек");
        for (int i = 0; i < addP.size(); ++i) {
            System.out.println(addP.get(i).getInfo());
        }
        System.out.println("=============");
        
        
        //сортируем точки по Х
        Collections.sort(addP, new SortByX());

        
        System.out.println("Отсортированный массив точек");
        for (int i = 0; i < addP.size(); ++i) {
            System.out.println(addP.get(i).getInfo());
        }
        System.out.println("=============");
        
        
        
        
        for (int i = 0; i < addP.size(); ++i) {
            if(isExistInT(addP.get(i).getSegment_num())){
                removeT(addP.get(i).getSegment_num());
            } else {
                insertT(addP.get(i).getSegment_num());
            }
            
            for (int j = 1; j < arrT.length; ++j) {
                if(arrT[j]==-1){
                    break;
                }
                Point[] a = getSegmentByNum(arrT[j]);
                Point[] b = getSegmentByNum(arrT[j-1]);
                ArrayList<Point> pointsForIntersection = new ArrayList<Point>();
                pointsForIntersection.add(a[0]);
                pointsForIntersection.add(a[1]);
                pointsForIntersection.add(b[0]);
                pointsForIntersection.add(b[1]);
                
                Intersection intersection = new Intersection();
                intersection.setPoints(pointsForIntersection);
                if(intersection.isIntersection()){
                    return true;
                }
            }
            
//            System.out.println("масив Т на шаге i="+i);
//            for (int j = 0; j < arrT.length; j++) {
//                System.out.print(arrT[j]+", ");
//            }
//            System.out.println();
//            System.out.println("=============");
        }
        
        
        
        
        return false;
    }
    
    private void insertT(int s){
        System.out.println("СУПЕР МАССИВ");
        System.out.print("для точки "+s +" имеем:");
        for (int i = 0; i < arrT.length; i++) {
           if(arrT[i]==-1){
               break;
           }
           System.out.print(arrT[i] +", "); 
        }
        System.out.println();
        System.out.println("=============");
        
        
        int i;
        for (i = 0; i < addP.size(); ++i) {
            if(arrT[i]==-1 || addP.get(s).getY() < addP.get(arrT[i]).getY()){
                break;
            }
        }
        
        for (int j = addP.size()-1; j >= i; --j) {
            if(arrT[j]!=-1){
                arrT[j+1]=arrT[j];
            }
        }
        
        
        
        arrT[i]=s;
    }
    
    private void removeT(int s){
        int i;
        for (i = 0; i < arrT.length; ++i) {
            if(s == arrT[i]){
                arrT[i] = -1;
                break;
            }
        }
        for(int j=i;j<arrT.length-1; ++j){
            arrT[j] = arrT[j+1];
        }
    }
    
    private boolean isExistInT(int s){
        for (int i = 0; i < arrT.length; ++i) {
            if(arrT[i] == s){
                return true;
            }
        }
        return false;
    }
    
    private Point[] getSegmentByNum(int num){
        Point[] seg = new Point[2];
        for (int i = 0; i < addP.size(); ++i) {
            if(addP.get(i).getSegment_num() == num){
                if(seg[0]==null){
                    seg[0] = addP.get(i); 
                } else {
                    seg[1] = addP.get(i);
                }
            }
        }
        return seg;
    }
    
    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    
    
}
