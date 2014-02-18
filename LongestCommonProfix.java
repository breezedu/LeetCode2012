package leetCode2012;

public class LongestCommonProfix {

	public String longestCommonPrefix(String[] strs) {
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
