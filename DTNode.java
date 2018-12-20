/*
Complete your details...
Name and Surname: Mohamed Ameen Omar
Student/staff Number: u16055323
*/

public class DTNode<T extends Comparable<? super T>>
{
	/*
	TODO: You must implement a node class which would be appropriate to use with your trees.
	Methods and variables can be added.
	Names of the given variables must not be altered. 
	*/
	
	protected T data;
	protected DTNode<T> left, right; // left child and right child
	protected boolean hasLeftThread, hasRightThread; // flags that indicate whether the left and the right pointers are threads

	public Node(T input)
	{
		this.data = input;
		left = right = null;
		hasLeftThread = hasRightThread = false;
	}

	//setters
	public void setHasLeftThread(boolean bool)
	{
		this.hasLeftThread = bool;
	}

	public void setHasRightThread(boolean bool)
	{
		this.hasRightThread = bool;
	}

	public void setLeftChild(DTNode<T> node)
	{
		this.left = node;
	}

	public void setRightChild(DTNode<T> node)
	{
		this.right = node;
	}

	//getters

	public boolean getHasLeftThread()
	{
		return this.hasLeftThread;
	}

	public boolean getHasRightThread()
	{
		return this.hasRightThread;
	}

	public DTNode<T> getLeftChild()
	{
		return this.left;
	}

	public DTNode<T> getRightChild()
	{
		return this.right;
	}

	public T getData()
	{
		return this.data;
	}


	
}
