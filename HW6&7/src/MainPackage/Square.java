package MainPackage;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class Square extends Rectangle{
    double side; 

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    
    Square(){}; 
    
    Square(LocalPoint Point, double side, Color c, boolean filled, double angle){
        this.Point   = Point;
        this.angle   = angle; 
        this.c       = c; 
        this.filled  = filled; 
        if (angle == 1){
            this.setLocation((int)Point.local_X, (int)Point.local_Y);
            this.setSize((int)side, (int)side);
            this.width   = side; 
            this.length  = side; 
        }else{
            this.width   = side*Math.sqrt(2); 
            this.length  = side*Math.sqrt(2); 
            this.setLocation((int)Point.local_X, (int)Point.local_Y);
            this.setSize((int)(side*Math.sqrt(2)), (int)(side*Math.sqrt(2)));
        }
    }
    
    @Override
    public boolean Equal(Shape e) {     
            Square Sq = (Square)e;
            return this.Point.equal(Sq.Point) && this.side == Sq.side && this.angle == Sq.angle; 

    }
    
    @Override
    public String toString(){
        return "Square"; 
    }
    
    @Override
    public boolean  EqualShape(Shape s){
        return s instanceof Square; 
    }
    
    public static void main(String args[]){
        JFrame MainGrap = new JFrame("test "); 
        LocalPoint P1 = new LocalPoint(0, 0); 
        Square mc = new Square(P1, 100, Color.BLACK, true, 2); 
        Square mc2 = new Square(P1, 100, Color.BLACK, true, 1);   
        
        MainGrap.add(mc2); 

        MainGrap.setSize(700, 500);
       
        MainGrap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainGrap.setVisible(true);
        
    }
}
