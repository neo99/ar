/**
 * @author Neo Wang
 * @since 3/15/16
 */
public class Elevator {
    private int trips = 0;
    private int top = 1;
    private int currentFloor = 0;

    private boolean isIdle = true;

    public Elevator(int top){
        this.top = top;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void go(int to){
        isIdle = false;
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
}
