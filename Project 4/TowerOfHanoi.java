/*Andres Flores
 Comp 182*/
import java.util.Scanner;
public class TowerOfHanoi {

   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of disks:");
      int numDisks = input.nextInt();
      long s=timedsort(numDisks);//will call the method timesort to compute the sequence of moves to move n disks
      System.out.println("The moves are:");
      moveDisks(numDisks, 'A','C','B');
      System.out.println("It takes " +s+ " moves to complete " + numDisks + " disks");
   
   
   }
   public static long  timedsort ( int x){ 
     if (x==1){
       return x;
            }
      else {
        long move=2*timedsort(x-1)+1; 
        return move;
        }     
   }
   public static void moveDisks(int n, char fromTower, char toTower, char auxTower){ 
      
      if (n==1){
       
         System.out.println("Move disk 1 from " + fromTower + " to " + toTower); 
      }
      
      else {
        
         moveDisks(n-1, fromTower, auxTower, toTower);
         
         System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower); 
      
         moveDisks(n-1, auxTower, toTower, fromTower); 
      }
   }
}