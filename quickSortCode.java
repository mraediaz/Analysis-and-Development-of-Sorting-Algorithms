import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 *  COMP 215: Design and Analysis of Algorithms: Programming Assignment<br>
 *
 *  The <code>QuickSort</code> class provides an algorithm that will sort a given
 *  array into increasing order using the QuickSort algorithm.
 *   
 *  This is made for a program that validates the run-time 
 *  complexity and asymptotic run-time complexity for different kinds of sort methods 
 *
 *  This code will be used to compare the worst case, best case, and average case run times
 *  for Quick Sort
 *  <br> <br>
 *  Created: <br>
 *     [02,05,2016], [Melany Diaz]<br>
 *  Modifications: <br>
 *  
 *  
 *  @author [Melany Diaz] 
 */

public class QuickSort 
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
    static Comparable increasing[];
    static Comparable decreasing[];
        
    static Random generator = new Random();
    
    static InsertionSortDecreasing insertionSortDecreasing = new InsertionSortDecreasing();
    
    /**
     * Constructs a new object of this class.
     */
    public QuickSort()
    {
        // initializing instance variables
        this.startArray = startArray;
    }

 
    // Methods
    
    /**
     * This method uses Quick sort to sort an array in increasing order
     * 
     * @param startArray, the array needed to be sorted
     * @param int p
     * @param int r
     *  
     * @return startArray, a permutation of the original 
     * array but sorted in increasing order
     *  
     */
    @SuppressWarnings("rawtypes")
    public void RandomizedQuicksort( Comparable[] startArray, int p, int r) {
         // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        if(debug){
            assert isSorted(startArray, p, r);
        }
        if (p < r){
//          int q = this.partition(startArray, p, r);
//          this.SortQuick(startArray, p, q-1);
//          this.SortQuick(startArray, q+1, r);
            int q = this.RandomizedPartition(startArray, p, r);
            this.RandomizedQuicksort(startArray, p, q-1);
            this.RandomizedQuicksort(startArray, q+1, r);
        }
        // postcondition: a[lo .. hi] is sorted
        if(debug){
            assert isSorted(startArray, p, r);
        }
    }
    
    /**
     * Partitions the array
     * 
     * @param startArray
     * @param p
     * @param r
     * @return
     */
    private int partition(Comparable[] startArray, int p, int r) {
        int x = (int) startArray[r];
        int i = p-1;
        for ( int j = p; j<=r-1; j++){
            int y = (int) startArray[j];
            if(y <= x){
                i = i+1;
                this.exch(startArray, i, j);
            }
        }
        this.exch(startArray, i+1, r);
        return i+1;
    }

    
    /** 
      * exchange a[i] and a[j]
      * @param a, and array
      * @param i, index
      * @param j, index
      */
    
    /**
     *  Helper sorting functions.
     */
     
     // is v < w ?
     private static boolean less(Comparable v, Comparable w) {
         return v.compareTo(w) < 0;
     }
     
     private void exch(Comparable[] a, int i, int j) {
         Comparable swap = a[i];
         a[i] = a[j];
         a[j] = swap;
        }

    /**
     * This method times how long it takes to run Quick sort
     * for an array passed as a parameter
     * 
     * @param Array Array, the array who is to be sorted
     * @return long time, the amount it takes to sort that array
     */
    
    public long TimeToSort(Comparable[] Array){
        int lowIndex = 0;
        int highIndex = Array.length -1;
        long start= System.nanoTime();      
        this.RandomizedQuicksort(Array, lowIndex, highIndex);
        long end = System.nanoTime();
        long duration = end - start;
        return duration;
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

     public int RandomizedPartition(Comparable[] A, int p,int r){
       int i = generator.nextInt((r - p) + 1) + p;
       this.exch(A, r, i);
       return this.partition(A, p, r);   
     }

    /**
     * runs the comparison analysis
     *  
     */
    public void run(){
        int n = 5;
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
        
       for(int i = 0; i < n; i++)
        average[i] = generator.nextInt(n);  
       
       this.RandomizedPartition(average, 0, average.length-1);
        
       
        /*
         * The following code finds the best case scenario. 
         */     
        
        increasing = Arrays.copyOf(average,n);
    
        
        /*
         * The following code finds the worst case scenario. 
         */
        
        decreasing = Arrays.copyOf(average,n);
        
        /**
         * Will print out the time as csv of the average, best, and worst cases
         */

        System.out.println(n + ";" + this.TimeToSort(Arrays.copyOf(average,n)) + ";" + this.TimeToSort(Arrays.copyOf(increasing,n)) + ";" + this.TimeToSort(Arrays.copyOf(decreasing,n)));
        
        n = n+200;
        }
        
    }

    
}

   