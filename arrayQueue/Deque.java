
/**
 * Write a description of class Deque here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deque
{
    private Object[] theArray;
    private int currentSize;
    private int front;
    private int rear;
    
    private static final int DEFAULT_CAPACITY = 3;
    
    public Deque(){
        theArray = new Object[DEFAULT_CAPACITY];
        currentSize = 0;
        front = 0;
        rear = 0;
    }
    
    public boolean isEmpty(){
        return currentSize == 0;
    }
    
    public int size(){
        return currentSize;
    }
    
    public void addLast(Object item){
        if(currentSize == theArray.length){
            doubleQueue();
        }
        theArray[rear] = item;
        rear = increment(rear);
        currentSize++;
    }
    
    public Object removeLast() throws UnderflowException{
        if(isEmpty()){
            throw new UnderflowException("ArrayQueue remove");
        }
        currentSize--;
        Object rearItem = theArray[rear];
        rear = increment(rear);
        return rearItem;
    }
    
    public void addFirst(Object item){
        if(currentSize == theArray.length){
            doubleQueue();
        }
        Object[] temp = theArray;
        theArray[0] = item;
        front = increment(front);
        currentSize++;
        for(int i = 1; i < currentSize-1; i++){
            theArray[i] = temp[i-1];
        }
    }
    
    public Object removeFirst() throws UnderflowException{
        if(isEmpty()){
            throw new UnderflowException("ArrayQueue remove");
        }
        currentSize--;
        Object frontItem = theArray[front];
        front = increment(front);
        return frontItem;
    }
    
    /**
     * Internal method to increment with wraparound.
     * @param x any index in theArray's range.
     * @return x+1, or 0 if x is at the end of theArray.
     */
    private int increment(int x)
    {
        /*
        if(++x == theArray.length)
            x = 0;
        return x;
        */
       return ++x % theArray.length;
    }
    
    /**
     * Internal method to expand theArray.
     */
    private void doubleQueue()
    {
        Object[] newArray = new Object[theArray.length * 2];

        // Copy elements that are logically in the queue
        for(int i = 0; i < currentSize; i++, front = increment(front))
            newArray[i] = theArray[front];

        theArray = newArray;
        front = 0;
        rear = currentSize;
    }
    
    /**
     * Exception class for access in empty containers
     * such as stacks, queues, and priority queues.
     * @author Mark Allen Weiss
     */
    private class UnderflowException extends RuntimeException
    {
        /**
         * Construct this exception object.
         * @param message the error message.
         */
        public UnderflowException(String message)
        {
            super(message);
        }
    }
}
