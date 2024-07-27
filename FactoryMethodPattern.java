
interface Notification {
    void notifyUser();
}


class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an email notification.");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification.");
    }
}


abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void notifyUser() {
        Notification notification = createNotification();
        notification.notifyUser();
    }
}


class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}


public class FactoryMethodPattern {
    public static void main(String[] args) {
        NotificationFactory emailFactory = new EmailNotificationFactory();
        emailFactory.notifyUser();

        NotificationFactory smsFactory = new SMSNotificationFactory();
        smsFactory.notifyUser();
    }
}
