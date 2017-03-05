Michael Elliott

Results:

IN ORDER LINEAR SEARCH
For 1000 objects in order, the Linear Search sort time is 0.0 seconds; Sorting verified
For 10000 objects in order, the Linear Search sort time is 0.001 seconds; Sorting verified
For 100000 objects in order, the Linear Search sort time is 0.004 seconds; Sorting verified
-----------------------------------------------------------------------------------------------------------
REVERSE ORDER LINEAR SEARCH
For 1000 objects in reverse order, the Linear Search sort time is 0.01 seconds; Sorting verified
For 10000 objects in reverse order, the Linear Search sort time is 0.108 seconds; Sorting verified
For 100000 objects in reverse order, the Linear Search sort time is 9.165 seconds; Sorting verified
-----------------------------------------------------------------------------------------------------------
RANDOM ORDER LINEAR SEARCH
For 1000 objects in random order, the Linear Search sort time is 0.003 seconds; Sorting verified
For 10000 objects in random order, the Linear Search sort time is 0.049 seconds; Sorting verified
For 100000 objects in random order, the Linear Search sort time is 6.869 seconds; Sorting verified
-----------------------------------------------------------------------------------------------------------
IN ORDER BINARY SEARCH
For 1000 objects in order, the Binary Search sort time is 0.001 seconds; Sorting verified
For 10000 objects in order, the Binary Search sort time is 0.001 seconds; Sorting verified
For 100000 objects in order, the Binary Search sort time is 0.007 seconds; Sorting verified
-----------------------------------------------------------------------------------------------------------
REVERSE ORDER BINARY SEARCH
For 1000 objects in reverse order, the Binary Search sort time is 0.007 seconds; Sorting verified
For 10000 objects in reverse order, the Binary Search sort time is 0.083 seconds; Sorting verified
For 100000 objects in reverse order, the Binary Search sort time is 6.864 seconds; Sorting verified
-----------------------------------------------------------------------------------------------------------
RANDOM ORDER BINARY SEARCH
For 1000 objects in random order, the Binary Search sort time is 0.001 seconds; Sorting verified
For 10000 objects in random order, the Binary Search sort time is 0.036 seconds; Sorting verified
For 100000 objects in random order, the Binary Search sort time is 5.095 seconds; Sorting verified
-----------------------------------------------------------------------------------------------------------

Explanation:
For an Insertion sort, by linear or binary search, the best case is if the list is already in order, and the worst case is if the list is in reverse order.

The numbers reflect this, with both In Order searches being the quickest and both Reverse Order switches being the slowest.

Because Binary Search does not search through the entire unsorted segment of the list each time it should be faster when sorting through lists of similar sizes,
however, due to the increased resources required when making a method call and the recursive nature of Binary Search, it may be slightly slower with smaller lists.

The times documented above reflect this theory. The Binary Searches for each list of 100,000 Integers is faster than the Linear Searches for each list of 100,000,.
with the exception of the In Order searches, which may be due to a PC hang-up or the result of increased usage by recursion. The same logic can be used to explain
the small differences in smaller lists.