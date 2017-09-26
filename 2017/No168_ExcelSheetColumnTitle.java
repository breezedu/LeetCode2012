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
		
		int n= 27;
		
		String sheet = convertToTitle(n);
		
		System.out.println("The number " + n + " corresponds to sheet title: " + sheet);
		
	}//end main();

	/***********
	 * 1-A, 2-B, 26-Z, 27-AA...
	 * It is a 26-decimal pattern:
	 * 
	 * @param n
	 * @return
	 */
	private static String convertToTitle(int n) {
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
