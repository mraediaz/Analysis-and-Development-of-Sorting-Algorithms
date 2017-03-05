import java.util.ArrayList;

/**
 *  COMP 215: Design and Analysis of Algorithms: Programming Assignment 1<br>
 
 *  The <code>InsertionSortDecreasing</code> class provides an algorithm that will sort a given
 *  array into decreasing order using the Insertion Sort algorithm. This is made for a program 
 *  that validates the run-time complexity and asymptotic run-time complexity for different 
 *  kinds of sort methods. This will sort in descending order
 *
 *  This code will be used to compare the worst case, best case, and average case run times
 *  for Insertion Sort
 *  
 *  <br> <br>
 *  Created: <br>
 *     [01/24/2016], [Melany Diaz]<br>
 *     With assistance from:  Dr. Gerry Howser<br>
 *
 *  Modifications: <br>
 *     [01/24/2016], [Melany Diaz], 
 *	[constructed the class and the first methods]<br>
 *
 *     [01,27,2015], [Melany Diaz], 
 *	[constructed a method that will time how long it takes
 *     to run insertionSort]<br>
 *
 *     [01,31,2016], [Melany Diaz], 
 *	[perfected comments and headers (specifying pre and post
 *		conditions), added assert statements and changed 
 *		the program so that it wouldn't
 *		just compare integers, but any comparable objct]
 *		and invariants
 *
 *  @author [Melany Diaz][with assistance from Dr. Gerry Howser]
 */

public class InsertionSortDecreasing 
{
	// instance variables
	Comparable[] startArray;
	
	
    /**
     * Constructs a new object of this class.
     */
    public InsertionSortDecreasing()
    {
        // initializing instance variables
    	this.startArray = startArray;     
    }

  // Methods
    
    /**
     * This method uses insertion sort to sort an array in decreasing order
     * 
     * @param startArray, the array needed to be sorted
     *  **written according to the pseudocode precondition**
     *  @precondition An original array, A, to be sorted (and j=1)
     *  
     * @return startArray, a permutation of the original 
     * array but sorted in increasing order
     * 	**written according to the pseudocode postconditions**
     * 	@postcondtions A permutation of the original array, A', such
     * 	that for all m,n in {1..n} m > n: A'[m] > A'[n] 
     * 
     */
    public Comparable[] SortDecretion(Comparable[] startArray) {
    
    	for (int j = 1; j < startArray.length; j++)
        {
        	Integer key = (Integer) startArray[j];
        	
        	//Insert StartArray[j] into the sorted sequence StartArray[0,....,j-1]
        	int i = j;
        	
        	while(i>0 && startArray[i-1].compareTo(key)==-1){
        		startArray[i] = startArray[i-1];
        		i = i-1;
        	}//end while loop
        	
        	startArray[i] = key;
        }//end for loop
        return (startArray);
    }
}
    