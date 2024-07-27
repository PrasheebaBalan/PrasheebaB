import java.util.logging.Logger;
import java.util.logging.Level;

public class Trigger {
    private static final Logger LOGGER = Logger.getLogger(Trigger.class.getName());
    private String condition;
    private String action;

    public Trigger(String condition, String action) {
        this.condition = condition;
        this.action = action;
    }

    public boolean evaluate(int currentTemperature) {
        try {
            
            if (condition.equals("temperature > 75") && currentTemperature > 75) {
                executeAction(action);
                return true;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error evaluating trigger", e);
        }
        return false;
    }

    private void executeAction(String action) {

    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }
}
