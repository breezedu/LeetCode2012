package leetCode2012;

public class ValidSudoku {

	public static void main(String[] args){
		
		System.out.println("This is Valid Sudoku program.");
		
		//1st, build a 9*9 board:
		System.out.println("Build a 9*9 board for Sudoku:");
		char[][] board = new char[9][9];
		boolean validBoard = isValidSudoku(board);
		
		if(validBoard){
			System.out.println("This is a valid Sudoku board.");
		}
	}//end main();
	
	
	public static boolean isValidSudoku(char[][] board) {

		//check each 3*3 small board
        for(int m=0; m<7; m+=3){
        	
        	for(int n=0; n<7; n+=3){
        		//(m,n) is the start coordinate of each small board
        		
        		boolean smallBoard = checkSmallBoard(board, m, n);
        		if(smallBoard==false) return false;
        	}
        }
        
        return true;
    }


	private static boolean checkSmallBoard(char[][] board, int m, int n) {
		// TODO Auto-generated method stub
		
		int[] smallBoard = new int[10];
		//use this array to check if there's any duplicates in the small 3*3 board;
		
		for(int i=m; i<m+3; i++){
			
			for(int j=n; j<n+3; j++){
				
				if(board[i][j] != '.'){				    
				    
				    //1st, check row;
				    int count = 0;
			    	for(int k= 0; k<9; k++){
				        if(board[i][k] == board[i][j]) count++;
				    
			    	}
				    if(count>1) return false;
				
				    //2nd, check column;
				    count = 0;
				    for(int k=0; k<9; k++){
				        if(board[k][j] == board[i][j]) count ++;
				    }
				    if(count>1) return false;
				    
				    //3rd, check the small board;
				    
				    int num = Integer.parseInt(String.valueOf(board[i][j])); 
				    smallBoard[num] ++;
				}
			
				
			}//inner for loop;
		}
		
		for(int k=1; k<10; k++){
			if(smallBoard[k]>1) return false;
		}
		
		return true;
	}//end check Smallboard() method;
	
}
