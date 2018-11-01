package MainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class Diagram extends JFrame {

    Layer LayerMain;
    Layer Lay0, Lay1, Lay2, Lay3;
    ArrayList<Circle>    ListCr      = new ArrayList<>();
    ArrayList<Hexagon>   ListHex     = new ArrayList<>();
    ArrayList<Rectangle> ListRec     = new ArrayList<>();
    ArrayList<Square>    ListSq      = new ArrayList<>();
    ArrayList<TriAngle>  ListTri     = new ArrayList<>();
    
    void CreatListLayer(int numCr, int numHex, int numRec, int numSq, int numTri){
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        Color randomColor = new Color(r, g, b);
        // creat Layer. 
    
        Lay0 = new Layer(Color.MAGENTA); 
        for (int i = 0; i < numCr; i++){
            int local_X = rand.nextInt(600), local_Y = rand.nextInt(400);
            int radius  = rand.nextInt(40); 
            LocalPoint P1 = new LocalPoint(local_X, local_Y);
            ListCr.add(new Circle(P1, radius, randomColor, true));
            Lay0.add(ListCr.get(i)); 
        }
        Lay1 = new Layer(Color.BLUE); 
        for (int i = 0; i < numHex; i++){
            int local_X = rand.nextInt(600), local_Y = rand.nextInt(400);
            int size  = rand.nextInt(80); 
            LocalPoint P1 = new LocalPoint(local_X, local_Y);
            ListHex.add(new Hexagon(P1, size, randomColor, i%2, true));
            Lay1.add(ListHex.get(i)); 
        }
        Lay2 = new Layer(Color.PINK); 
        for (int i = 0; i < numRec; i++){
            int local_X = rand.nextInt(600), local_Y = rand.nextInt(400);
            int local_X1 = rand.nextInt(600), local_Y1 = rand.nextInt(400);
            LocalPoint P1 = new LocalPoint(local_X, local_Y), P2 = new LocalPoint(local_X1, local_Y1); 
            ListRec.add(new Rectangle(P1, P2, randomColor, true));
            Lay2.add(ListRec.get(i)); 
        }
        Lay3 = new Layer(Color.WHITE); 
        for (int i = 0; i < numSq; i++){
            int local_X = rand.nextInt(600), local_Y = rand.nextInt(400);
            LocalPoint P1 = new LocalPoint(local_X, local_Y);
            int size  = rand.nextInt(80); 
            ListSq.add(new Square(P1, size, randomColor, true, i%2)); 
            Lay3.add(ListSq.get(i)); 
        }      
    }
    
    Diagram() {
        LayerMain = new Layer(10, true, true);
//        DeleteCircle();
        CreatListLayer(10, 10, 10, 10, 10); 
        this.setTitle("Diagram");
        //BorderLayout.NORTH
//        this.add(Lay0);
//        this.add(Lay1); 
//        this.add(Lay2); 
//        this.add(Lay3); 
//        this.add(LayerMain); 
        this.setSize(800, 700);
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
   
    }

    public void DeleteCircle() {
        Circle CrCheck = new Circle();
        for (Shape listShape1 : LayerMain.listShape) {
            if (CrCheck.EqualShape(listShape1)) {
                LayerMain.remove(listShape1);
            }
        }
    }
    public static void main(String[] args) {
        new Diagram();
    }
}
