package MainPackage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layer extends JPanel {

    ArrayList<Shape> listShape = new ArrayList<>();
    int numShape;
    public boolean visible = true;

    Layer(int numShape, boolean filler, boolean visible) {
        this.numShape = numShape;
        this.visible = visible;
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setSize(700, 500);
//        
        if (visible) {
            Random rand = new Random();
            for (int i = 0; i < numShape; i++) {
                int Rshape = rand.nextInt(6);
                int Rangle = rand.nextInt(2);
                int local_X = rand.nextInt(600), local_Y = rand.nextInt(400);
                int local_X1 = rand.nextInt(600), local_Y1 = rand.nextInt(400);
                int local_X2 = rand.nextInt(600), local_Y2 = rand.nextInt(400);
                LocalPoint P1 = new LocalPoint(local_X, local_Y), P2 = new LocalPoint(local_X1, local_Y1),
                        P3 = new LocalPoint(local_X2, local_Y2);

                int width = rand.nextInt(100);
                int r = rand.nextInt(255);
                int g = rand.nextInt(255);
                int b = rand.nextInt(255);
                Color randomColor = new Color(r, g, b);

                switch (Rshape) {
                    case 0:
                        // printf Circle.
                        listShape.add(new Circle(P1, width, randomColor, filler));
                        break;
                    case 1:
                        // printf Rectangle. 
                        listShape.add(new Rectangle(P1, P2, randomColor, filler));
                        break;
                    case 2:
                        // printf Square. 
                        listShape.add(new Square(P1, width, randomColor, filler, Rangle));
                        break;
                    case 3:
                        // printf TriAngle. 
                        listShape.add(new TriAngle(P1, P2, P3, randomColor, filler));
                        break;
                    case 4:
                        // printf Hexagon. 
                        listShape.add(new Hexagon(P3, width, randomColor, Rangle, filler));
                        break;
                    case 5:
                        //printf CircleMove. 
                        listShape.add(new CircleMove(local_X, local_Y, width, randomColor));
                        break;
                    default:
                        break;
                }
                this.add(listShape.get(i));
            }
        }

    }

    Layer(Color c) {
        this.setLayout(null);
        this.setBackground(c);
        this.setSize(200, 600);
    }

    void deleteTriangle() {
        TriAngle TriCheck = new TriAngle();
        for (Shape listShape1 : listShape) {
            if (TriCheck.EqualShape(listShape1)) {
                this.remove(listShape1);
            }
        }
    }
    
    void deleteShapeSame(){
        Circle      CrCheck  = new Circle(); 
        Hexagon     HexCheck = new Hexagon(); 
        Rectangle   RecCheck = new Rectangle(); 
        Square      SqCheck  = new Square(); 
        TriAngle    TriCheck = new TriAngle(); 
        
        ArrayList<Circle>    ListCr      = new ArrayList<>();
        ArrayList<Hexagon>   ListHex     = new ArrayList<>();
        ArrayList<Rectangle> ListRec     = new ArrayList<>();
        ArrayList<Square>    ListSq      = new ArrayList<>();
        ArrayList<TriAngle>  ListTri     = new ArrayList<>();
        
        for (Shape listShape1 : listShape) {
            if (CrCheck.EqualShape(listShape1)) {
                ListCr.add((Circle) listShape1); 
            }
            else if (HexCheck.EqualShape(listShape1)){
                ListHex.add((Hexagon) listShape1); 
            }
            else if (RecCheck.EqualShape(listShape1)){
                ListRec.add((Rectangle) listShape1);
            }
            else if (SqCheck.EqualShape(listShape1)){
                ListSq.add((Square) listShape1); 
            }
            else if (TriCheck.EqualShape(listShape1)){
                ListTri.add((TriAngle) listShape1); 
            }
        }
        // xoa CircleSame. 
        deleteCircleSame(ListCr); 
        deleteHexagonSame(ListHex);
        deleteRectangleSame(ListRec); 
        deleteSquareSame(ListSq); 
        deleteTriSame(ListTri);
    }
        
    void deleteCircleSame(ArrayList<Circle> ListCr){
        for (int i = 0; i < ListCr.size(); i++){
            for (int j = i + 1; j < ListCr.size(); j++){
                if (ListCr.get(i).Equal(ListCr.get(j))){
                    this.remove(ListCr.get(j));
                }
            }
        }
    }
//    
    void deleteHexagonSame(ArrayList<Hexagon> ListHex){
        for (int i = 0; i < ListHex.size(); i++){
            for (int j = i + 1; j < ListHex.size(); j++){
                if (ListHex.get(i).Equal(ListHex.get(j))){
                    this.remove(ListHex.get(j));
                }
            }
        }
    }
//    
    void deleteRectangleSame(ArrayList<Rectangle> ListRec){
//        System.out.println(ListRec.size());
        boolean check = false; 
        for (int i = 0; i < ListRec.size(); i++){
            for (int j = i + 1; j < ListRec.size(); j++){
                try{
                    check =  ListRec.get(i).Equal(ListRec.get(j)); 
                }catch(Exception e){
                    System.out.println("error not check Rectangle");
                }
                if (check){
                        this.remove(ListRec.get(j));
                }
            }
        }
    }
    
    void deleteSquareSame(ArrayList<Square> ListSq){
        boolean check = false; 
        for (int i = 0; i < ListSq.size(); i++){
            for (int j = i + 1; j < ListSq.size(); j++){
                try{
                    check = ListSq.get(i).Equal(ListSq.get(j)); 
                }catch(Exception e){
                    System.out.println("error not check Square");
                }
                if (check){
                    this.remove(ListSq.get(j));
                }
            }
        }
    }
    
    void deleteTriSame(ArrayList<TriAngle>  ListTri){
        boolean check = false; 
        for (int i = 0; i < ListTri.size(); i++){
            for (int j = i + 1; j < ListTri.size(); j++){
                try{
                    check = ListTri.get(i).Equal(ListTri.get(j)); 
                }catch(Exception e){
                    System.out.println("error not check Triangle");
                }
                if (check){
                    this.remove(ListTri.get(j));
                }
            }
        }
    }
    public static void main(String[] args) {
        JFrame MainGrap = new JFrame("test ");
        Layer Lay = new Layer(10, true, true);
        Lay.deleteShapeSame();
        MainGrap.add(Lay);
        MainGrap.setSize(700, 600);
        MainGrap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainGrap.setVisible(true);
    }
}
