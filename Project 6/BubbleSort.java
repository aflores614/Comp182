class BubbleSort extends BasicSort {
  
   public BubbleSort() { super("BubbleSort"); }  
    
   public void sort() {
   
      int j;
      boolean flag = true;   
      int temp;   
   
      while ( flag )
      {
         flag= false;    
         for( j=0;  j < data.length -1;  j++ )
         {
            if ( data[ j ] > data[j+1] )   
            {
               checkedswap(j, j+1);   //swap elements
               flag = true;           //shows a swap occurred  
            } 
         } 
      } 
   
   }
}