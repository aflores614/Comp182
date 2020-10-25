public class SplayNode{

   String word;
   String file;
   SplayNode LeftChild;
   SplayNode RightChild;
  
  		
	public SplayNode(){

		word=" ";
		file=" ";

	} 
	public SplayNode(String word, String file){
		this.word=word;
		this.file=file;
	}
	public String toString(){
		return word + ", "+ file;
	}
}