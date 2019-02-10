import java.util.*;
import java.io.*;

class Point implements Comparable {
    private double x;
    private double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.x) + " " + String.valueOf(this.y);
    }
    
    @Override
    public int compareTo(Object o) {
        if (o instanceof Point) {
            Point point = (Point)o;
            if (this.x - point.x > 0) {
                return 1;
            } else if (this.x - point.x == 0) {
                return 0;
            } else {
                return -1;
            }
        } else {
            throw new ClassCastException();
        }
    }
    
}

