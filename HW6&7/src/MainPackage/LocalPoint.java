package MainPackage;


public class LocalPoint {
    double local_X; 
    double local_Y; 
    
    LocalPoint (double X, double Y){
        this.local_X = X; 
        this.local_Y = Y; 
    }
    
    public void setLocal_X(int local_X) {
        this.local_X = local_X;
    }

    public void setLocal_Y(int local_Y) {
        this.local_Y = local_Y;
    }
    
    public double getLocal_X() {
        return local_X;
    }

    public double getLocal_Y() {
        return local_Y;
    }
    
    public double checkMaxLocalX(LocalPoint P1, LocalPoint P2){
        double maxX = this.local_X; 
        if (P1.local_X > maxX) maxX = P1.local_X; 
        if (P2.local_X > maxX) maxX = P2.local_X; 
        return maxX; 
    }
    
    public double checkMinLocalX(LocalPoint P1, LocalPoint P2){
        double minX = this.local_X; 
        if (P1.local_X < minX) minX = P1.local_X; 
        if (P2.local_X < minX) minX = P2.local_X; 
        return minX; 
    }
    
    public double checkMaxLocalY(LocalPoint P1, LocalPoint P2){
        double maxY = this.local_Y; 
        if (P1.local_Y > maxY) maxY = P1.local_Y; 
        if (P2.local_Y > maxY) maxY = P2.local_Y; 
        return maxY; 
    }
    
    public double checkMinLocalY(LocalPoint P1, LocalPoint P2){
        double minY = this.local_Y; 
        if (P1.local_Y < minY) minY = P1.local_Y; 
        if (P2.local_Y < minY) minY = P2.local_Y; 
        return minY; 
    }
   
    public double CompareMinX(LocalPoint P){
        if (this.local_X < P.local_X) return this.local_X; 
        else return P.local_Y; 
    }
    
    public double CompareMinY(LocalPoint P){
        if (this.local_Y < P.local_Y) return this.local_Y; 
        else return P.local_Y; 
    }
    
    public boolean equal(LocalPoint P){
        return this.local_X == P.local_X && this.local_Y == P.local_Y; 
    }
    
    public static void main(String[] args){
        LocalPoint L  = new LocalPoint(1, 1); 
        LocalPoint L2 = new LocalPoint(1, 2); 
    }
}
