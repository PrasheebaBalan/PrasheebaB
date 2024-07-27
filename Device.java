public interface Device {
    int getId(); 
    String getType(); 
    void turnOn(); 
    void turnOff(); 
    String getStatus(); 
    void setStatus(String status); 
void performAction(String action);
}
