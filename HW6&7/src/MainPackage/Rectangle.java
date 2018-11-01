package MainPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;


public class Rectangle extends Shape{
    LocalPoint PointXY; 
    LocalPoint PointO = new LocalPoint(0,0); 
    double width = 1; 
    double length = 1;
 
    public double getW() {
        return width;
    }

    public double getLength() {
        return length;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    // đồ họa. 
    //test lại
    
    public double radius = 1;
    public final double PI = 3.14; 
    
    
    public double getRadius() {
        return radius;
    }
    
    Rectangle(){}; 
    Rectangle(LocalPoint Point, LocalPoint Point1, Color c, boolean filled){
        this.Point   = Point; 
        this.PointXY = Point1;
        this.width   = PointO.checkMaxLocalX(Point, Point1) - Point.CompareMinX(Point1); 
        this.length  = PointO.checkMaxLocalY(Point, Point1) - Point.CompareMinY(Point1); 
        this.c       = c; 
        this.filled  = filled; 
        this.setLocation((int)Point.CompareMinX(Point1), (int)Point.CompareMinY(Point1));
        this.setSize((int)this.width, (int)this.length); 
    }
    
    double getArea(){
        return width*length; 
    }
    
    double getPerimeter(){
        return (width + length)*2; 
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
            if (angle == 1){
                g.fillRect(0, 0, (int)width, (int)length);
            }else{
                Polygon P = new Polygon();
                P.addPoint((int)(width/2), 0);
                P.addPoint((int)width, (int)(width/2));
                P.addPoint((int)(width/2), (int)width);
                P.addPoint(0, (int)(width/2));
                g.fillPolygon(P);
            }       
        }
        else{
            if (angle == 1){
                g.drawRect(0, 0, (int)width, (int)length);
            }else{
                Polygon P = new Polygon();
                P.addPoint((int)(width/2), 0);
                P.addPoint((int)width, (int)(width/2));
                P.addPoint((int)(width/2), (int)width);
                P.addPoint(0, (int)(width/2));
                g.drawPolygon(P);
            }
        }
    }
    
    @Override
    public String toString(){
        return "Rectangle"; 
    }

    @Override
    public boolean Equal(Shape e) {
            Rectangle Rec = (Rectangle)e;
            return (this.Point.equal(Rec.Point) && this.PointXY.equal(Rec.PointXY)) ||
                (this.Point.equal(Rec.PointXY) && this.PointXY.equal(Rec.Point));

    }
    
    public static void main(String args[]){
        JFrame MainGrap = new JFrame("test "); 
        LocalPoint P1 = new LocalPoint(0, 0), P2 = new LocalPoint(200, 100);      
        Rectangle Rec  = new Rectangle(P1, P2, Color.BLACK, true);
        Rectangle Rec2  = new Rectangle(P2, P1, Color.BLACK, true);  
        System.out.println(Rec.Equal(Rec2));       
        MainGrap.add(Rec2); 
        MainGrap.setSize(700, 500);    
        MainGrap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        MainGrap.setVisible(true);
        
    }

    @Override
    public boolean EqualShape(Shape s) {
        return s instanceof Rectangle; 
    }
}
