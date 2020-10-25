/*Andres Flores
Comp 282
Project 3
*/
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;

public class Splay {
   public static void main(String[] args) throws IOException{
   
      SplayTree st1 = new SplayTree();
      String words=null;
   
      
      try{
      
         FileReader fr1 = new FileReader("file1.txt");         
         BufferedReader textReader1 = new BufferedReader(fr1);
         
         FileReader fr2 = new FileReader("file2.txt");         
         BufferedReader textReader2 = new BufferedReader(fr2);
         
         FileReader fr3 = new FileReader("file3.txt");         
         BufferedReader textReader3 = new BufferedReader(fr3);
         
         FileReader fr4 = new FileReader("file4.txt");         
         BufferedReader textReader4 = new BufferedReader(fr4);
      
      
       
         while((words=textReader1.readLine()) != null){
            words = textReader1.readLine();
            st1.insert(words, "file1.txt");
            System.out.println(words);
         }
         System.out.println("");
         
         while((words=textReader2.readLine()) != null){
            words = textReader2.readLine();
            st1.insert(words, "file2.txt");
            System.out.println(words);
         }
         
         System.out.println("");
         
         while((words=textReader3.readLine()) != null){
            words = textReader3.readLine();
            st1.insert(words, "file3.txt");
            System.out.println(words);
         }
         
         System.out.println("");
          
         while((words=textReader4.readLine()) != null){
            words = textReader4.readLine();
            st1.insert(words, "file4.txt");
            System.out.println(words);
         }
      
      }
      catch (IOException e){
         System.out.println("Can't find file");
      }
   }
}