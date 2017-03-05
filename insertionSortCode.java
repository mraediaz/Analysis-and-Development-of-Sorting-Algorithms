import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 *  COMP 215: Design and Analysis of Algorithms: Programming Assignment<br>
 *
 *  The <code>InsertionSort</code> class provides an algorithm that will sort a given
 *  array into increasing order using the InsertionSort algorithm. 
 *  This is made for a program that validates the run-time 
 *  complexity and asymptotic run-time complexity for different kinds of sort methods 
 *
 *  This code will be used to compare the worst case, best case, and average case run times
 *  for Insertion Sort
 *  <br> <br>
 *  Created: <br>
 *     [01/24/2016], [Melany Diaz]<br>
 *     With assistance from:  Dr. Gerry Howser and Dr. Alyce Brady<br>
 *  Modifications: <br>
 *     [01/24/2016], [Melany Diaz], [constructed the class and the first methods]<br>
 *     [01,27,2015], [Melany Diaz], [constructed a method that will time how long it takes
 *     to run insertionSort]<br>
 *     [01,31,2016], [Melany Diaz], [perfected comments and headers(specifying pre and post
 *      conditions), added assert statements and changed the program so that it wouldn't
 *      just compare integers, but any comparable objct]
 *      and invariants
 *      [02,11,2016], [Melany Diaz], [added assertions and a confirmation method]
 *
 *  @author [Melany Diaz]   [with assistance from Dr. Gerry Howser]
 */

public class InsertionSort 
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
    
    public InsertionSort()
    {
        // initializing instance variables
        this.startArray = startArray;
    }

 
    // Methods
    
    /**
     * This method uses insertion sort to sort an array in increasing order
     * 
     * @param startArray, the array needed to be sorted
     * @return startArray, a permutation of the original 
     * array but sorted in increasing order
     * 
     */
    public Comparable[] SortInsertion(Comparable[] startArray) {
        //confirming preconditions
        if(debug)
            assert(startArray[0] != null);
        
        for (int j = 1; j < startArray.length; j++)
        {
            //confirming invariant
            if (debug)
                assert(this.IsSorted(startArray));
                
            Integer key = (Integer) startArray[j];
       
            //Insert StartArray[j] into the sorted sequence StartArray[0,....,j-1]
            int i = j-1;
            
            while (i >= 0 && startArray[i].compareTo(key) == 1){                
                startArray[i+1] = startArray[i];
                i = i-1;
            }//end while loop
            
            startArray[i+1] = key;
        }//end for loop
        
        //confirming postconditions
        if(debug)
            assert(this.IsSorted(startArray));
            
        return (startArray);
    }
    
    
    /**
     * This method times how long it takes to run insertion sort
     * for an array passed as a parameter
     * 
     * @param Array Array, the array who is to be sorted
     * @return long time, the amount it takes to sort that array
     */
    
    public long TimeToSort(Comparable[] Array){
        long start= System.nanoTime();      
        this.SortInsertion(Array);
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
         * The following code uses InsertionSort and its methods 
         * to find the best case scenario. InsertionSort will 
         * sort the array items in an increasing order. it will 
         * make a new array with the same elements but in increasing order
         */     
        
        increasing = Arrays.copyOf(average,n);
        increasing = this.SortInsertion(increasing);
    
        
        /*
         * The following code uses InsertionSortDecreasing and its methods 
         * to find the worst case scenario. InsertionSortDecreasing will 
         * sort the array items in decreasing order. It will
         * make a new array with the same elements but in decreasing order
         */
        
        decreasing = Arrays.copyOf(average,n);
        decreasing = insertionSortDecreasing.SortDecretion(decreasing);
        
        
        /**
         * Will print out the time as csv of the average, best, and worst cases
         */

        System.out.println(n + ";" + this.TimeToSort(Arrays.copyOf(average,n)) + ";" + this.TimeToSort(Arrays.copyOf(increasing,n)) + ";" +this.TimeToSort(Arrays.copyOf(decreasing,n)));
                
        n = n+50;
        }
    }

    
}
    