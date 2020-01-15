/**********************************************************************
 *  readme template
 *  Global Sequence Alignment
 **********************************************************************/

Name:Bryan Ayala-Vega

Hours to complete assignment (optional): 4 plus lab hours

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/
No major problems. I had a rough time starting but once I got the idea of
Recursion and dynamic programming it became much easier.

/**********************************************************************
 *  Make a table of values showing running times for the method
 *  recursiveEditDistance when given two random DNA strings of length
 *  N, where N from 1 to about 10 or 12.  To do this properly, it would
 *  be best to repeat the test several times for each value of N, and
 *  average the times.
 *
 *  What can you say about the growth of this time as a function of N?
 *  
 **********************************************************************/
Running times; DNA length;
 0              1
 0              2
 0              3
 .001           4
 .002           5      
 .003           6
 .012           7
 .023           8
 .064           9
 .268          10
 1.569         11

Time is growing at a rate of N*N when N > 4

/**********************************************************************
 *  For each data file, fill in the edit distance computed by your
 *  program and the amount of time it takes to compute it.
 **********************************************************************/

data file           distance       time (seconds)
-------------------------------------------------
ecoli3000.txt		126				.150
ecoli5000.txt		160				.325
ecoli7000.txt		195				.647
ecoli10000.txt		224				1.085


/**********************************************************************
 *  Because the dynamic programming version does a fixed amount of
 *  computation for each element in the two-dimensional table,
 *  we expect that the time complexity should be quadratic.  Does the
 *  data above seem to support this hypothesis?   Use the doubling
 *  hypothesis to explain how you arrived at your answer.
 **********************************************************************/
we can see that the results shows evidence that the time is in a quadratic relationship to N.
in ecoli3000, N is 3000 and ecoli5000 has a N of 5000. there is a difference of 2000 in N. and in the 
time there is a time difference of roughly .160 seconds. Giving evidence to the quadratic relation
N has with time.

/**********************************************************************
 *  As a function of the string length N (assume M = N), estimate the
 *  running time of your program (and the sample) in seconds. Your answer
 *  should have the form a * N^2 for some constant a.
 *
 *  What is the largest N your program can handle if it is limited to 1
 *  day of computation? Assume you have as much main memory as you need.
 **********************************************************************/

a = 1.6 * 10^-8 seconds
largest N = 2.3*10^6 elements

86400 seconds in a day 
a * n^2 = time

3000 = n, time = .150 in ecoli3000
so a = 1.6 * 10^-8 seconds
then a * n^2 = time 
means (1.6 * 10^-8) * n^2 = 86400
therefore n = 2.3*10^6 elements


/**********************************************************************
 *  List whatever help (if any) that you received. You don't need to
 *  include the course materials or lectures, but do include any
 *  additional help your received from people other than course staff,
 *  and include their names.
 **********************************************************************/
I got help from the tutors, Quinn and one more but I do not know his name.
 

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/
