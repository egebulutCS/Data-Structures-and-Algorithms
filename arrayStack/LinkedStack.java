

/**
 * Array-based implementation of the stack.
 ********************PUBLIC OPERATIONS*********************
 * void push( x )         --> Insert x
 * void pop( )            --> Remove most recently inserted item
 * ******************ERRORS********************************
 * pop on empty stack

 * @author Mark Allen Weiss. Adapted Bill Keller Jan 2011
 */

public class LinkedStack {
    private LinkedList theList;
    private int size;

    /**
     * Construct the stack.
     */
    public LinkedStack() {
        theList = new LinkedList();
        size = theList.getSize();
    }
    
    public LinkedStack(String str){
        //start counting "(" after first appearance of ")" if there is "(" return false else return true
    }

    /**
     * Remove the most recently inserted item in the stack.
     * @return the most recently inserted item in the stack.
     * @throws UnderflowException if the stack is empty.
     */
    public Object pop( ) {
        if( size <= 0 ) {
            throw new UnderflowException( "Array Stack pop" );
        }
        else {
            Object topElement = theList.getAt(size);
            theList.removeLast();
            return topElement;
        }
    }
    
    /**
     * Insert a new item into the stack.
     * @param newElement the item to insert.
     */
    public void push( Object newElement ) {  
        if(size == 0){
            theList.add(newElement);
        } else {
            theList.addLast(newElement);
        }
    }

    public boolean isEmpty(){
        return size==0;
    }
    
    public int size(){
        return size;
    }
    
    public Object top(){
        return theList.getAt(size);
    }
    
    /**
     * Exception class for access in empty containers
     * such as stacks, queues, and priority queues.
     * @author Mark Allen Weiss
     */
    private class UnderflowException extends RuntimeException {
        /**
         * Construct this exception object.
         * @param message the error message.
         */
        public UnderflowException( String message ) {
            super( message );
        }
    }
    
    /**
     * Exception class for access in empty containers
     * such as stacks, queues, and priority queues.
     */
    private class OverflowException extends RuntimeException {
        /**
         * Construct this exception object.
         * @param message the error message.
         */
        public OverflowException( String message ) {
            super( message );
        }
    }
}

