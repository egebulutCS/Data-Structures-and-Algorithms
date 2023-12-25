import java.util.NoSuchElementException;
/**
 * LinkedList: a basic implementation of a singly linked list data structure. 
 * A linked list is a chain of ListNode objects. The head of the list is the 
 * first node of the chain (or null in the case of an empty list).
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class LinkedList
{
    // a linked list has a head node and a size
    private ListNode head;
    private int size;

    /**
     * Construct a new empty list
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Add a new item as the first element
     * @param ListNode node
     */
    public void addFirst(ListNode node) {
        node.setNext(head);
        head = node;
        ++size;
    }

    /**
     * Remove the first list item
     */
    public ListNode removeFirst() {
        ListNode first = head;
        // report error if list empty
        if (head == null) {
            throw new NoSuchElementException();
        } 
        // otherwise remove the item
        else {
            ListNode temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
        }
        return first;
    }

    public void add(Object item){
        ListNode newNode = new ListNode(item, null);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public boolean contains(Object search){
        ListNode temp = head;
        for(int i = 0; i < size; i++){
            if(temp.getData().equals(search)){
                return true; 
            } else {
                temp = temp.getNext();
            }
        }
        return false;
    }

    public void remove(int i){
        if(i>size || i<0){
            System.out.println("Given index it out of boundaries.");
        } else {
            ListNode before = head;
            for(int j = 1; j < i; j++){
                before = before.getNext();
            }
            ListNode target = before.getNext();
            ListNode after = target.getNext();
            target.setNext(null);
            before.setNext(after);
            size--;
        }
    }

    public void addAt(int i, Object item){
        ListNode newNode = new ListNode(item, null);
        if(i>size && i<0){
            System.out.println("Given index it out of boundaries.");
        } else {
            ListNode before = head;
            for(int j = 1; j < i; j++){
                before = before.getNext();
            }
            ListNode after = before.getNext();
            before.setNext(newNode);
            newNode.setNext(after);
            size++;
        }
    }
    
    public LinkedList reverse(){
        LinkedList reverse = new LinkedList();
        ListNode temp = head;
        ListNode reverseTail = new ListNode(head.getData(),null);
        reverse.addFirst(reverseTail);
        for(int i = 1; i < size; i++){
            temp = temp.getNext();
            reverse.addFirst(temp);
        }
        ListNode reverseHead = new ListNode(temp.getNext().getData(), null);
        reverse.addFirst(reverseHead);
        return reverse;
    }
    
    public void removeLast(){
        ListNode temp = head;
        for(int i = 1; i < size; i++){
            temp = temp.getNext();
        }
        temp.setNext(null);
    }
}
