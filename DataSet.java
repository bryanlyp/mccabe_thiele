import java.util.*;
import java.io.*;

class DataSet {
    private ArrayList<Point> pointList = new ArrayList<Point>();;
    
    public DataSet() {
        
    }
    
    public void addPoint(Point point) {
        this.pointList.add(point);
    }
    
    public double lagrangeInterp(double x) {
        double result = 0;
        for (int i = 0; i < pointList.size(); i++) {
            double L = 1;
            for (int j = 0; j < pointList.size(); j++) {
                if (j == i) continue;
                L = L*(x - pointList.get(j).getX())/(pointList.get(i).getX() - pointList.get(j).getX());
            }
            result += L*pointList.get(i).getY();
        }
        return result;
    }
    
}