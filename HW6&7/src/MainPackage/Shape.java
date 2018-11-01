package MainPackage;

import java.awt.Color;
import java.awt.Component;


public abstract class Shape extends Component{
    Color    c = Color.RED; 
    boolean  filled = true; 
    double   local_X; 
    double   local_Y;  
    public   LocalPoint Point; 
    double   angle = 1; 
    
    public Color getC() {
        return c;
    }

    public boolean isFilled() {
        return filled;
    }
    
    Shape(){}; 
    
    Shape(boolean filled, Color c){
        this.c = c; 
        this.filled = filled; 
    }
    
    @Override
    public String toString(){
        return "Shape"; 
    }
    
    public abstract boolean  EqualShape(Shape s); 
    public abstract boolean  Equal(Shape s);
}
