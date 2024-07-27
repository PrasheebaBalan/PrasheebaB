public class DeviceFactory {
    public static Device createDevice(String type, int id, int initialValue) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, initialValue);
            case "door":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}
