import java.util.HashMap;

/*******************************
 * 
 * @author Jeff
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s. 
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 */
public class No242_ValidAnagram {
	
	public static void main(String[] args){
		
		// if there's any unicode characters in the string, we might need to use HashMap or create a long ASCII array
		
		String s = "anagram";
		String t = "nagaram";
		
		//Here, assume the input strings contain nicode characters, so we could not simply create an array of alphabet[26]; 
		boolean isAna = isAnagram(s, t);
		
		if(isAna){
			System.out.println("The two strings are anagram.");
		
		} else {
			System.out.println("The two strings are NOT anagram");
			
		}
		
		
	}//end main(); 

	/***************
	 * Check string is a re-arrangement of string s:
	 * @param s
	 * @param t
	 * @return
	 */
	private static boolean isAnagram(String s, String t) {
		// TODO Auto-generated method stub
		if(t.length() != s.length()) return false; 
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			if(!map.containsKey(s.charAt(i))){
				
				map.put(s.charAt(i), 1);
			} else {
				
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
				
			}
		}
		
		for(int i=0; i<t.length(); i++){
			
			if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))<1) return false;
			
			if( !map.containsKey(t.charAt(i)) ) return false; 
			
			if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>0){
				map.put(t.charAt(i), map.get(t.charAt(i)) -1 );
			}
		}
		
		return true;
	}

}
