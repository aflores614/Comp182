class Insertion extends BasicSort {  
public Insertion() { super("Insertion"); }  
public void sort() { 
  int temp;
	    for (int i = 1; i < data.length; i++) {
		    for(int j = i ; j > 0 ; j--){
			    if(data[j] < data[j-1]){
				    
                checkedswap(j, j-1);
                
              /*  temp = data[j];
				    data[j] = data[j-1];
				    data[j-1] = temp;  */
			    }
		    }
	      
      
      // details of  Insertion Sort algorithm go here.   
      // it overrides and implements inherited abstract method   
      // assume int[] data already contains values to sort  
      } 
   }
}