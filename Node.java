public class Node<T>
{
	
	private T data;
	private Node<T> next = null;
	private Node<T> prev = null;

	public Node(T data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public T getData() { return this.data; }
	public void setNext(Node<T> next) { this.next = next; } 
	public Node<T> getNext() { return next; }	
	public boolean hasNext() { return next != null; }
	public void setPrevious(Node<T> prev) { this.prev = prev; } 
	public Node<T> getPrevious() { return prev; }	
	public boolean hasPrevious() { return prev != null; }
} // END Node class