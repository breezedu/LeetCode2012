package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/*******************
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * @author Frog
 *
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class MergeIntervalsNAIVE {

	public static void main(String[] args){
		
		System.out.println("This is Merge Intervals program.");
		
		//1st, create #n Intervals, put them into an arrayList
		ArrayList<Interval> oriIntervals = createIntervals();
		
		printALofIntervals(oriIntervals);
		
		
		//2nd, merge overlapping Intervals;
		ArrayList<Interval> mergedInt = merge(oriIntervals);
		System.out.println("After merging overlapped Intervals, the new ArrayList contains:");
		printALofIntervals(mergedInt);
		
	}//end main();

	private static ArrayList<Interval> merge(ArrayList<Interval> oriInt) {
		// TODO merge overlapping Intervals;
		
		if(oriInt == null ||oriInt.size()<=1) return oriInt;
		
		ArrayList<Interval> mergeInt = new ArrayList<Interval>();
		
		int indexSmall = getSmallest(oriInt);
		Interval smallOne = oriInt.get(indexSmall);
		oriInt.remove(indexSmall);
				
		while(!oriInt.isEmpty()){
			
			int index = getSmallest(oriInt);
			Interval smallTwo = oriInt.get(index);
			oriInt.remove(index);
			
			if(smallTwo.start > smallOne.end){
				mergeInt.add(smallOne);
				smallOne = smallTwo;
			
			} else {
				
				smallOne = merge2Intervals(smallOne, smallTwo);
			}
			
		}//end while loop;
		mergeInt.add(smallOne);
		
		return mergeInt;
	}//end merge() method;

	private static int getSmallest(ArrayList<Interval> oriInt) {
		// TODO get the Interval with smallest start value
		if(oriInt.size() == 1){
			return 0;
		}
		
		int Len = oriInt.size();
		int index = 0;
		for(int i=1; i<Len; i++){
			if(oriInt.get(i).start < oriInt.get(index).start) index = i; 
		}
		
		return index;
	}

	private static Interval merge2Intervals(Interval Int1, Interval Int2) {
		// TODO merge two overlapped Intervals
		
		Interval temp = new Interval();
		temp.start = Math.min(Int1.start, Int2.start);
		temp.end = Math.max(Int1.end, Int2.end);
		
		return temp;
	}//end merge2Intervals() method;

	private static ArrayList<Interval> createIntervals() {
		// TODO create n Intervals, put them into an arrayList;
		
		System.out.println("Please input the number of Intervals to create:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		ArrayList<Interval> retIntervals = new ArrayList<Interval>();
		if(num==0){
			return retIntervals;
		}
				
		for(int i=0; i<num; i++){
			Interval tempInt = new Interval();
			tempInt.start =  (int)(Math.random() *10);
			tempInt.end = tempInt.start + (int)(Math.random() *10 +1);
						
			retIntervals.add(tempInt);
		}
		
		return retIntervals;
	}//end createIntervals() method;
	
	private static void printALofIntervals(ArrayList<Interval> al) {
		// TODO printout an arrayList with Intervals
		
		if(al==null){
			System.out.println("The arrayList is empty.");
			return;
		}
		
		for(Interval e:al){
			System.out.print(" [" + e.start +", " + e.end +"]");
		}
		
		System.out.println();
		
	}//end printALofIntervals() method;
	
}//end of everything in MergeIntervals class
