public class Light implements Device {
    private int id;
    private String status;

    public Light(int id) {
        this.id = id;
        this.status = "off";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return "Light";
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void performAction(String action) {
        if ("turnOn".equals(action)) {
            turnOn();
        } else if ("turnOff".equals(action)) {
            turnOff();
        }
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void turnOn() {
        this.status = "on";
    }

    @Override
    public void turnOff() {
        this.status = "off";
    }
}
