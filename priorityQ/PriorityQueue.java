import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;
/**
 * LinkedList: a basic implementation of a singly linked list data structure.
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class PriorityQueue
{
    private ListNode head;
    private int size;
    private static final int LOWEST_PRIORITY = Integer.MAX_VALUE;
    private static final int HIGHEST_PRIORITY = Integer.MIN_VALUE;

    public PriorityQueue() {
        head = null;
        size = 0;
    }

    public void insert(int k, Object x) {
        Entry entry = new Entry(k,x);
        ListNode node = new ListNode(entry, null);
        node.setNext(head);
        head = node;
        ++size; 
    }

    public Entry removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {          
            ListNode header = new ListNode(null,head);
            ListNode current = header, before = header;
            int key, minKey = LOWEST_PRIORITY;  
            Entry entry, minEntry = null;
            while (current.getNext() != null) {
                entry = (Entry) current.getNext().getData();
                key = entry.getKey();
                if (key <= minKey) {
                    before = current; 
                    minEntry = entry;
                    minKey = key;
                }
                current = current.getNext();
            }
            before.setNext(before.getNext().getNext());
            head = header.getNext();
            size--;
            return minEntry;
        }
    }

    public Entry removeMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {          
            ListNode header = new ListNode(null,head);
            ListNode current = header, before = header;
            int key, maxKey = HIGHEST_PRIORITY;  
            Entry entry, maxEntry = null;
            while (current.getNext() != null) {
                entry = (Entry) current.getNext().getData();
                key = entry.getKey();
                if (key >= maxKey) {
                    before = current; 
                    maxEntry = entry;
                    maxKey = key;
                }
                current = current.getNext();
            }
            before.setNext(before.getNext().getNext());
            head = header.getNext();
            size--;
            return maxEntry;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() 
    {
        return size;
    }

}
