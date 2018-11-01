package MainPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class CircleMove extends Shape implements ActionListener
{
    
    public int x;
    public int y;
    public int radius;
    public int velX = 2, velY = 2; 
    public Color color;
    Timer t = new Timer (10, this);
    
    @Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.fillOval(0, 0, 2 * radius, 2 * radius);
        t.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (x < 0 || x > 700 - radius){
            velX = - velX; 
        }
        if (y < 0 || y > 500 - radius){
            velY = - velY;
        }
        x += velX; 
        y += velY; 
        resetLocal(x, y); 
        repaint(); 
    }
    
    void resetLocal(int local_X, int local_Y){
        this.setLocation(local_X, local_Y);  
    }
    public CircleMove(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radius = radius;
        this.setLocation(x, y);
        this.setSize(2 * radius + 5, 2 * radius + 5);
    }

    @Override
    public boolean Equal(Shape s) {
        CircleMove Cr = (CircleMove)s; 
        return (this.x == Cr.x && this.y == Cr.y && this.radius == Cr.radius); 
    } 
    
    public static void main(String args[]){
        JFrame MainGrap = new JFrame("test "); 
        LocalPoint P1 = new LocalPoint(0,0); 
        CircleMove mc = new CircleMove(0,0, 100, Color.DARK_GRAY); 

        MainGrap.add(mc); 

        MainGrap.setSize(700, 700);
       
        MainGrap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainGrap.setVisible(true);
        
    }

    @Override
    public boolean EqualShape(Shape s) {
        return s instanceof CircleMove; 
    }
}

