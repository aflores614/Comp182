class Mergesort extends BasicSort { 
   public Mergesort() { super("Mergesort"); }  
   public void sort() {
   
   int first=0;
   int last=data.length-1;
   
   mergesort(first, last);
   }
   
   private void mergesort(int min, int max){
     
      if (min < max){
        
        int mid = min+(max-min)/2;
        
          mergesort(min,mid);
          
          mergesort(mid+1,max); 
          
          merge(min, mid, max);
          
       }
     }
     
     private void merge (int min, int mid, int max){
     
     int [] temp = new int [data.length];
      
          for (int i=min; i<=max; i++){
            temp[i]=data[i];
           }
           int i=min;
           int j=mid + 1;
           int k=min;
           
         while(i<=mid && j<=max){   
            if (temp[i]<= temp[j]){
             data[k]=temp[i];
             i++;
            } else {
                    data[k]=temp[j];
                    j++;
            }
            k++;
          }
          while (i<=mid){
             data[k]=temp[i];
             k++;
             i++;          
           
           }
              
        }
       
     
   // details of Mergesort  algorithm go here.   
   // it overrides and implements inherited abstract method   
   // assume int[] data already contains values to sort  
   }
