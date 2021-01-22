package patterns.structural.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Notifier {

    void sendNotification(String message);
}

class SMSNotification implements Notifier {

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS notification sent : " + message);
    }
}

class LogDecorator implements Notifier {
    Notifier notifier;

    public LogDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public static Notifier loggedNotifier(Notifier notifier) {
        return new LogDecorator(notifier);
    }

    @Override
    public void sendNotification(String message) {
        //Add logging
        System.out.println("This is a log message added");
        //Make call notifier
        notifier.sendNotification(message);

        //Log after?
    }
}


class SendNotifications {

    public static void main(String[] args) {
        List<Notifier> notifiers = new ArrayList<>();
        var synchlist = Collections.synchronizedList(notifiers);

        notifiers.add(LogDecorator.loggedNotifier(new SMSNotification()));

        for (Notifier n : notifiers) {
            n.sendNotification("Don't try this at home");
        }
    }
}



