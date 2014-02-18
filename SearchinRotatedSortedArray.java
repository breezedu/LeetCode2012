package leetCode2012;

import java.util.Scanner;

/*******************
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. 
 * If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * @author Frog
 *
 */

public class SearchinRotatedSortedArray {

	public static void main(String[] args){
		
		System.out.println("This is a Search in Rotated Sorted Array program.");
		
		//1st, build an rotated array;
		int[] arrayRotated = buildRotatedArray();
		printArray(arrayRotated);
		
		
		//get the target;
		int target = getTarget();
		
		//2nd, search the target in the rotated array;
		
		int targIndex = search(arrayRotated, target);
		
		if(targIndex == -1){
			System.out.println("There's no such element in the array.");
		} else {
			System.out.println("The match element is located at index: " + targIndex);
		}
	}//end main();

	private static int search(int[] array, int target) {
		// TODO Auto-generated method stub
		

        if(array==null) return -1;
       
       int Len = array.length;
       if (target == array[0]){
           return 0;
           
       }  else if( target == array[Len-1]){
           return Len-1;
           
       }else if( target > array[0]){
           
           for(int i=0; i<Len; i++){
               
               if(array[i] == target) return i;
               if(array[i] < array[0]) return -1;
           }//end for loop;
           
       } else if(target < array[Len-1]){
           for(int j=Len-1; j>=0; j--){
               
               if(array[j] == target) return j;
               if(array[j] > array[Len-1]) return -1;
               
           }//end for j loop;
           
       }
     return -1;  
   
	}//end search() method;

	private static int getTarget() {
		// TODO input a integer
		System.out.println("Please input the target integer:");
		
		Scanner inputNum = new Scanner(System.in);
		int num = inputNum.nextInt();
		inputNum.close();
		
		return num;
	}//end getTarget() method;

	@SuppressWarnings("resource")
	private static int[] buildRotatedArray() {
		// TODO build an rotated array;
		System.out.println("Please indicate the num of elements in the array:");
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		if(num == 0){
			input.close();
			return null;
		}
		
		int[] arrayOri = new int[num];
		arrayOri[0] = (int)(Math.random() * 10);
		for(int i=1; i<num; i++){
			
			arrayOri[i] = arrayOri[i-1] + (int)(Math.random()*10+1);
		}
		
		System.out.println("The original unrotated array has been built:");
		printArray(arrayOri);
		
		//input the rotate point:
		System.out.println("Please input the rotate point:");
		int rotate = input.nextInt();
		
		while(rotate<0 || rotate>=num){
			System.out.println("That's not a valid rotate point, must between (0 " +num +"). ");
			rotate = input.nextInt();
		}//end while loop;
	//	input.close();
		
		int[] arrayRot = new int[num];
		for(int i=0; i<rotate; i++){
			arrayRot[i+ num -rotate] = arrayOri[i];
		}
		
		for(int i= rotate; i<num; i++){
			
			arrayRot[i-rotate] = arrayOri[i];
		}
		
	//	printArray(arrayRot);
		
		return arrayRot;
	}//end buildRotatedArray() method;

	private static void printArray(int[] array) {
		// TODO printout an array
		if(array == null){
			System.out.println("There's nothing in the array.");
			return;
		}
		int Len = array.length;
		
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}//end for i<Len loop;
		
		System.out.println();
	}//end printArray() method;
	
	
}//end everything in SearchinRotatedSortedArray class
