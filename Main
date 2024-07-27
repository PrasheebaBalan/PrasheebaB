import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static SmartHomeSystem system = new SmartHomeSystem();
    private static UserProfileManager userProfileManager = UserProfileManager.getInstance();
    private static ScheduleManager scheduleManager = ScheduleManager.getInstance();

    public static void main(String[] args) {
       
        LoggerConfig.setup();

        system.addDevice(DeviceFactory.createDevice("light", 1, 0));
        system.addDevice(DeviceFactory.createDevice("thermostat", 2, 70));
        system.addDevice(DeviceFactory.createDevice("door", 3, 0));


        system.addTrigger(new Trigger("temperature > 75", "turnOff(1)"));

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getUserChoice();
            try {
                running = executeUserChoice(choice);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error executing user choice", e);
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Display Available Devices");
        System.out.println("2. Turn On Device");
        System.out.println("3. Turn Off Device");
        System.out.println("4. Set Device Status");
        System.out.println("5. Set Thermostat Temperature");
        System.out.println("6. Get Status Report");
        System.out.println("7. Show Scheduled Tasks");
        System.out.println("8. Evaluate Triggers");
        System.out.println("9. Add Schedule");
        System.out.println("10. Add User Profile");
        System.out.println("11. Set User Profile");
        System.out.println("12. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            LOGGER.warning("Invalid input. Please enter a number.");
            scanner.next(); 
            System.out.print("Enter your choice: ");
        }
        return scanner.nextInt();
    }

    private static boolean executeUserChoice(int choice) {
        switch (choice) {
            case 1:
                displayAvailableDevices();
                break;
            case 2:
                turnOnDevice();
                break;
            case 3:
                turnOffDevice();
                break;
            case 4:
                setDeviceStatus();
                break;
            case 5:
                setThermostatTemperature();
                break;
            case 6:
                system.getStatusReport();
                break;
            case 7:
                scheduleManager.getSchedules().forEach(System.out::println);
                break;
            case 8:
                evaluateTriggers();
                break;
            case 9:
                addSchedule();
                break;
            case 10:
                addUserProfile();
                break;
            case 11:
                setUserProfile();
                break;
            case 12:
                return false; // Exit the loop
            default:
                LOGGER.warning("Invalid choice. Please enter a number between 1 and 12.");
        }
        return true; 
    }

    private static void displayAvailableDevices() {
        system.getStatusReport();
    }

    private static void turnOnDevice() {
        System.out.print("Enter device ID to turn on: ");
        int id = scanner.nextInt();
        system.turnOnDevice(id);
    }

    private static void turnOffDevice() {
        System.out.print("Enter device ID to turn off: ");
        int id = scanner.nextInt();
        system.turnOffDevice(id);
    }

    private static void setDeviceStatus() {
        System.out.print("Enter device ID to set status: ");
        int id = scanner.nextInt();
        System.out.print("Enter new status (on/off): ");
        String status = scanner.next();
        system.setDeviceStatus(id, status);
    }

    private static void setThermostatTemperature() {
        System.out.print("Enter thermostat ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter new temperature: ");
        int temperature = scanner.nextInt();
        Device device = system.getDevice(id);
        if (device instanceof Thermostat) {
            ((Thermostat) device).setTemperature(temperature);
            LOGGER.info("Thermostat " + id + " temperature set to " + temperature);
        } else {
            LOGGER.warning("Device with ID " + id + " is not a thermostat.");
        }
    }

    private static void evaluateTriggers() {
        System.out.print("Enter current temperature: ");
        int temperature = scanner.nextInt();
        system.evaluateTriggers(temperature);
    }

    private static void addSchedule() {
        System.out.print("Enter device ID to schedule: ");
        int id = scanner.nextInt();
        System.out.print("Enter time (HH:mm): ");
        String time = scanner.next();
        System.out.print("Enter command (Turn On/Turn Off): ");
        String command = scanner.next();

        try {
            scheduleManager.addSchedule(id, time, command);
            LOGGER.info("Schedule added: " + id + " at " + time + " with command " + command);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error adding schedule", e);
        }
    }

    private static void addUserProfile() {
        System.out.print("Enter profile name to add: ");
        String profileName = scanner.next();
        userProfileManager.addUserProfile(profileName);
        LOGGER.info("User profile '" + profileName + "' added.");
    }

    private static void setUserProfile() {
        System.out.print("Enter profile name to set: ");
        String profileName = scanner.next();
        try {
            userProfileManager.setUserProfile(profileName);
            LOGGER.info("User profile set to '" + profileName + "'.");
        } catch (IllegalArgumentException e) {
            LOGGER.warning(e.getMessage());
        }
    }
}
