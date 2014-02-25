package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/*******************
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author Frog
 *
 */
public class InsertIntervalBP {
	
	public static void main(String[] args){
		
		System.out.println("This is Insert Interval program.");
		
		//1st, create N Intervals, put them into an arrayList
		ArrayList<Interval> IntervalAL = createIntervals();
		printALofIntervals(IntervalAL);
		
		
		//2nd, create another Interval
		Interval newInt = new Interval();
		newInt.start = (int)(Math.random()*IntervalAL.size());
		newInt.end = newInt.end + (int)(Math.random()*IntervalAL.get(IntervalAL.size()-1).end);
		System.out.println("The new Interval is: ["+newInt.start +", "+newInt.end +"] ");
		
		
		//3rd, insert the solo Interval into the arrayList
		IntervalAL = insertInterval(IntervalAL, newInt);
		
		
		//4th, printout the final Intervals arrayList
		printALofIntervals(IntervalAL);
		
	}//end main();

	private static ArrayList<Interval> insertInterval(ArrayList<Interval> intervalAL, Interval newInt) {
		// TODO Insert an Interval into an arrayList of Intervals, merge all overlaps
		
		//if the AL is empty, or newInt.start is bigger than the last Interval.end in the AL:
		//just add the new Interval to the arrayList, and return the AL;
		if(intervalAL==null || intervalAL.size()==0 || newInt.start>intervalAL.get(intervalAL.size()-1).end){
			intervalAL.add(newInt);
			return intervalAL;
		}
		
		//if the new Interval's end is smaller than the first Internal in the AL;
		//create a new AL, add the newInteral, add the whole original AL, return;
		ArrayList<Interval> retAL = new ArrayList<Interval>();
		if(newInt.end < intervalAL.get(0).start){
			
			retAL.add(newInt);
			retAL.addAll(intervalAL);
			return retAL;
		}//end if condition;
		
		//break the original AL into 3 parts, no-overlap, overlap, no-overlap again;
		//traversal the original AL, if the ith Interval in the AL does not have overlap with
		//newInt, just put the ith Interval into the new ArrayList; otherwise, merge the two
		//keep on traversal, till there's another ith Interval which does not have overlap
		//mark that ith as the breakPoint; jump out of the traversal.
		//add the merged Interval to the AL;
		//add the rest of original (from breakPoint to end) to the new arrayList;
		int Len = intervalAL.size();
		int breakPoint = 0;
		for(int i=0; i<Len; i++){

			Interval temp = intervalAL.get(i);
			if(temp.end < newInt.start){
				retAL.add(temp);
				
			} else if(temp.start > newInt.end){
				
				breakPoint = i;
				break;
				
			} else {
				
				newInt = merge2Intervals(newInt, temp);
			}//end if-else conditions;
			
		}//end for loop;
		
		retAL.add(newInt);
		for(int i=breakPoint; i<Len; i++){
			retAL.add(intervalAL.get(i));
		}
		
		return retAL;
	}//end insertInterval() method;

	private static Interval merge2Intervals(Interval Int1, Interval Int2) {
		// TODO merge two Intervals
		
		Int1.start = Math.min(Int1.start, Int2.start);
		Int1.end = Math.max(Int1.end, Int2.end);
		
		return Int1;
	}//end merge2Intervals() method;

	private static ArrayList<Interval> createIntervals() {
		// TODO Create Intervals, and put them into an arrayList
		ArrayList<Interval> retAL = new ArrayList<Interval>();
		
		System.out.println("Please input the number of Intervals:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		if(num==0){
			System.out.println("No Interval will be created, the AL will be empty.");
			return retAL;
		}
		
		int start = (int)(Math.random() * 10);
		
		for(int i=0; i<num; i++){
			Interval temp = new Interval();
			temp.start = start + (int)(Math.random()*10);
			temp.end = temp.start + (int)(Math.random()*10);
			
			retAL.add(temp); //add the temp Interval to arrayList;
			
			start = temp.end+1; //reset the start value;
			
		}//end for i<num loop;
		
		return retAL;
	}//end createIntervals() method;

	private static void printALofIntervals(ArrayList<Interval> interAL) {
		// TODO printout all Intervals in an arrayList
		if(interAL==null || interAL.isEmpty()){
			System.out.println("There's no Interval in the arrayList.");
			return;
		}//end if interAL is empty condition;
		
		for(Interval e:interAL){
			
			System.out.print(" [" + e.start +", " + e.end +"]");
		}//end for e loop;
		
		System.out.println();
	}//end printALofIntervals() method

}//end of everything in InsertInterval class;
