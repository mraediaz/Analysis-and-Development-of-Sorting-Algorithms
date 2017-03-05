import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


// import java.util.ArrayList;


/**
 *  COMP 215: Design and Analysis of Algorithms: Programming Assignment 
 *
 *  The <code>SortingAnalysis</code> class provides a main method
 *  for a program that validates the run-time complexity and asymptotic run-time 
 *  complexity for different kinds of sort methods.
 *
 *  This code will be used to compare the worst case, best case, and average case run times
 *  for Insertion Sort, Merge Sort, Heap Sort and Quick Sort.
 *  
 *     
 *  Created:  
 * 		[01/24/2016], [Melany Diaz] 
 * 		With assistance from:  Dr. Gerry Howser 
 *  Modifications:  

 *		[01/24/2016], [Melany Diaz], [implemented code to sort in increasing
 *		and decreasing orders, made an array of user inputed size of random integers] 
 *
 *		[01/27/2016], [Melany Diaz], [discovered arrays have a toString 
 *		method, so changed how to print the arrays, refactored main class 
 *		and update documentary, added timing mechanisms ] 
 *
 *		[01,31,2016], [Melany Diaz], [perfected comments and headers(specifying pre and post
 *		conditions), added assert statements and changed the program so that it wouldn't
 *		just compare integers, but any comparable object, had the user choose if the array should be printed]
 *		and invariants
 *		
 *		[02,11,2016], [Melany Diaz], [Tailored the class for project 2]
 *
 *  @author [Melany Diaz]   [with assistance from Dr. Gerry Howser]
 */

 
public class SortingAnalysis 
{
	/*
	 * Instance Variables
	 */
	
	//Objects of each sorting class	
	static InsertionSort insertionSort = new InsertionSort();
	static MergeSort mergeSort = new MergeSort();
	static HeapSort heapSort = new HeapSort();
	static QuickSort QuickSort = new QuickSort();


	
    /**
     *  The main function initiates execution of this program.
     *  Makes the worst, best, and average arrays and then times how 
     *  long it takes to sort them  in ascending order. 
     *  Will print out each array if they are smaller than 20 elements
     *  and will print the amount of time it took to sort them.
     *  The user will specify how big each array will be.
     *  
     *    @param    String[] args not used in this program
     **/
    public static void main(String[] args)
    {    	
    	//find the time complexities of each sorting style
    
    	System.out.println("InsertSort" + "\n" + "n; Random; Best; Worst");
    	insertionSort.run();
    	
    	System.out.println("MergeSort" + "\n" + "n; Random; Best; Worst");
    	mergeSort.run();

    	System.out.println("HeapSort" + "\n" + "n; Random; Best; Worst");
    	heapSort.run();
    	
    	System.out.println("QuickSort" + "\n" + "n; Random; Best; Worst");
    	QuickSort.run();

    }//end main

}//end class