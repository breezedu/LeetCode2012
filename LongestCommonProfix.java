package leetCode2012;

import java.util.Scanner;

public class LongestCommonProfix {
	
	public static void main(String[] args){
		
		System.out.println("This is a Longest Common Profix program.");
		
		//1st, create an array of strings;
		String[] strs = buildString();
		//printout the original strings:
		printStrArray(strs);
		
		//2nd, find out the longest common prefix:
		String LCP = longestCommonPrefix(strs);
		System.out.println("The longest common prefix is: " + LCP);
		
	}//end main();

	private static void printStrArray(String[] strs) {
		// TODO Printout the original strings
		if(strs == null){
			System.out.println("It's an empty string.");
			return;
		}
		
		int Len = strs.length;
		for(int i=0; i<Len; i++){
			System.out.println(" " + strs[i]);
		}
		
		System.out.println();
	}//end of printStrArray() method;

	private static String[] buildString() {
		// TODO build an array of strings
		System.out.println("Please input the num of strings in the array:");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		if(num==0){
			input.close();
			return null;
			
		}//end of return null condition;
		
		System.out.println("There are " + num +" strings, please input them one by one:");
		String[] strs = new String[num];
		
		for(int i=0; i<num; i++){
			
			System.out.print("string # " +(i+1)+": ");
			strs[i] = input.next();
		}//end for i<num loop; all strings have been inputed;
		
		input.close();
		return strs;
	}//end buildString() method;

	private static String longestCommonPrefix(String[] strs) {
	  if(strs == null || strs.length == 0){
          return "";
      } 
      
      String retStr = "";
      int numOfStr = strs.length;
      if(numOfStr ==1) return strs[0];
      
      int Len = strs[0].length();
      for(int i=0; i<numOfStr; i++){
          if(strs[i].length() <Len)
              Len = strs[i].length();
      }
      
      for(int i=0; i<Len; i++){
          char temp = strs[0].charAt(i);
          boolean match = true;
          for(int j=1; j<numOfStr; j++){
              
              if(strs[j].charAt(i) != temp)
                 match = false;
                 
          }
          if(match){
              retStr += temp;
              
          } else {
              
              return retStr;
          }
          

      }
      
      
      return retStr;
  }
}
