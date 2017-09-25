/**************
 * 
 * @author Jeff
 * 
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * 
 */
public class No278_FirstBadVersion {
	
	public static void main(String[] args){
		
		int n = 12;
		
		System.out.println(" The first bad version is: " + bstBad(0, n) );
		
	}//end main();

	/**************
	 * pretty interesting that (end-start)/2 will fail, while start + (end+start)/2 will pass!!!
	 * Because, (end - start) will excite the limit of integer. 
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private static int bstBad(int start, int end) {
		// TODO Auto-generated method stub
        if(start == end) return start;
        
        int mid = start + (end - start)/2;
        int ret = mid;
        
        if( isBadVersion(mid) ){
            ret = bstBad(start, mid);
        } else if( isBadVersion(mid) == false ) {
            
            ret = bstBad(mid+1, end);
        }
        
        return ret; 
	}

	private static boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

}//ee
