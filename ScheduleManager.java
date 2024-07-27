import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleManager {
    private static final Logger LOGGER = Logger.getLogger(ScheduleManager.class.getName());
    private static ScheduleManager instance = new ScheduleManager();
    private List<Schedule> schedules = new ArrayList<>();

    private ScheduleManager() {}

    public static ScheduleManager getInstance() {
        return instance;
    }

    public void addSchedule(int deviceId, String time, String command) {
        try {
            LocalTime parsedTime = LocalTime.parse(time);
            Schedule schedule = new Schedule(deviceId, parsedTime, command);
            schedules.add(schedule);
            LOGGER.info("Schedule added: " + schedule);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error adding schedule", e);
        }
    }

    public List<Schedule> getSchedules() {
        return new ArrayList<>(schedules); 
    }
}
