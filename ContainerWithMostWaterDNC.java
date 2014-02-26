package leetCode2012;

import java.util.Scanner;

/****************
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints 
 * of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, 
 * such that the container contains the most water.
 *  
 * Note: You may not slant the container.
 * 
 * @author Frog
 *
 */
public class ContainerWithMostWaterDNC {
	
	public static void main(String[] args){
		
		System.out.println("This is Container With Most Water program.");
		
		//1st, create an array which each element represents the height of a line
		int[] array = createArray();
		printArray(array);
		
		//2nd, calculate the container capability between any two lines;
		int max = maxArea(array);
		
		System.out.println("The maximum container coult contain: " + max +" liters of water.");
		
	}//end main()

	private static int maxArea(int[] array) {
		// TODO calculate the maximum capacity from the array of heights;
		if(array == null || array.length<2) return 0;
		
		int Len = array.length;
		int maxL = 0;
		int maxM = 0;
		int maxR = 0;
		
		int mid = Len/2;
		for(int i=0; i<mid-1; i++){
			
			for(int j=i+1; j<mid; j++){
				
				int tempContain = (j-i) * Math.min(array[i], array[j]);
				if(tempContain > maxL) maxL = tempContain;
			}
		}
		
		for(int i=mid; i<Len-1; i++){
			for(int j=i+1; j<Len; j++){
				int temp = (j-i) * Math.min(array[i], array[j]);
				if(temp > maxR) maxR = temp;
			}
		}
		
		for(int i=0; i<mid; i++){
			for(int j=mid; j<Len; j++){
				
				int temp = (j-i) * Math.min(array[i], array[j]);
				if(temp > maxM) maxM = temp;
			}
		}
		
		return maxOfThree(maxL, maxR, maxM);
	}//end of maxArea() method;

	private static int maxOfThree(int maxL, int maxR, int maxM) {
		// TODO Auto-generated method stub
		int max = maxL;
		if(maxR > max) max = maxR;
		if(maxM > max) max = maxM;
		
		return max;
	}//end maxOfThree() method;

	private static int[] createArray() {
		// TODO Create an array of random integers (>0)
		
		System.out.println("Please input the number of elements in the array:");
		Scanner input = new Scanner(System.in);
		System.out.print("num = ");
		int num = input.nextInt();
		input.close();
		
		if(num==0) return null;
		
		int[] array = new int[num];
		for(int i=0; i<num; i++){
			array[i] = (int)(Math.random()*10 + 1);
		}
		
		return array;
	}

	private static void printArray(int[] array) {
		// TODO printout an array
		if(array == null) {
			System.out.println("The arra is empty.");
			return;
		}
		
		int Len = array.length;
		for(int i=0; i<Len; i++){
			
			System.out.print(" " + array[i]);
		}
		
		System.out.println();
	}//end printArray() method;

}//end of everything in ContainerWithMostWater class
