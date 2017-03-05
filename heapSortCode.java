import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *  COMP 215: Design and Analysis of Algorithms: Programming Assignment<br>
 *
 *  The <code>HeapSort</code> class provides an algorithm that will sort a given
 *  array into increasing order using the HeapSort algorithm.
 *   
 *  This is made for a program that validates the run-time 
 *  complexity and asymptotic run-time complexity for different kinds of sort method.
 *
 *  This code will be used to compare the worst case, best case, and average case run times
 *  for HeapSort.
 *  <br> <br>
 *  Created: <br>
 *     [02,05,2016], [Melany Diaz]<br>
 *  Modifications: <br>
 *  
 *  
 *  @author [Melany Diaz] 
 */
public class HeapSort 
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
        

    static InsertionSortDecreasing insertionSortDecreasing = new InsertionSortDecreasing();
        
    /**
     * Constructs a new object of this class.
     */
    public HeapSort()
    {
        // initializing instance variables
        this.startArray = startArray;
    }

 
    // Methods
    
    /**
     * Finds parent node
     */
    public int Parent(int i){
        return Math.floorDiv(i, 2);
    }

    /**
     * Finds left node
     */
    public int Left(int i){
        return 2*i;
    }
    
    /**
     * Finds right node
     */
    public int Right(int i){
        return (2*i)+1;
    }
    
    /**
     * makes a heap out of an array
     * @param startArray
     * @param i
     */
    public void MaxHeapify(Comparable[] startArray, int i){
        int largest;
        int l = Left(i);
        int r = Right(i);
        if (l <= startArray.length && startArray[l].compareTo(startArray[i]) == 1)
            largest = 1;
        else largest = i;
        if (r <= startArray.length && startArray[r].compareTo(startArray[largest]) == 1)
            largest = r;
        if (largest != i){
            this.exch(startArray, i, largest);
            this.MaxHeapify(startArray, largest);
        }
    }
    
    /**
     * Builds a max heap
     * @param startArray
     */
    @SuppressWarnings("rawtypes")
    public void BuildMaxHeap( Comparable[] startArray){
        for(int i = Math.floorDiv(this.largest(startArray), 2); i==1; i--){
            this.MaxHeapify(startArray, i);
        }
    }
    
    
    
    /**
     * Finds the largest element in a list
     * @param startArray
     * @return the element
     */
    public int largest(Comparable[] startArray){
        int largest = 0;
        for (int i = 0; i < startArray.length-1; i++){
            if (startArray[i].compareTo(startArray[i+1]) == -1)
                largest = (int) startArray[i+1];
        }
        return largest;
    }
    
    
    /*******************************************************************
     * This method uses heap sort to sort an array in increasing order
     * 
     * @param startArray, the array needed to be sorted
     * 
     *******************************************************************/
    public void SortHeap(Comparable[] startArray) {
        //confirming preconditions
        if(debug)
            assert(startArray[0] != null);
        this.BuildMaxHeap(startArray);
        for (int i = startArray.length; i == 2; i--){
            //confirming invariant
            if (debug)
                assert(this.IsSorted(startArray));
            this.exch(startArray, 1, i);
            int n = startArray.length;
            n = startArray.length - 1;
            this.MaxHeapify(startArray, 1);
        }
        //confirming postconditions
        if(debug)
            assert(this.IsSorted(startArray));
    }
    
     /** 
      * exchange a[i] and a[j]
      * @param a, and array
      * @param i, index
      * @param j, index
      */
        private void exch(Comparable[] a, int i, int j) {
            Comparable swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
        
    /**
     * This method times how long it takes to run heap sort
     * for an array passed as a parameter
     * 
     * @param Array Array, the array who is to be sorted
     * @return long time, the amount it takes to sort that array
     */
    
    public long TimeToSort(Comparable[] Array){
        long start= System.nanoTime();      
        this.SortHeap(Array);
        long end = System.nanoTime();
        long duration = end - start;
        return duration;
    }
    
    /**
     * This method confirms that an array is in sorted order.
     * 
     * @param Array Array, the array who is to be confirmed
     * @return boolean sorted. True if the array is sorted, false if not
     */
    
    public boolean IsSorted(Comparable[] Array){
        boolean sorted = true;
        for (int i = 0; i < Array.length-1; i++){
            if (Array[i].compareTo(Array[i+1]) == 1){
                sorted = false;
                break;
            }
        }
        return sorted;
    }


    /**
     * runs the comparison analysis
     */
    
    public void run(){
        int n = 0;
        while (n <= 27400){
            
        //makes an arrays of size n, used for each of the three cases
       average = new Comparable[n];     
    
       Random generator = new Random();
       for(int i = 0; i < n; i++)
        average[i] = generator.nextInt(n);      
       
       
        /**
         * Will print out the time as csv of the average, best, and worst cases
         */

        System.out.println(n + ";" + this.TimeToSort(Arrays.copyOf(average,n)) + ";" + this.TimeToSort(Arrays.copyOf(average,n)) + ";" + this.TimeToSort(Arrays.copyOf(average,n)));
        
        n = n+50;
        }
    }    
}
    