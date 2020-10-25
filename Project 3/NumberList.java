//Andres Flores
//Comp 182
//Mo/Wed 7pm

import java.util.*;
class Node {

   private int number;
  
   private Node next;
   
   public Node(int n) {
   
      number=n;
      next=null;
   
   }
   public Node getNext() { 
    
      return next;
   }
   public int getNumber() {
   
      return number;
   }
   public void setNext(Node n) {
   
      next=n;
   
   }
   public String toString() {
   
      return number+" ";
    
   
   }
    
}

public class NumberList {

   private Node head;
   
   public NumberList() { 
   
      head = null;
      
   }
   public void insertAtHead(int x) { 
   
      Node curr = head;    
      Node Number =new Node(x);
      if (curr==null){   // Check if the head is empty 
         head=Number;    // if the head is empty then it insert it 
        
      }
      else {
         Number.setNext(head); //if the head is already taken set thr value to the next one
         head=Number; //set the new value into the head
        
      }
   
   }
   public void insertAtTail(int x) {
   
      Node curr=head; 
      Node prev=null;
      Node Number =new Node(x);
      if (curr==null){ //check if the head is empty
         head=Number; // if the head is empty that means the new number is going to first one in the list
        
      
      }
      else {
         
         while (curr.getNext()!=null){ //go down the list until it equals to null 
            curr=curr.getNext();
          
         }
        
         curr.setNext(Number);
               
      }
             
   }
   public void insertInOrder(int x) { 
   
      
      Node Number=new Node (x);
      Node curr = head;
      Node prev =null;
      
      while ((curr!=null)&& (x>curr.getNumber())){//check the list if the new number is bigger than the other until hit null
         prev=curr;
         curr=curr.getNext();
         
         
      }
      if (prev==null){ 
         head=Number;
      }
      else {    
            
         prev.setNext(Number);  
            
      }
          
      Number.setNext(curr);   
      
    
   }
   public String toString() {
      String List = "";
      Node curr = head;
      while(curr.getNext() != null){
         curr = curr.getNext();
         List += curr.getNumber() + ", ";
      }
      return List;
   }
    
//---------------------
// test methods
//---------------------
   public static void testInsertAtHead() {
      Random r = new Random();
      int n = 20;
      int range = 1000;
      NumberList list = new NumberList();
      System.out.println("Insert from Head");
      for (int i=1; i<=n; i++) {
         int x = r.nextInt(range);
         list.insertAtHead(x);
         
         System.out.println("" + x + ": " + list);
      }
   }
   public static void testInsertAtTail() {
      Random r = new Random();
      int n = 20;
      int range = 1000;
      NumberList list = new NumberList();
      System.out.println("Insert from Tail");
      for (int i=1; i<=n; i++) {
         int x = r.nextInt(range);
         list.insertAtTail(x);
         
         System.out.println("" + x + ": " + list);
      }
   }
   public static void testInsertInOrder() {
      Random r = new Random();
      int n = 20;
      int range = 1000;
      NumberList list = new NumberList();
      System.out.println("Insert by Order");
      for (int i=1; i<=n; i++) {
         int x = r.nextInt(range);
         list.insertInOrder(x);
         System.out.println("" + x + ": " + list);
      }
   }
   public static void main(String[] args) {
      testInsertAtHead();
      testInsertAtTail();
      testInsertInOrder();
   }
}
