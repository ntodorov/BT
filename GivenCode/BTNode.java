//YOU NEED TO IMPLEMENT 3 methods in here at the bottom: inorder, count, and find.
import java.util.*;
public class BTNode<T> 
{
    protected T element;
    protected BTNode<T> left, right;
    private BinaryTree<T> rootT;
    private ArrayIterator<T> AI;
    //-----------------------------------------------------------------
    //  Creates a new tree node with the specified data.
    //-----------------------------------------------------------------
    public BTNode (T element)
    {
        this.element = element;
        left = right = null;
    }

    //-----------------------------------------------------------------
    //  Returns the element stored in this node.
    //-----------------------------------------------------------------
    public T getElement()
    {
        return element;
    }

    //-----------------------------------------------------------------
    //  Sets the element stored in this node.
    //-----------------------------------------------------------------
    public void setElement (T element)
    {
        this.element = element;
    }

    //-----------------------------------------------------------------
    //  Returns the left subtree of this node.
    //-----------------------------------------------------------------
    public BTNode<T> getLeft()
    {
        return left;
    }

    //-----------------------------------------------------------------
    //  Sets the left child of this node.
    //-----------------------------------------------------------------
    public void setLeft (BTNode<T> left)
    {
        this.left = left;
    }

    //-----------------------------------------------------------------
    //  Returns the right subtree of this node.
    //-----------------------------------------------------------------
    public BTNode<T> getRight()
    {
        return right;
    }

    //-----------------------------------------------------------------
    //  Sets the right child of this node.
    //-----------------------------------------------------------------
    public void setRight (BTNode<T> right)
    {
        this.right = right;
    }

    // Below are the methods that need completing. You will have to remove UnsupportedOperationException
    // when you fill out your methods

    //-----------------------------------------------------------------
    //  Returns the element in this subtree that matches the
    //  specified target. Returns null if the target is not found.
    //-----------------------------------------------------------------
    public BTNode<T> find (T target)
    {
        BTNode<T> result = null;
        

        if(target == getElement())
        {
            //target = temp.getElement();
            return this;
        }
        else 
        {

            if (getLeft() != null)
                result = getLeft().find(target);
            
            if (result == null && getRight() != null) 
                result = getRight().find(target);

        }

        

        return result;
    }

    //-----------------------------------------------------------------
    //  Returns the number of nodes in this subtree.
    //-----------------------------------------------------------------
    public int count()
    {
        //init the variable - 1 because it counts itself
        int result = 1;
        
        //if there is a left leaf - get its count and add it.
        if(left != null)
        {
            result += left.count();
        }
        
        //add the right leaf count
        if(right != null)
        {
            result += right.count();
        }
        
        return result;
    }

    //-----------------------------------------------------------------
    //  Performs an inorder traversal on this subtree, updating the
    //  specified iterator. This method does not print anything just
    //  performs the traversal
    //-----------------------------------------------------------------
    public void inorder (ArrayIterator<T> iter)
    {
        //TO - DO
        iter.add(element);
        if(left != null)
        {
            left.inorder(iter);
        }
        else if(right != null)
        {
            right.inorder(iter);
        }
        //throw new UnsupportedOperationException();
    }

}