import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataSet dataSet = new DataSet();
        // Receive input for equilibrium data:
        initializeEquilibriumCurve(dataSet);
        
        System.out.print("Feed flow rate (mol/h): ");
        double F = sc.nextDouble();
        
        System.out.print("Feed light key composition (%): ");
        double xF = sc.nextDouble();
        
        System.out.print("Bottoms light key composition (%): ");
        double xB = sc.nextDouble();
        
        System.out.print("Distillate light key composition (%): ");
        double xD = sc.nextDouble();
        
        double B = F*(xF-xD)/(xB-xD);
        double D = F - B;
        
        // Receive input for type of problem to solve:
        System.out.println("Enter number code for type of problem to be solved.");
        System.out.println("1. Minimum number of stages");
        System.out.println("2. Minimum reflux ratio");
        // TODO: Normal calculations for given R
        int type = sc.nextInt();
        if (type == 1) {
            findMinStages(dataSet, xB, xD);
        } else if (type == 2) {
            
        } else {
            System.out.println("Number code error, terminating program.");
        }
        
    }
    
    static void initializeEquilibriumCurve(DataSet ds) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of data points: ");
        int n = sc.nextInt();
        System.out.println("Enter x and y values:");
        while (n-- > 0) {
            ds.addPoint(new Point(sc.nextDouble(), sc.nextDouble()));
        }
    }
    
    static int findMinStages(DataSet ds, double xB, double xD) {
        int n = 0;
        double x = xB;
        double y = x;
        while (x < xD) {
            y = ds.lagrangeInterp(x);
            System.out.printf("Point on equilibrium curve: %.3f %.3f\n", x, y);
            n++;
            System.out.printf("Stage number: %d\n", n);
            x = y;
            System.out.printf("Point on y = x curve: %.3f %.3f\n", x, y);
        }
        System.out.println("Minimum number of stages: " + n);
        return n;
    }
    
}









