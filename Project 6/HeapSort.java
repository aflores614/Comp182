class HeapSort extends BasicSort {  
   public HeapSort() { super("HeapSort"); }  
   public void sort() {  
   
      int n = data.length;
   
         
      for (int i = n / 2 - 1; i >= 0; i--)  // Build heap
         heapify(data, n, i);
   
      for (int i=n-1; i>=0; i--)
      {
                               
         checkedswap(0,i);  // Move current root to end
      
         heapify(data, i, 0);
      }
   }
 
   void heapify(int arr[], int n, int i)
   {
      int largest = i;  // Initialize largest as root
      int l = 2*i + 1;  
      int r = 2*i + 2;  
   
      if (l < n && arr[l] > arr[largest]) // Move current root to end
         largest = l;
   
      if (r < n && arr[r] > arr[largest])// Move current root to end
         largest = r;
   
      if (largest != i) // Move current root to end
      {
         checkedswap(i,largest); 
         heapify(arr, n, largest);
      }
   }
    
   


 
// details of Heap Sort algorithm go here.   
// it overrides and implements inherited abstract method   
// assume int[] data already contains values to sort  
} 
