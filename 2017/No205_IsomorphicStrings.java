import java.util.HashMap;

/*************************************
 * 
 * @author Jeff
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * 	
 * 	For example,
 * 	Given "egg", "add", return true.	
 * 	Given "foo", "bar", return false.
 * 	Given "paper", "title", return true.
 * 	Note:
 * 	
 * 	You may assume both s and t have the same length.
 */
public class No205_IsomorphicStrings {
	
	public static void main(String[] args){
		
		String s = "egg";
		String t = "add";
		
		boolean iso = isIsomorphic(s, t);
		
		if(iso){
			
			System.out.println("String " + s + " and " + t + " are isomorphic. ");
		
		} else {
			
			System.out.println("String " + s + " and " + t + " are NOT isomorphic. ");
		}
		
	}//end main();

	private static boolean isIsomorphic(String s, String t) {
		// TODO Auto-generated method stub
		
		if(s.length() != t.length() ) return false; 
		
		HashMap<Character, Character> isoMap = new HashMap<Character, Character>();
		
		for(int i=0; i<s.length(); i++){
			
			if( isoMap.containsKey(s.charAt(i)) ){
				
				if( !isoMap.get(s.charAt(i)).equals(t.charAt(i)) )
					return false;
				
			} else {
				
				if(isoMap.containsValue(t.charAt(i))){
					isoMap.put(s.charAt(i), t.charAt(i));
				} else {
					return false; 
				}
			
			}//end if-else isoMap.containsKey(s.charAt(i)) conditions; 
			
		}//end for i<s.length() loop; 
		
		return true;
	}//end isIsomorphic();
	
}//ee
