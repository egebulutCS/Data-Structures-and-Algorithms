
/**
 * Write a description of class LinkedQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedQueue
{
    private LinkedList theList;
    private int size;
    
    public LinkedQueue(){
        theList = new LinkedList();
        size = theList.getSize();
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int size(){
        return size;
    }
    
    public void enqueue(Object item){
        if(size == 0){
            theList.add(item);
        } else {
            theList.addLast(item);
        }
    }
    
    public Object dequeue() throws UnderflowException{
        if(!isEmpty()){
            size--;
            Object frontItem = theList.getFirst();
            return frontItem;
        } else {
            throw new UnderflowException("ArrayQueue remove");
        }
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
