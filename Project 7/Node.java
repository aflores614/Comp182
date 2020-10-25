/*Andres Flores
Comp 182 */
import java.util.*;
public class GroupData <E >{

   public void insert(int v);  
   
   public boolean delete(int v);
     
   public boolean find(int v); } 
   
class Node {  
   public int data;  
   
   public Node leftChild, rightChild;
   
   Node(int data){
      this.data=data;
      
   }
    
    
   
    // other methods if you want … 
} 
class MyTree implements IBST { 
   
   private Node root; 
   
   public MyTree() { 
     
      this.root = null;
      
   }  
   public MyTree(int x) {
      root = new Node(x);
      
   }       
   
   public void insert(int value) {
   
      Node newNode = new Node(value);
      if(root==null){
         root = newNode;
      }
      else{
         Node focusNode = root;
         Node parent;
         while (true){
            parent = focusNode;
            if( value < focusNode.data){
               focusNode = focusNode.leftChild;
               if(focusNode == null){
                  parent.leftChild= newNode;
                  return;
               }
            }
            else{
               focusNode = focusNode.rightChild;
               if (focusNode == null){
                  parent.rightChild= newNode;
                  return;
               }
            }
         }
      }  
               
   }
   
   public boolean delete(int key){
   
      Node focusNode = root;
      Node parent = root;
      boolean isitleftChild = true;
      while(focusNode.data !=key){
         parent = focusNode;
         if (key< focusNode.data){
            isitleftChild = true;
            focusNode = focusNode.leftChild;
         } 
         else {
            isitleftChild = false;
            focusNode = focusNode.rightChild;
         }
         if (focusNode == null)
            return false;
      }
      //has no children
    
      if( focusNode.leftChild == null && focusNode.rightChild == null ){
         if  ( focusNode == root){
            root = null;
         } 
         else if (isitleftChild) {
            parent.leftChild = null;
         }
         else {
            parent.rightChild = null;
         }
      }
        
      else if (focusNode.rightChild == null){
        
        
         if (focusNode == root)
            root= focusNode.leftChild;
         else if (isitleftChild)
            parent.leftChild=focusNode.leftChild;
         else  
            parent.rightChild = focusNode.leftChild;
              
      }        
      
      else if (focusNode.leftChild == null){
         if (focusNode == root)
            root= focusNode.rightChild;
         else if (isitleftChild)
            parent.leftChild=focusNode.rightChild;
         else  
            parent.rightChild = focusNode.leftChild;
              
      }  
            
      else {
         Node replacement = getReplacmentNode(focusNode);
         if(focusNode == root)
            root = replacement;
         else if ( isitleftChild )
            parent.leftChild = replacement;
         else 
            parent.rightChild = replacement;
         replacement.leftChild = focusNode.leftChild;            
      }
      return  true;
     
   }  
   
   public Node getReplacmentNode(Node replacedNode){
      Node replacementParent = replacedNode;
      Node replacement = replacedNode;
     
      Node focusNode =replacedNode.rightChild;
     
      while (focusNode != null){
      
         replacementParent = replacement;
         replacement = focusNode;
         focusNode = focusNode.leftChild;
         
      } 
      if (replacement != replacedNode.rightChild){
         replacementParent.leftChild = replacement.rightChild;
         replacement.rightChild = focusNode.rightChild;
      
      }
      return replacement;
   }    
   
   
   
   public boolean find(int value) {
   
      Node focusNode = root;
   
      while(focusNode.data != value){
         if (value < focusNode.data){
            focusNode=focusNode.leftChild;
         }
         else{
            focusNode =focusNode.rightChild;
         }
         if (focusNode == null)
            return false;
      }     
   
      return true;
   } 
   public int getHeight(Node node) {
   
      if (node == null){
         return 0;
      }
      else{ //check hight of each side 
         int leftHight = getHeight(node.leftChild);
         int rightHight = getHeight(node.rightChild);
          
         if(leftHight > rightHight){ //compare which one has the biggest value
            return (leftHight + 1);
         }
         else {
            return (rightHight + 1);
         }
      }
   }        
 
     
   //public boolean confirm() { }
    
   
   public String toString() {
   
      return "" + root.data;
   } 
    
   public void show() { 
     
      inOrder(root);
   
      System.out.println("");
   }

     
         
   private void inOrder(Node focusNode) {
     
      if(focusNode != null){
        
         inOrder(focusNode.leftChild);
         
         System.out.print("" + focusNode.data + " ");
        
         inOrder(focusNode.rightChild);
         
      }
     
   
   
   }  
   private void preOrder(Node focusNode) {
    
    
      if(focusNode != null){
        
         System.out.print("" + focusNode.data+ " ");
         preOrder(focusNode.leftChild);        
         preOrder(focusNode.rightChild);
                   
      }
   }  
   private void postOrder(Node focusNode) {
   
      if(focusNode != null){
        
         postOrder(focusNode.leftChild);
         postOrder(focusNode.rightChild);
         System.out.print(""+focusNode.data + " ");
        
      
      }
     
   } 
   public void generate(int n, int range) {
     
      Random rand = new Random();
      
      for (int i=0; i <n; i++){
         int a = rand.nextInt(range);
         insert(a);
        
      }
   }
   
   public void menu() {
    
      MyTree n = new MyTree();
     
      n.generate(20, 1000);
      n.insert(37);
      n.insert(43);
      n.delete(34);
      System.out.println("Is the number 37 in the tree: " + n.find(37));
      System.out.print("InOrder Tree: "); 
      n.inOrder(n.root);
      System.out.println("");
      System.out.print("PreOrder Tree: "); 
      n.preOrder(n.root);
      System.out.println("");      
      System.out.print("PostOrder Tree: "); 
      n.postOrder(n.root);
      System.out.println("");
      System.out.println("The height of the tree is " + getHeight(n.root));
   
   }
}