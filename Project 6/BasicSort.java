/* Andres Flores
  comp 182
  Mon/wed
*/


import java.util.*;
public abstract class BasicSort {
//-----------------
// members
//-----------------
   protected int[] data;
   protected String name;
//-------------------
// constructors
//-------------------
   protected BasicSort() { name = "BasicSort"; data =null; }
   protected BasicSort(String n) { this(); name = n; }
//------------------
// abstract methods
//
// this method must be left unimplemented
// it will be implemented in the subclasses
//------------------
   public abstract void sort();
//------------------
// methods
//------------------
   protected boolean isValid(int index) {  
      if(index >=0 ||index < data.length){
         return true; }
               
      return false;
   }
   protected void checkedswap(int a, int b) {
      if (isValid(a)==true||isValid(b)==true){
         int temp = data[a];
         data[a]=data[b];
         data[b]=temp; 
      }
      
   } 
   protected void uncheckedswap(int a, int b) {
      
      int temp = data[a];
      data[a]=data[b];
      data[b]=temp; 
      
   }
   protected boolean isSorted(boolean ascending) { 
      int count=0;
      if (ascending==true){
         for(int i=0; i<data.length-1; i++){
            if(data[i]<data[i+1]){
               count++;
            } 
         }
         if (count==data.length-2){
         
          }
            return true; }
         
      
      if (ascending==false){
         for(int i=0; i<data.length-1; i++){
            if(data[i]>data[i+1]){
               count++;
            } 
            if (count==data.length-1){
               return true; }
         
         }
      }
     
      return false;
   }
   public void generate(int n, int range) {
      data=new int [n];
      Random rand = new Random();
      for(int i=0; i<n-1; i++){
         int a = rand.nextInt(range);
         data[i]=a;
      }
   
   }
   public String toString() { 
   
      return toString(0,data.length-1);
      
   }
      
   public String toString(int start, int stop) { 
   
      return toString(data); 
      
   }
      
   public static String toString(int[] data) {
      if (data==null || data.length==0) 
         return "empty";
      else {
         String s = "";
         for (int i=0; i<data.length; i++) {
            s += String.format("%4d",data[i]);
         }
         return s;
      }
   }
   public long timedsort() { 
     
      long StartTime = System.currentTimeMillis(); 
       sort();
      long endTime = System.currentTimeMillis();
      long time= endTime-StartTime;
   
   
      return time; }
//---------------------------------------------------
// TESTING
//
// public static methods for testing
//---------------------------------------------------
// Note: generic method, different from generic class
   public static <T extends BasicSort> void basicSortTest(T s,
   int n, int range) {
      System.out.println("Basic Sort Test: Sort = " + s.name);
      s.generate(n, range);
      System.out.println(s);
      s.sort();
      System.out.println(s);
      System.out.println(s.isSorted(true));
      System.out.println();
   }
   public static void doBasicSortTest(BasicSort[] sorters, int n,
   int range) {
      for (int i=0; i<sorters.length; i++) {
         basicSortTest(sorters[i],n,range);
      }
   }
   public static <T extends BasicSort> void timedSortTest(T s,
   int[] values) {
      System.out.println("Timed Sort Test: Sort = " + s.name);
      for (int i=0; i<values.length; i++) {
         s.generate(values[i], values[i]*10);
         long t = s.timedsort();
         System.out.println(String.format(
            "%8d %10d %b",values[i],t,s.isSorted(true)));
      }
   }
   public static void doTimedSortTest(BasicSort[] sorters, int[] values) {
      for (int i=0; i<sorters.length; i++) {
         timedSortTest(sorters[i],values);
      }
   }
}