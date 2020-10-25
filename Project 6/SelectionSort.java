class SelectionSort extends BasicSort {  
   public SelectionSort() { super("SelectionSort"); }  
   public void sort() {  
   
      for (int i = 0; i < data.length - 1; i++)  
      {  
         int index = i;  
         for (int j = i + 1; j < data.length; j++){  
            if (data[j] < data[index]){  
               index = j;//searching for lowest index  
            }  
         } 
         checkedswap(index, i); 
         /* int smallerNumber = data[index];   
         data[index] = data[i];  
         data[i] = smallerNumber;  */
      }  
   }
    // details of Selection Sort algorithm go here.   
   // it overrides and implements inherited abstract method   
   // assume int[] data already contains values to sort  
} 
