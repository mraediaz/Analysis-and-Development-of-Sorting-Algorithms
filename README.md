# README
# AnalysisAndDevelopmentOfSortingAlgorithms

Validating and analyzing the run-time complexity of Insertion Sort, Merge Sort, Heap Sort, and Quick Sort. We hope to discover the conditions, if any exist, where it would be most efficient to use one sort versus another by analyzing their best, worst, and random case run-times for multiple input sizes.


#Report Motivation and Background

Different factors can affect the time required to sort data, thus many algorithms exist to solve the task of organizing
comparable values. Because the exact speed of an algorithm depends on the details of the
data that must be sorted, the run-time of algorithms is typically discussed in terms of the size
of its input. For example, if the algorithm must process n objects, it might have a run-time
linearly proportional to n, which would look like O(n). Some other run-times proportional to
n are exponential, polynomial or logarithmic. Yet the run-time of an algorithm isn't solely
dependent on the size of the input; the execution time of many sorting algorithms can vary
due to pre-existing order of the elements that must be sorted. For example, if a sorting
algorithm must sort a set of objects that are already in sorted order, it could take much less
time to re-organize than a set of objects in random order. Consequently, when analyzing the
time complexity of an algorithm, one must keep in mind that algorithm's best case, worst
case, and random case run-times. Typically, the best case is when an algorithm is given a
collection of objects to sort that is already in sorted order, it's worst case is when it is given
a collection of objects sorted in the opposite order, and it's random case is when it is given
a collection sorted in no particular order.

Some sorting algorithms include Insertion Sort, Merge Sort, Heap Sort, and Quick Sort.
Each of these have their own benefois and disadvantages, as well as particular moments when
it would be more appropriate to use one sort style versus another. For example, Insertion
Sort works fastest when there isn't much data, yet for larger amounts of input, the other
sorting algorithms surpass the speed of Insertion Sort. Because of this, it is important for
computer scientists to familiarize themselves with the different run-time behaviors and com-
plexities of these sorting algorithms.

The purpose of this report is to study and analyze the complexity of Insertion Sort, Merge
Sort, Heap Sort, and Quick Sort. By validating and comparing the run-time complexities of
the best, worst, and random cases of each, we hope to gain a better understanding of these
algorithm's run-times. Through analyzing each case, we will discover the conditions, if any
exist, that would make one sort algorithm more efficient than the others. We also hope to
discover at what input size n0 will the run-time behaviors of our implementations begin to
assimilate to that algorithm's asymptotic run-time.

As a final goal, we gain to discover which algorithm has the biggest "leading constant."
Due to its reputation for being the surpassed in speed by other algorithms when n gets large,
we predict, a priori, that Insertion Sort will have the biggest leading constant.
