
/**
 * Write a description of class ApprenticeChallenge here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ApprenticeChallenge
{
    private int[] theArray;

    public ApprenticeChallenge(int size){
        theArray = new int[size];
        for(int i = 0; i < size; i++){
            theArray[i] = i;
        }
    }

    public void findPosition(){
        int[] save = theArray;
        while(theArray.length != 1){
            int[] temp = new int[theArray.length/2];
            int rear = 0;
            for(int i = 0; i < theArray.length; i++){
                if((i % 2) != 0){
                    temp[rear] = theArray[i];
                    rear++;
                }
            }
            theArray = temp;
        }
        print();
        theArray = save;
    }

    public void print(){
        for(int i = 0; i < theArray.length; i++){
            System.out.println(theArray[i]);
        }
    }
}