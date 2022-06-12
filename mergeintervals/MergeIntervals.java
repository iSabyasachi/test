package test.mergeintervals;

import java.util.*;
/**
Given a list of intervals, merge all the overlapping intervals to produce a list that 
has only mutually exclusive intervals.

Ex. 1 : 
Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into 
one [1,5].

Ex. 2: 
Intervals: [[6,7], [2,4], [5,9]]
Output: [[2,4], [5,9]]
Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].

 */
class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public String toString(){
      return this.start+" "+this.end;
  }
};

class MergeIntervals {

  public static List<Interval> merge(List<Interval> intervals) {
    if(intervals.size() < 2)
        return intervals;

    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));    
    List<Interval> mergedIntervals = new LinkedList<Interval>();

    Iterator<Interval> itr = intervals.iterator();
    Interval interval = itr.next();
    int start = interval.start;
    int end = interval.end;

    while(itr.hasNext()){
        interval = itr.next();
        if(interval.start <= end){
            end = Math.max(interval.end, end);            
        }else{
            mergedIntervals.add(new Interval(start, end));
            start = interval.start;
            end = interval.end;
        }
    }
    mergedIntervals.add(new Interval(start, end));
    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));    
    input.add(new Interval(2, 5));
    
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
    /*
    input = new ArrayList<Interval>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
    */
  }
}