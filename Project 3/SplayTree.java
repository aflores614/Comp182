import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class SplayTree{

   SplayNode root = null;
   
   public void insert(String w, String f){
   	
   	
   
      if (root==null){
      
         root = new SplayNode(w,f);
         return;
      }
   
      root=Splay(root, w);
      int c = w.compareTo(root.word);
   		
      if(c<0){
         SplayNode n = new SplayNode (w,f);
         n.LeftChild=root.LeftChild;
         n.RightChild=root;
         root.LeftChild=null;
         root=n;
      
      }
      
      else if (c>0){
         SplayNode n = new SplayNode (w,f);
         n.RightChild=root.RightChild;
         n.LeftChild=root;
         root.RightChild=null;
         root=n;
      
      }
      
      else{
      
         root.word=w;
      }
   }

   public boolean FindWord(SplayNode n, String w){
   
      boolean found = false;
   
      if (root==null){
         return found;
      }else{
      
         while((n!=null && !found)){
         
            String rval=root.word;
         
            if (w.compareTo(rval)==0){
               found=true;
               return found;
            }
         
            if(w.compareTo(rval)<=0){
               n=n.LeftChild;
            
            }
            else if (w.compareTo(rval)>=0){
               n=n.RightChild;
            }
            else {
               found=true;
               break;
            
            }
            found=FindWord(n,w);
         
         } 
      }
   
       
   
      return found;
   }
   
   public void remove (String w){
     
      if (root==null){
         return;
      }
      root=Splay(root, w);
     
      int cmp=w.compareTo(root.word);
     
      if(cmp==0){
         if (root.LeftChild==null){
            root=root.RightChild;
         }
         else{
            SplayNode x = root.RightChild;
            root = root.LeftChild;
            Splay(root, w);
            root.RightChild=x;
         }
      }
   }      
       

   public SplayNode Splay(SplayNode r, String w){
   
      if (r==null){
      
         return null;
      }
   
      int comp = w.compareTo(r.word);
   
      if(comp<0){
      
         if(r.LeftChild==null){
         
            return r;
         }
      
         int comp2 = w.compareTo(r.LeftChild.word);
      
         if (comp2 < 0){
         
            r.LeftChild.LeftChild=Splay(r.LeftChild.LeftChild, w);
            r=rotateRight(r);
         }	
         
         else if (comp2>0){
         
            r.LeftChild.RightChild=Splay(r.LeftChild.RightChild, w);
         
            if(r.LeftChild.RightChild != null){
               r.LeftChild=rotateLeft(r.LeftChild);
            }
         }
      
         if (r.LeftChild==null){
         
            return r;
         }
         
         else{
         
            return rotateRight(r);
         }
      
      }
      
      else if (comp > 0){
         if (r.RightChild == null){
            return r;
         }
      
         int comp2 = w.compareTo(r.RightChild.word);
      
         if(comp2<0){
            r.RightChild.LeftChild = Splay(r.RightChild.LeftChild, w);
            if (r.RightChild.LeftChild != null){
               r.RightChild=rotateRight(r.RightChild);
            }
         }
         
         else if (comp2>0){
            r.RightChild.RightChild=Splay(r.RightChild.RightChild, w);
            r=rotateLeft(r);
         }
         if(r.RightChild==null){
            return r;
         }
         else{
            return rotateLeft(r);
         }
      }
   
      return r;
   }

   public SplayNode rotateRight(SplayNode x){
   
      SplayNode r = x.LeftChild;
      x.LeftChild=r.RightChild;
      r.RightChild=x;
      return r;
   }
   public SplayNode rotateLeft(SplayNode x){
   
      SplayNode r = x.RightChild;
      x.RightChild=r.LeftChild;
      r.LeftChild=x;
      return r;
   
   }
}