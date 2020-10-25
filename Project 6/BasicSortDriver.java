public class BasicSortDriver{
   public static void main(String[] args){
   
     
      BasicSort[] sorters = {new BubbleSort(), new SelectionSort(), new Insertion(), new QuickSort(), new Mergesort(), new HeapSort()}; 
   
      BasicSort.doBasicSortTest(sorters, 20, 1000);
      
      int[] values = {10000, 20000,30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000}; 
         
      
     
      BasicSort.doTimedSortTest(sorters , values);
     
   
    /*BasicSort.basicSortTest(new BubbleSort(), 20, 1000);
      BasicSort.basicSortTest(new SelectionSort(), 20, 1000);
      BasicSort.basicSortTest(new Insertion(), 20, 1000);
      BasicSort.basicSortTest(new QuickSort(), 20, 1000);
      BasicSort.basicSortTest(new Mergesort(), 20, 1000);
      BasicSort.basicSortTest(new HeapSort(), 20, 1000); */
   
   } 
}

