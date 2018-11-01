package MainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;


public class TriAngle extends Shape{
//    double length; 
    LocalPoint Point2; 
    LocalPoint Point3;  
    double     LengA, LengB, LengC; 
    TriAngle(){}; 
    TriAngle(LocalPoint Point1, LocalPoint Point2, LocalPoint Point3, Color c, boolean filled){
        this.Point   = Point1; 
        this.Point2  = Point2; 
        this.Point3  = Point3;       
        this.c       = c;
        this.filled  = filled; 
        // set length. 
        
        LengA = Math.sqrt(Math.pow(Point1.local_X - Point2.local_X, 2) + Math.pow(Point1.local_Y - Point2.local_Y, 2)); 
        LengB = Math.sqrt(Math.pow(Point2.local_X - Point3.local_X, 2) + Math.pow(Point2.local_Y - Point3.local_Y, 2)); 
        LengC = Math.sqrt(Math.pow(Point1.local_X - Point3.local_X, 2) + Math.pow(Point1.local_Y - Point3.local_Y, 2)); 
        
        // xet chieu rong. 
        double width1  = Point1.checkMaxLocalX(Point2, Point3) - Point1.checkMinLocalX(Point2, Point3); 
        double length1 = Point1.checkMaxLocalY(Point2, Point3) - Point1.checkMinLocalY(Point2, Point3); 
        
        this.setLocation((int)Point1.checkMinLocalX(Point2, Point3), (int)Point1.checkMinLocalY(Point2, Point3));
        
        this.setSize((int)width1, (int)length1);
      
    }
      
    public double getArea(){
        double P = gerPrimeter()/2; 
        return Math.sqrt(P*(P - LengA)*(P - LengB)*(P - LengC));
    }
    
    public double gerPrimeter(){
        return LengA + LengB + LengC; 
    }
      
    @Override
    public String toString(){
        return "TriAngle"; 
    }
    
    
    @Override
    public void paint(Graphics g) {
        g.setColor(this.c);
        Polygon P1 = new Polygon(); 
            // standardized Point. 
        double x0 = Point.checkMinLocalX(Point2, Point3), y0 = Point.checkMinLocalY(Point2, Point3); 
        double x1 = Point.local_X - x0, y1 = Point.local_Y - y0; 
        double x2 = Point2.local_X - x0, y2 = Point2.local_Y - y0;
        double x3 = Point3.local_X - x0, y3 = Point3.local_Y - y0; 
        P1.addPoint((int)x1, (int)y1);
        P1.addPoint((int)x2, (int)y2);
        P1.addPoint((int)x3, (int)y3);
        
        if (filled){
           
            g.fillPolygon(P1);
            
        }
        else{            
            g.drawPolygon(P1);           
        }
    }
    
    public static void main(String args[]){
        JFrame MainGrap = new JFrame("test "); 
        LocalPoint P1 = new LocalPoint(0, 0), P2 = new LocalPoint(100, 0), P3 = new LocalPoint(0, 100);

        TriAngle Tri  = new TriAngle(P1, P2, P3, Color.BLACK, true);
        TriAngle Tri2 = new TriAngle(); 
        Square   sq   = new Square(P2, 40, Color.BLACK, true, 1); 
        
        System.out.println(Tri.EqualShape(sq));
        
        MainGrap.add(Tri); 

        MainGrap.setSize(700, 500);
       
        MainGrap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainGrap.setVisible(true);
        
    }
    
//    public boolean EqualShape(Shape s){
//        return s instanceof TriAngle;
//    }
    
    @Override
    public boolean Equal(Shape s) {
        TriAngle T = (TriAngle)s; 
        int dem = 0; 
        if (this.Point.equal(T.Point2) || this.Point.equal(T.Point3)) dem++; 
        if (this.Point2.equal(T.Point) || this.Point2.equal(T.Point3)) dem++; 
        if (this.Point3.equal(T.Point) || this.Point3.equal(T.Point2)) dem++; 
        
        if (dem == 3)return true; 
        else return false; 
    }

    @Override
    public boolean EqualShape(Shape s) {
        return s instanceof TriAngle;
    }
    
}
