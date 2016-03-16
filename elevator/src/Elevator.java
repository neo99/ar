import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Neo Wang
 * @since 3/15/16
 */
public class Elevator {
    private int trips = 0;
    private int totalFloors = 1;
    private int currentFloor = 0;
    private List<Integer> destinationList = new ArrayList<Integer>();


    private boolean isIdle = true;

    public Elevator(int totalFloors){
        this.totalFloors = totalFloors;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void go(int to) throws InterruptedException {
        if (to < 1 || to > totalFloors) {
            System.out.println("cannot go there");
            return;
        }

        isIdle = false;

        destinationList.add(to);
        for(Iterator<Integer> iterator = destinationList.iterator(); iterator.hasNext();){
            int t = iterator.next();

            if (t>currentFloor){
                for(int i=currentFloor;i<=t;i++){
                    Thread.currentThread().wait(10);
                    currentFloor++;
                    System.out.println("Moving to floor " + currentFloor);
                }
            } else {
                for(int i=currentFloor;i>=t;i--){
                    Thread.currentThread().wait(10);
                    currentFloor--;
                    System.out.println("Moving to floor " + currentFloor);
                }
            }
        }

        isIdle = true;
    }

    public boolean isServiceNeeded(){
        return trips > 100;
    }

    public void service(){
        trips = 0;
    }

    public boolean isIdle(){
        return isIdle;
    }

    public boolean isPassing(int from){
        if (isIdle || destinationList.isEmpty()) return false;

        int currentDestination = destinationList.get(0);
        return currentDestination > from && from > currentFloor
                || currentFloor > from && from > currentDestination;
    }

    public void open() throws InterruptedException {
        System.out.println("open");
        Thread.currentThread().wait(10);
        System.out.println("close");
    }

    /**
     * stop takes priority
     *
     * @param to
     */
    public void stopAt(int to){
        destinationList.add(0, to);
    }
}
