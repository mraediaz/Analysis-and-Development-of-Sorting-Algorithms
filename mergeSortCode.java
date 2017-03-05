import java.util.Arrays;
import java.util.Random;


/**
 *  COMP 215: Design and Analysis of Algorithms: Programming Assignment<br>
 *
 *  The <code>MergeSort</code> class provides an algorithm that will sort a given
 *  array into increasing order using the MergeSort algorithm.
 *   
 *  This is made for a program that validates the run-time 
 *  complexity and asymptotic run-time complexity for different kinds of sort methods.
 *
 *  This code will be used to compare the worst case, best case, and average case run times
 *  for Merge Sort
 *  <br> <br>
 *  Created: <br>
 *     [02,01,2016], [Melany Diaz] [assistance from http://algs4.cs.princeton.edu/22mergesort/Merge.java.html]<br>
 *  Modifications: <br>
 *  
 *  @author [Melany Diaz] 
 */

public class MergeSort 
{
    // instance variables
    Comparable[] startArray;
    
    //Variables used to determine how long each method takes to execute
    private long startTime;
    private long endTime;
    private long duration;
    
    boolean debug = true;
    
  //the average, best, and worst case arrays
    static Comparable[] average;
    static Comparable[] increasing;
    static Comparable[] decreasing;
    

    static InsertionSortDecreasing insertionSortDecreasing = new InsertionSortDecreasing();
    
    /**
     * Constructs a new object of this class.
     */
    public MergeSort()
    {
        // initializing instance variables
        this.startArray = startArray;
    }

 
    // Methods
   
    /**
     * This method uses merge sort to sort an array in increasing order
     * 
     * @param startArray
     * @param lowerIndex
     * @param higherIndex
     */
    @SuppressWarnings("rawtypes")
    public void SortMerge( Comparable[] startArray, int lowerIndex, int higherIndex) {
        //precondition
        if (debug){
            assert startArray[0] != null;
        }
        if (lowerIndex < higherIndex){
            int middle = lowerIndex + (higherIndex -lowerIndex)/2;
            SortMerge (startArray, lowerIndex, middle);
            SortMerge (startArray,middle + 1, higherIndex);
            Merge(startArray, lowerIndex, middle, higherIndex);
        }
        
        //postcondition
        if(debug){
            assert isSorted(startArray, lowerIndex, higherIndex);
        }
            
    }
    
    
    /**
     * This method uses Merge Sort to sort in increasing order
     * @param a, array to be sorted
     * @param lo, lower index of the array
     * @param mid, middle index of the array
     * @param hi, higher index of the array
     */        
    public void Merge(Comparable[] a,  int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        if(debug){
            assert isSorted(a, lo, mid);
            assert isSorted(a, mid+1, hi);
        }
        Comparable[] aux = new Comparable[a.length];

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            //invariant: a[low.. hi] is sorted
            if(debug){
                assert(isSorted(a, lo, k));
            }
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
        // postcondition: a[lo .. hi] is sorted
        if(debug){
            assert isSorted(a, lo, hi);
        }
    }
    

    /**
     * This method times how long it takes to run merge sort
     * for an array passed as a parameter
     * 
     * @param Array Array, the array who is to be sorted
     * @return long time, the amount it takes to sort that array
     */
    
    public long TimeToSort(Comparable[] Array){
        int lowIndex = 0;
        int highIndex = Array.length -1;
        long start= System.nanoTime();      
        this.SortMerge(Array, lowIndex, highIndex);
        long end = System.nanoTime();
        long duration = end - start;
        return duration;
    }
    
    /***************************************
     *  Helper sorting functions.
     */
     
     // is v < w ?
     private static boolean less(Comparable v, Comparable w) {
         return v.compareTo(w) < 0;
     }
         
     // exchange a[i] and a[j]
     private static void exch(Object[] a, int i, int j) {
         Object swap = a[i];
         a[i] = a[j];
         a[j] = swap;
     }
     
    /**
     * confirms that an array is in sorted order.
     * 
     * @param Array Array, the array who is to be confirmed
     * @return boolean sorted. True if the array is sorted, false if not
     */   
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
     }

     private static boolean isSorted(Comparable[] a, int lo, int hi) {
         for (int i = lo + 1; i <= hi; i++)
             if (less(a[i], a[i-1])) return false;
         return true;
     }

     /********************************************
      * runs the comparison analysis and prints results to the console
      */
     public void run(){
        int n = 0;
        while (n <= 27400){
            
         //makes an arrays of size n, used for each of the three cases
        average = new Comparable[n];
        increasing = new Comparable[n];
        decreasing = new Comparable[n];

        
        /**
         * The following three blocks will make the best, worst, and random cases
         */
        
        /*
         * Make the array used for random case and fill the average array
         * with n random objects.
         */
        Random generator = new Random();
        for(int i = 0; i < n; i++)
        average[i] = generator.nextInt(n);      
         
        
         /*
          * The following code finds the best case scenario. 
         */     
        InsertionSort i = new InsertionSort();
        increasing = Arrays.copyOf(average,n);
        increasing = i.SortInsertion(increasing);
        
        /*
          * The following code finds the worst case scenario. 
          */
        InsertionSortDecreasing j = new InsertionSortDecreasing();
        decreasing = Arrays.copyOf(average,n);
        decreasing = j.SortDecretion(decreasing);
        
        /**
         * Will print out the time as csv of the average, best, and worst cases
         */

        System.out.println(n + ";" + this.TimeToSort(Arrays.copyOf(average,n)) + ";" + this.TimeToSort(Arrays.copyOf(increasing,n)) + ";" + this.TimeToSort(Arrays.copyOf(decreasing,n)));
        
        n = n+50;
        }
     } 
}
    