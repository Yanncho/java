package fr.epita.assistants.notifyme.notify;

public class ShellNotifier implements INotificationSender {
    boolean parStdErr;
    public ShellNotifier(final boolean parStdErr){
        this.parStdErr = parStdErr;
    }
    @Override
    public void notify(String parSender, String parReceiver, String parMessage) {
        if (this.parStdErr)
            System.err.println("Notification from " + parSender + " to " + parReceiver + " received: " + parMessage);
        else
            System.out.println("Notification from " + parSender + " to " + parReceiver + " received: " + parMessage);
    }
}
