import java.util.ArrayList;
import java.util.List;

/**
 * The idea is all elevators register with controller while elevator tracks its whereabouts itself.
 * When controller receives call, it check with all elevators to get the closest idle one or a passing elevator, then
 * controller ask elevator
 * 1. open the door if idle elevator is on the calling floor
 * 2. go to the calling floor if it is idling on other floor than the calling floor
 * 3. stop at calling floor if it is passing
 *
 *
 * @author Neo Wang
 * @since 3/15/16
 */
public class Controller {
    private List<Elevator> elevatorList = new ArrayList<Elevator>();

    private final int totalFloors;
    public Controller(final int totalFloors){
        this.totalFloors = totalFloors;
    }

    public void register(Elevator elevator){
        elevatorList.add(elevator);
    }

    public Elevator call(int from) throws InterruptedException {
        Elevator closestIdleElevator = null;
        int min = totalFloors;
        for(Elevator elevator:elevatorList){
            if (elevator.isServiceNeeded()) continue;

            if (elevator.isIdle()) {
                if (from == elevator.getCurrentFloor()) {
                    elevator.open();
                    return elevator;
                } else {
                    int diff = Math.abs(elevator.getCurrentFloor() - from);
                    if (min > diff){
                        min = diff;
                        closestIdleElevator = elevator;
                    }
                }
            } else {
                if (elevator.isPassing(from)){
                    elevator.stopAt(from);
                    return elevator;
                }
            }
        }

        if (closestIdleElevator != null){
            closestIdleElevator.go(from);
        }
        return closestIdleElevator;
    }
}
