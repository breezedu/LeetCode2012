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
public class ContainerWithMostWater2Pointers {
	
	public static void main(String[] args){
		
		System.out.println("This is Container With Most Water program.");
		
		//1st, create an array which each element represents the height of a line
		int[] array = createArray();
		printArray(array);
		
		//2nd, calculate the container capability between any two lines;
		int max = maxArea(array);
		
		System.out.println("The maximum container coult contain: " + max +" liters of water.");
		
	}//end main()
	
	/*************
	 * set two pointers point to either end of the array;
	 * pick out the smaller height, not the taller one ;
	 * (because no another height in the array to pair with the smaller one to get large area;
	 * move the smaller height pointer, calculate the area it makes with the other end pointer;
	 * if we got larger area, then that's the new outer pair// OR, if we get a taller height,
	 * then that's also a potential pair; but we just do not update the max-area accordingly; 
	 * 
	 * @param array
	 * @return
	 */
	private static int maxArea(int[] array) {
		// TODO calculate the maximum capacity from the array of heights;
		if(array == null || array.length<2) return 0;
		
		int frontP = 0;
		int endP = array.length-1;
		int area = (endP-frontP) * Math.min(array[frontP], array[endP]);
		
		int maxArea = checkArea(array, frontP, endP, area);
		
		return maxArea;
	}//end of maxArea() method;

	private static int checkArea(int[] array, int frontP, int endP, int area) {
		// TODO check inner area inside frontP and endP;
		if(frontP >= endP){
			return area;
		}
		
		if(array[frontP] < array[endP]){
			
			int p = frontP+1;
			while(array[p] < array[frontP]){
				p++;
			}
			
			int temp = (Math.min(array[p], array[endP]) * (endP-p));
			if(temp > area) area = temp;
			
			area = checkArea(array, p, endP, area);
			
		}
		
		if(array[frontP] >= array[endP]){
			
			int p = endP-1;
			while(array[p] < array[endP]){
				p--;
			}
			
			int temp = (Math.min(array[p], array[frontP]) * (p-frontP));
			if(temp > area) area = temp;
			
			area = checkArea(array, frontP, p, area);
			
		}
		
		return area;
	}//end checkArea() method;

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
