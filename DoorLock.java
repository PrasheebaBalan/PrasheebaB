public class DoorLock implements Device {
    private int id;
    private String status;

    public DoorLock(int id) {
        this.id = id;
        this.status = "locked";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return "DoorLock";
    }

    @Override
    public void turnOn() {
        status = "locked";
    }

    @Override
    public void turnOff() {
        status = "unlocked";
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}
