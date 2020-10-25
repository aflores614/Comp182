class QuickSort extends BasicSort {  
   public QuickSort() { super("QuickSort"); }  
   public void sort() { 
   
      int max= data.length-1;
   
      quicksort(0, max); }
   
   private void quicksort(int first, int last){
   
      int i=first;
      int j=last;
   
      int pivot=data[first+(last-first)/2];
   
      while(i<=j){
      
         while(data[i]<pivot){
            i++;
         }
         while (data[j]>pivot){
            j--;
         }
         if(i<=j){
            checkedswap(i, j);                
            i++;
            j--;
         }
      }   
    
   
      if (first<j)
         quicksort(first, j);
      if(i < last)
         quicksort(i,last);
   
   }
   
}
    


// details of Quick Sort algorithm go here.   
// it overrides and implements inherited abstract method   
// assume int[] data already contains values to sort 

