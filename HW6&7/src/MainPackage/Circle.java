package MainPackage;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Circle extends Shape 
{
   
    public double radius = 1;
    public final double PI = 3.14; 
    
    
    public double getRadius() {
        return radius;
    }
    
    Circle(){}; 
    Circle(LocalPoint Point, double radius, Color c, boolean filled){
        this.radius = radius; 
        this.c      = c; 
        this.filled = filled; 
        this.Point  = Point; 
        
        this.setLocation((int)Point.local_X, (int)Point.local_Y);
        this.setSize((int)this.radius*2, (int)this.radius*2);
     
    }
    
    double getArea(){
        return PI*radius*radius; 
    }
    
    double getPrimeter(){
        return 2*PI*radius; 
    }
    // do hoa. 
    
    void resetlocation(double local_X, double local_Y){
        this.local_X = local_X; 
        this.local_Y = local_Y; 
        this.setLocation((int)local_X, (int)local_Y);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(this.c);
        if (filled){           
            g.fillOval(0, 0, 2 * (int)radius, 2 * (int)radius);       
        }
        else{           
            g.drawOval(0, 0, 2 * (int)radius, 2 * (int)radius);            
        }
    }
    
    @Override
    public String toString(){
        return "Circle"; 
    }
    public static void main(String args[]){
        JFrame MainGrap = new JFrame("test "); 
        LocalPoint P1 = new LocalPoint(0,0); 
        Circle mc = new Circle(P1, 100, Color.DARK_GRAY, true); 

        MainGrap.add(mc); 

        MainGrap.setSize(700, 500);
       
        MainGrap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainGrap.setVisible(true);
        
    }

    @Override
    public boolean Equal(Shape s) {
        Circle Cr = (Circle)s; 
        return (this.Point == Cr.Point) && (this.radius == Cr.radius); 
    }

    @Override
    public boolean EqualShape(Shape s) {
        return s instanceof Circle; 
    }
}
