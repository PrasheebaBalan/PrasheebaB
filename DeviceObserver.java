import java.util.ArrayList;
import java.util.List;
public class DeviceObserver implements Observer {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    @Override
    public void update(String message) {
        System.out.println("Update received: " + message);
       
    }
}
