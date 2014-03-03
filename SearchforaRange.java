package leetCode2012;

import java.util.Scanner;

/***************
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * @author Frog
 *
 */

public class SearchforaRange {
	
	public static void main(String[] args){
		
		System.out.println("This is a Search for a Range program.");
		
		//1st, create an sorted array
		System.out.println("Please input the num of elements in the array:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		
		int[] array = createArray(num);
		printArray(array);
		
		
		//2nd, ask user to input the target
		System.out.print("target = ");
		int target = input.nextInt();
		input.close();
		
		
		//3rd, check the start and end indices of target in the array
		int[] range = searchRange(array, target);
		System.out.println("The range of the target in the array is: ");
		printArray(range);
		
		
	}//end main()

	private static int[] searchRange(int[] array, int target) {
		// TODO search the range of target in the array
		int[] range = new int[2];
		range[0] = -1;
		range[1] = -1;
		
		if(array == null || array.length==0 || target<array[0] ||target>array[array.length-1]) {
			return range;
		}
		
		int start = 0;
		int end = array.length-1;
		range = checkRange(array, start, end, range, target);
		
		return range;
	}//end searchRange() method;

	private static int[] checkRange(int[] array, int start, int end, int[] range, int target) {
		// TODO check if the middle element between array[start] and array[end] is >, = or < target;
		if(start > end) return range;
		
		if(start == end){
			if(array[start] != target){
				return range;
				
			} else if(array[start] == target){
				if(range[0]==-1 && range[1] ==-1){
					range[0] = start;
					range[1] = end;
				}
				if(start < range[0]) range[0] = start;
				if(start > range[1]) range[1] = start;
				
			}
			
			return range;
		}
		
		int mid = (end+start)/2; 
		if(array[mid] > target){
			checkRange(array, start, mid-1, range, target);
			
		} else if(array[mid] < target){
			checkRange(array, mid+1, end, range, target);
			
		} else if(array[mid] == target){
			if(range[0] == -1){
				range[0] = mid;
				range[1] = mid;
			
			} else if(mid < range[0]) {
				range[0] = mid;
				
			} else if(mid > range[1]){
				range[1] = mid;
				
			}
			//after update the range[], we have to check both side of array[mid];
			range = checkRange(array, start, mid-1, range, target);
			range = checkRange(array, mid+1, end, range, target);
			
		}//end if-else array[mid] ><= target;
		
		return range;
	}//end checkRange() method;

	private static int[] createArray(int num) {
		// TODO create an array of num elements		
		if(num == 0){
			return null;
		}
		
		int[] array = new int[num];
		array[0] = (int)(Math.random() *25);		
		for(int i=1; i<num; i++){
			
			array[i] = array[i-1] + (int)(Math.random() * 10);
		}
		
		return array;
	}//end of createArray();

	private static void printArray(int[] array) {
		// TODO printout an array
		System.out.print("[");
		if(array==null || array.length==0){
			System.out.println("Nothing in the array.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		System.out.println("]. ");
	}//end of printArray() method;

}//end of everything in SearchforaRange class
