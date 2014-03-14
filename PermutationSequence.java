package leetCode2012;

import java.util.ArrayList;
import java.util.Scanner;

/******************
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive. 
 * @author Frog
 */
public class PermutationSequence {
	
	public static void main(String[] args){
		
		System.out.println("This is PermutationsI program.");
		
		//1st, create an array
		System.out.print("Please input the integer: num = ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		//calculate # of possible permutations
		int pn = 1;
		for(int i=0; i<num; i++){
			pn *= (i+1);
		}
		System.out.println("There are " + pn + " possible permutations.");
		System.out.print("Please input the Kth permutation sequence: k=" );
		int k = input.nextInt();
		
		input.close();
		
		
		//2nd, calculate the Kth permutation sequence		
		String kthPermutation = getPermutation(num, k);
		
		//3rd, printout the permutations
		System.out.println("The Kth, permutation sequence is: " + kthPermutation);
		
		System.out.println("\nPrintout all possible permutations in order:");
		for(int i=0; i<pn; i++){
			System.out.println("The " + (i+1) +"th permutation is: " + getPermutation(num, (i+1)));
		}
		
	}//end main()

	/*************
	 * After sorting all permutations, we could see the pattern:
	 * take num=4 for example, there are 4*3*2*1=24 permutations in total;
	 * the first 6 start with 1, the 7-12 start with 2, 13-18 start with 3, 19-24 start with 4;
	 * to choose the 1st number of the Kth permutation, we have to calculate k/(3*2*1); 
	 * if we got 0, then the first element is 1; got 1, the first element is 2, etc...
	 * 
	 * after we got the first element, we have to check the second; 
	 * indeed, it is quite similar with check k=k%(3*2*1) for (4-1) permutations;
	 * this time we have to calculate k%(3*2*1), then use this new Kth to check which number
	 * should the second element be; 
	 * BUT, the number left could be (1,2,3), (1,3,4), (1,2,4) or (2,3,4), whatever left for
	 * next cycle, there must be the same order: from small to big; Here, I use an arrayList
	 * to store all integers from 1 to n, every time we finish a cycle, pick out that integer
	 * from the arrayList, then remove it; all other integers left in the arrayList are still
	 * in the same ordering;
	 * 
	 * 
	 * @param num
	 * @param k
	 * @return
	 */
	private static String getPermutation(int num, int k) {
		// TODO get the kth permutation sequence of num integers;		
		String retStr = "";
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int totalPer = 1;
		
		for(int i=1; i<=num; i++){
			nums.add(i);
			totalPer *= i;
		}
	
		k=k-1; 	//this step is a trick;
		while(num>0){			
			totalPer = totalPer/num;	//P(n)=n*(n-1)**2*1; we get P(n-1) here;
			int curr = k/totalPer;		//the currTH integer in the nums is the one!
			retStr += nums.get(curr);	//add the currTH integer to the ret-String;
			nums.remove(curr);			//remove curr, sequence in the AL is sorted still;
			
			k = k%totalPer;				//update k for next cycle;
			num = num-1;				//update num for next figure;
		}
		
		return retStr;
	}//end getPermutation() method;
	
}//end of everything in PermutationsI class
