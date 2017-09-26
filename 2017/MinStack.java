
public class MinStack {
	
	stackNode node;
	
	public MinStack(){
				
	}
	
	public void push(int x){
		if( node == null){
			node = new stackNode(x, x);
		
		} else {
			
			stackNode p = new stackNode(x, node.min);
			p.next = node;
			
			node = p;
		}
	}
	
	public void pop(){
		node = node.next;
	}
	
	public int top(){
		return node.val;
	}
	
	public int getMin(){
		return node.min; 
	}
	
	/*********
	 * Create a linked list, with val and min, 
	 * val records current value;
	 * min records minium values for all nodes in the linked list;
	 * 
	 * @author Jeff
	 *
	 */
	private class stackNode{
		
		int val;
		int min; 		
		stackNode next;
		
		stackNode(int x, int y){
			this.val = x;
			this.min = Math.min(x,  y);
			
		}//set values
		
	}//end stackNode;

}
