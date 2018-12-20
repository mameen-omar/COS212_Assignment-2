/*
Complete your details...
Name and Surname: 
Student/staff Number:
*/


public class DoubleThreadedBST<T extends Comparable<? super T>>
{
	private DTNode<T> root; // the root node of the tree

	/*
	TODO: You must complete each of the methods in this class to create
	your own double threaded BST. You may add any additional methods
	or data fields which you might need to accomplish your task. You
	must NOT change the signatures of any methods given to you with this
	class.
	*/
	
	public DoubleThreadedBST()
	{
		/*
		The default constructor
		*/

		root = null;
	}
	
	public DoubleThreadedBST(DoubleThreadedBST<T> other)
	{
		/*
		The copy constructor
		*/

		return this.clone();
	}
	
	public DoubleThreadedBST<T> clone()
	{
		/*
		The clone method should return a copy/clone
		of this tree.
		*/
		
		return null;
	}
	
	public DTNode<T> getRoot()
	{
		/*
		Return the root of the tree.
		*/
		
		return root;
	}
	
	public boolean insert(T element)
	{
		/*
		The element passed in as a parameter should be
		inserted into this tree. Duplicates are not allowed.
		Left and right threads in the corresponding branch 
		must be updated accordingly, as necessary. 
		If the insert was successfull, the method should 
		return true. If the operation was unsuccessfull, 
		the method should return false.
		
		NB: Do not throw an exception.
		*/

		//if empty
		if(root == null)
		{
			DTNode<T> temp = new DTNode<T>(element);

			temp.setHasLeftThread(false);
			temp.setHasRightThread(false);
			temp.setLeftChild(null);
			temp.setRightChild(null);

			root = temp;

			return true;
		}


		//if it contain this value
		else if(this.contains(element) == true)
		{
			return false;
		}



		//if only root

		else if(root.getLeftChild() == null && root.getRightChild() == null && root.getHasLeftThread() == false && root.getHasRightThread() == false)
		{
			//create the node
			DTNode<T> temp = new DTNode<T>(element);

			//if it is smaller than root
			if(element.compareTo(root.data) < 0)
			{
				root.left = temp;
				temp.setHasRightThread(true);
				temp.right = root;

				return true;
			}

			//if greater
			else
			{
				root.right = temp;
				temp.left = root;
				temp.setHasLeftThread(true);

				return true;
			}

			return false;

			
		}

		else
		{

			DTNode<T> temp = new DTNode<T>(element);

			DTNode<T> dummyNode = root;

			DTNode<T> prev = null;

			while(dummyNode != null)
			{
				prev = dummyNode;

				//if less than and node doesnt have a predesor
				if(element.compareTo(dummyNode.data) < 0 && dummyNode.getHasleftThread() == false)
				{	
					dummyNode = dummyNode.left;
				}

				//greater, to be added right and is not a successor
				else if(element.compareTo(dummyNode.data) > 0 && dummyNode.getHasRightThread() == false)
				{
					dummyNode = dummyNode.right;
				}

				//dont follow links
				else
				{
					break;
				}

			}

			//weve one of the extremes
			if(dummyNode == null)
			{
				//weve reached the left one and needs to be added to left 
				if(element.compareTo(prev.data) < 0 && prev.left == null)
				{
					prev.left = temp;

					temp.setHasRightThread(true);
					temp.setRightChild(prev);

					temp.left == null;

					return true;

				}

				//weve reached left side but needs to added right
				else if(element.compareTo(prev.data) > 0 && prev.left == null)
				{
					temp.setHasRightThread(true);
					temp.setRightChild(prev.right);
					prev.setHasRightThread(false);
					prev.setRightChild(temp);
					temp.setHasLeftThread(true);
					temp.setLeftChild(prev);

					return true;
				}


				//weve come to the right extreme and needs to be added right
				else if(element.compareTo(prev.data) > 0 && prev.right == null)
				{
					prev.right = temp;
					temp.right = null;
					temp.setHasLeftThread(true);
					temp.setLeftChild(prev);

					return true;
				}

				//weve come to the right extreme and needs to be added left
				else if(element.compareTo(prev.data) < 0 && prev.right == null)
				{

					temp.setLeftChild(prev.left);

					prev.left = temp;
					prev.setHasLeftThread(false);

					temp.setHasLeftThread(true);

					temp.setHasRightThread(true);
					temp.setRightChild(prev);

					return true;

				}

			}


			//we arent at extremes
			else
			{	
				//if needs to be added left 
				if(element.compareTo(dummyNode.data) < 0)
				{
					temp.left = dummyNode.left;
					dummyNode.left = temp;
					dummyNode.setHasLeftThread(false);
					temp.setHasLeftThread(true);
					temp.right = dummyNode;
					temp.setHasRightThread(true);

					return true;
				}

				//needs to be added right
				else 
				{
					temp.right = dummyNode.right;
					temp.setHasRightThread(true);
					temp.setHasLeftThread(true);
					temp.setLeftChild(dummyNode);

					dummyNode.right = temp;
					dummyNode.setHasRightThread(false);

					return true;
				}
			}
			

		}



		
		
	}
	
	public boolean delete(T element)
	{
		/*
		The element passed in as a parameter should be
		deleted from this tree. If the delete was successfull,
		the method should return true. If the operation was
		unsuccessfull, the method should return false. Eg, if
		the requested element is not found, return false.
		
		You have to implement the mirror case of delete by merging 
		as discussed in the textbook. That is, for a deleted node,
		its right child should replace it in the tree and not its
		left child as in the textbook examples. Relevant left and
		right threads must be updated accordingly.
		
		NB: Do not throw an exception.
		*/
		if(root == null)
		{
			return false;
		}
		
		
	}
		
	public boolean contains(T element)
	{
		/*
		This method searches for the element passed in as a
		parameter. If the element is found, true should be 
		returned. If the element is not in the tree, the
		method should return false.
		*/
		
		if(root == null)
		{
			return false;
		}

		//if only one node
		else if(root != null && root.left == null && root.right == null)
		{
			if(element.equals(root.data))
			{
				return true;
			}

			return false;
		}
		
	}
	
	public String inorderAscending()
	{
		/*
		This method must return a string representation
		of the elements in the tree inorder, left to right. 
		This function must not be recursive. Instead, right 
		threads must be utilised to perform a depth-first 
		inorder traversal.
		
		If the tree looks like:
		
		   B
		  / \
		 A   D
		    / \
		   C   E
		   
		Then the following string must be returned:
		
		A,B,C,D,E
		
		Note that there are no spaces in the string, and
		the elements are comma-separated.
		*/
		
		return "";
	}
	
	public String inorderDescending()
	{
		/*
		This method must return a string representation
		of the elements in the tree inorder, right to left. 
		This function must not be recursive. Instead, left 
		threads must be utilised to perform a depth-first 
		inorder traversal.
		
		If the tree looks like:
		
		   B
		  / \
		 A   D
		    / \
		   C   E
		   
		Then the following string must be returned:
		
		E,D,C,B,A
		
		Note that there are no spaces in the string, and the elements are comma-separated.
		*/
		
		return "";
	}
	
	public int countRightThreads()
	{
		/*
		This method should return the total number of right threads
		in the tree.
		*/
		if(root == null)
		{
			return 0;
		}
		
	}
		
	public int countLeftThreads()
	{
		/*
		This method should return the total number of left threads
		in the tree.
		*/

		if(root == null)
		{
			return 0;
		}
		
		
	}
	
	public int getNumberOfNodes()
	{
		/*
		This method should count and return the number of nodes 
		currently in the tree.
		*/
		if(root == null)
		{
			return 0;
		}
	}
	
	public int getHeight()
	{
		/*
		This method should return the height of the tree. The height 
		of an empty tree is 0; the height of a tree with nothing but
		the root is 1.
		*/

		//height is the highest level of a node in the tree and the level
		//of a node is the length of the path, from root to node + 1, which
		//is the number of nodes in the path

		//if empty
		if(root = null)
		{
			return 0;
		}

		//if only one element
		else if(root.getLeftChild() == null && root.getRightChild() == null && root.getHasLeftThread() == false && root.getHasRightThread() == false)
		{
			return 1;
		}

		else
		{
			
		}
	}
}
