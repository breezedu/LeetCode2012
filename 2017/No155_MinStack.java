/***************************
 * 
 * @author Jeff
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 */
public class No155_MinStack {
	
	public static void main(String[] args){
		
		MinStack ms = new MinStack();
		
		for(int i=0; i<10; i++){
			ms.push(i*2 + 3);
		}
		
		ms.pop();
		
		System.out.println("The top of the stack: " + ms.top() ); 
		System.out.println("The minium value of the stack is: " + ms.getMin());
		
		
	}//end main();

}//ee
