public class Thermostat implements Device {
    private int id;
    private int temperature;
    private String status;

    public Thermostat(int id, int temperature) {
        this.id = id;
        this.temperature = temperature;
        this.status = "set to " + temperature + " degrees";
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return "Thermostat";
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
        
    }

    @Override
    public void turnOff() {
        
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        this.status = "set to " + temperature + " degrees";
    }
}
