/***********************************
 * 
 * @author Jeff
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *      ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * 
 */
public class No168_ExcelSheetColumnTitle {
	
	public static void main(String[] args){
		
		for(int n= 1; n<54; n++){
					
			String sheet = convertToTitle1(n);
			String sheet2 = convertToTitle2(n);
			
			System.out.println("The number " + n + ", " + sheet + ", " + sheet2);
		}
	}//end main();

	private static String convertToTitle2(int n) {
		// TODO Auto-generated method stub
		
		String s = "";
		
		if(n < 27){
			
			char curr = (char)(n + '@');	
			 s += curr;
			 
			 return s;
		} else {
			
			s = convertToTitle2( (n-1)/26 );
			
			int left = (n-1)%26;
			char curr = (char)(left + 'A');
			//if(left ==0) curr = 'Z';
			
			s += curr; 
			
			return s;
		}
		
	}

	/***********
	 * 1-A, 2-B, 26-Z, 27-AA... 
	 * Since we could NOT ignore ZERO, so we change the pattern from 1-A, 2-B, 27-AA to 0-A, 1-B, 26-AA....
	 * make n to n-1;
	 * 
	 * Now, it is a 26-decimal pattern:
	 * 
	 * @param n
	 * @return
	 */
	private static String convertToTitle1(int n) {
		// TODO Auto-generated method stub
		
		String ret = "";
				
		while(n > 0){
						
			char curr = (char)((n-1)%26 + 'A');						
			n = (n-1) / 26;
			
			//System.out.println("curr: " + curr + ", n= " + n);
			
			ret = curr + ret;
			
		}
		
		return ret;
	}
	
	
}//ee
