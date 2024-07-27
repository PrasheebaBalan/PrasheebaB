import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserProfileManager {
    private static final Logger LOGGER = Logger.getLogger(UserProfileManager.class.getName());
    private static UserProfileManager instance = new UserProfileManager();
    private Set<String> profiles = new HashSet<>();
    private String currentProfile;

    private UserProfileManager() {}

    public static UserProfileManager getInstance() {
        return instance;
    }

    public void addUserProfile(String profileName) {
        if (profiles.add(profileName)) {
            LOGGER.info("Profile added: " + profileName);
        } else {
            LOGGER.warning("Profile '" + profileName + "' already exists.");
        }
    }

    public void setUserProfile(String profileName) {
        if (profiles.contains(profileName)) {
            currentProfile = profileName;
            LOGGER.info("Profile set to: " + profileName);
        } else {
            throw new IllegalArgumentException("Profile '" + profileName + "' does not exist.");
        }
    }

    public String getCurrentProfile() {
        return currentProfile;
    }
}
