        
/**
 * Write a description of class TestLinkedList here.
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class List1 {

    private LinkedList myList;
      
    public List1() {   
        myList = new LinkedList();
        // Now add some items to the List
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(-5);
        Integer i3 = new Integer(15);
        Integer i4 = new Integer(-20);
        Integer i5 = new Integer(25);
        myList.addFirst(new ListNode(i1, null));
        myList.addFirst(new ListNode(i2, null));
        myList.addFirst(new ListNode(i3, null));
        myList.addFirst(new ListNode(i4, null));
        myList.addFirst(new ListNode(i5, null));
        myList.removeFirst();
        myList.add(80);
        myList.addAt(4, 18);
        System.out.println(myList.contains(-5));
        System.out.println(myList.contains(-30));
        myList.remove(2);
        System.out.println(myList.reverse());
        myList.removeLast();
        System.out.println(myList.reverse());
    }
}
