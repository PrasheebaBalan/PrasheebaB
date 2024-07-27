import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class SmartHomeSystem {
    private Map<Integer, Device> devices = new HashMap<>();
    private List<Schedule> schedules = new ArrayList<>();
    private List<Trigger> triggers = new ArrayList<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
    }

    public Device getDevice(int id) {
        return devices.get(id);
    }

    public void turnOnDevice(int id) {
        Device device = devices.get(id);
        if (device != null) {
            device.performAction("turnOn");
        }
    }

    public void turnOffDevice(int id) {
        Device device = devices.get(id);
        if (device != null) {
            device.performAction("turnOff");
        }
    }

    public void setDeviceStatus(int id, String status) {
        Device device = devices.get(id);
        if (device != null) {
            device.setStatus(status);
        }
    }

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }

    public void evaluateTriggers(int currentTemperature) {
        for (Trigger trigger : triggers) {
            if (trigger.evaluate(currentTemperature)) {
                
            }
        }
    }

    public void showScheduledTasks() {
        for (Schedule schedule : schedules) {
            System.out.println("Device: " + schedule.getDeviceId() + ", Time: " + schedule.getTime() + ", Command: " + schedule.getCommand());
        }
    }

   public void getStatusReport() {
    for (Device device : devices.values()) {
        String type = device.getType();
        int id = device.getId();
        String status = device.getStatus();
        
      
        if ("Thermostat".equals(type)) {
            System.out.println(type + " " + id + " is " + status + ".");
        } else if ("Light".equals(type)) {
            System.out.println(type + " " + id + " is " + status + ".");
        } else if ("DoorLock".equals(type)) {
            System.out.println(type + " " + id + " is " + status + ".");
        } else {
            System.out.println(type + " " + id + " has an unknown status.");
        }
    }
}

}
