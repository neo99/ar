import java.util.ArrayList;
import java.util.List;

/**
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

    public Elevator call(int from){
        Elevator closestIdleElevator = null;
        for(Elevator elevator:elevatorList){
            if (elevator.isServiceNeeded()) continue;

            if (elevator.isIdle()) {
                if (from == elevator.getCurrentFloor()) {
                    return elevator;
                } else {
                    
                }
            } else {

            }
        }
    }
}
