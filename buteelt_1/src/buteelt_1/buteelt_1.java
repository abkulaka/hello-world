package buteelt_1;
import java.util.Scanner;
public class buteelt_1 {
 private static final double PI = 3.14;
 private final double radius;
 public buteelt_1(double radius) {
 this.radius = radius;
 }
 public static void main(String[] args) {
 System.out.println("------------------------------------------------------------");
 System.out.println("CircleCalc v1.0");
 System.out.println();
 System.out.println("Calculates and prints information for a user-supplied radius");
 System.out.println("------------------------------------------------------------");
 System.out.print("Enter the circle's radius: ");
 Scanner in = new Scanner(System.in);
 buteelt_1 c = new buteelt_1(in.nextFloat()) ;
  //3:00
 }
}
