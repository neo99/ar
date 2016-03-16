import java.util.ArrayList;
import java.util.List;

/**
 * @author Neo Wang
 * @since 3/15/16
 */
public class Controller {
    private List<Elevator> elevatorList = new ArrayList<Elevator>();

    public void register(Elevator elevator){
        elevatorList.add(elevator);
    }

    public void call(int from){

    }

    public void go(int to){

    }
}
