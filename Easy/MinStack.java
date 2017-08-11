package leetcode2017;

import java.util.Stack;

public class MinStack {

	Stack<Integer> s;
	Integer minEle; 
	
	MinStack(){
		s = new Stack<Integer>();
	}
	
	
	void getMin(){
		
		if(s.isEmpty())
			System.out.print("The Stack is Empty");
		
		else 
			System.out.println("Minimum Element in the stack is: " + minEle);
		
	} //end getMin() 
	
	
	void peek(){
		
		if(s.isEmpty()){
			System.out.println("Stack is empty.");
			return;
		}
		
		Integer t = s.peek(); 
		
		System.out.println("Top most element is: " );
		
		if( t < minEle)
			System.out.println(minEle);
		else
			System.out.println(t);
	
	} //end peek()
	
	void pop(){
		
		if( s.isEmpty()){
			
			System.out.println("The stack is empty.");
			return; 
		}
		
		System.out.print("Top Most Element Removed: ");
		Integer t = s.pop(); 
		
		if( t < minEle ){
			
			System.out.println(minEle);
			minEle = 2 * minEle - t; 
		
		} else {
			
			System.out.println(t);
			
		} //end if-else
		
		
	} //end pop()
	
	
	
	void push(Integer x){
		
		if ( s.isEmpty()){
			
			minEle = x; 
			s.push(x);
			System.out.println("Number Inserted: " + x);
			
			return; 
		}
		
		
		if( x < minEle){
			
			s.push(2*x - minEle); 
			minEle = x; 
		
		} else {
			
			s.push(x); 
			
		}
		
		System.out.println("Number pushed into stack: " + x);
		
		
	}//end push(); 
	
	
	public static class Main{
		
		public static void main(String[] args){
			
			MinStack s = new MinStack(); 
			
	        s.push(3);
	        s.push(5);
	        s.getMin();
	        s.push(2);
	        s.push(1);
	        s.getMin();
	        s.pop();
	        s.getMin();
	        s.pop();
	        s.peek();
			
		} //end main();
	}//end Main
	
	
}//end MinStack() 
