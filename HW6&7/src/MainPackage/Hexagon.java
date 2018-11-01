package MainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;


public class Hexagon extends Shape{
    double length; 
    LocalPoint PointC1; 
    LocalPoint PointC2; 
    LocalPoint PointC3;
    Hexagon(){}; 
    public Hexagon(LocalPoint Point, double length, Color c, double angle, boolean filled) {
        this.angle   = angle; 
        this.Point   = Point; 
        this.length  = length; 
        this.c       = c; 
        if (angle == 1){
            this.setLocation((int)Point.local_X, (int)Point.local_Y);  
            this.setSize((int)(2*length), (int)(Math.sqrt(3)*length));  
            PointC1 = new LocalPoint(length/2, 0); 
            PointC2 = new LocalPoint(2*length, Math.sqrt(3)*length/2); 
            PointC3 = new LocalPoint(length/2, Math.sqrt(3)*length); 
        }else{
            this.setLocation((int)Point.local_X, (int)Point.local_Y);  
            this.setSize((int)(Math.sqrt(3)*length), (int)(2*length)); 
            PointC1 = new LocalPoint(0, length/2); 
            PointC2 = new LocalPoint(Math.sqrt(3)*length/2, 2*length); 
            PointC3 = new LocalPoint(Math.sqrt(3)*length, length/2);
        }
    }
    
  
    public double getArea(){
        return 3*Math.sqrt(3)*length*length/2; 
    }
    
    public double gerPrimeter(){
        return length*6; 
    }
    
    @Override
    public String toString(){
        return "Hexagon"; 
    }
    
    
    @Override
    public void paint(Graphics g) {
        g.setColor(this.c);
        Polygon P1 = new Polygon(); 
            // standardized Point. 
        if (angle == 1){
            P1.addPoint((int)(length/2), 0); // check1. 
            P1.addPoint((int)(3*length/2), 0);
            P1.addPoint((int)(2*length), (int)(Math.sqrt(3)*length/2)); // check2. 
            P1.addPoint((int)(3*length/2), (int)(Math.sqrt(3)*length));
            P1.addPoint((int)(length/2), (int)(Math.sqrt(3)*length));   // check3. 
            P1.addPoint(0, (int)(Math.sqrt(3)*length/2));
            
            // assignment point check. 
            
        }else{
            P1.addPoint(0, (int)(length/2)); // check1. 
            P1.addPoint(0, (int)(3*length/2));
            P1.addPoint((int)(Math.sqrt(3)*length/2), (int)(2*length)); // check2.
            P1.addPoint((int)(Math.sqrt(3)*length), (int)(3*length/2));
            P1.addPoint((int)(Math.sqrt(3)*length), (int)(length/2));   // check3. 
            P1.addPoint((int)(Math.sqrt(3)*length/2), 0);
            
            // assignment point check.        
        }
        if (filled){           
            g.fillPolygon(P1);            
        }
        else{            
            g.drawPolygon(P1);           
        }
    }
    public static void main(String args[]){
        JFrame MainGrap = new JFrame("test "); 
        LocalPoint P1 = new LocalPoint(0, 0), P2 = new LocalPoint(100, 0), P3 = new LocalPoint(0, 50);
        Hexagon Tri = new Hexagon(P1, 100, Color.CYAN, 1, true);
        MainGrap.add(Tri); 

        MainGrap.setSize(700, 500);
       
        MainGrap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainGrap.setVisible(true);
            
    }
    
    @Override
    public boolean Equal(Shape s) {
          Hexagon H = (Hexagon)s; 
          return this.Point.equal(H.Point) && this.length == H.length && this.PointC1.equal(H.PointC1)
                && this.PointC2.equal(H.PointC2) && this.PointC3.equal(H.PointC3);
    }

    @Override
    public boolean EqualShape(Shape s) {
        return s instanceof Hexagon; 
    }

}
