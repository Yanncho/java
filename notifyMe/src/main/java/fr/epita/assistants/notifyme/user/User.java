package fr.epita.assistants.notifyme.user;

import fr.epita.assistants.notifyme.notify.INotificationSender;

import java.util.ArrayList;
import java.util.List;
import fr.epita.assistants.notifyme.notify.ShellNotifier;
public class User implements IMultiNotificationSender{
    public List<INotificationSender> parNotificationList;
    public String username;
    public User(final String username, final List<INotificationSender> parNotificationList){
        this.parNotificationList = parNotificationList;
        this.username = username;
    }
    public User(final String username){
        this.username = username;
        this.parNotificationList = new ArrayList<>();
    }
    public String getUsername(){
        return username;
    }
    @Override
    public void sendNotifications(String parRecipient, String parMessage) {
    for (INotificationSender sender : parNotificationList) {
            sender.notify(username, parRecipient, parMessage);
        }
    }

    @Override
    public void addNotifier(INotificationSender parNotifier) {
        parNotificationList.add(parNotifier);
    }

    @Override
    public List<INotificationSender> getNotifiers() {
        return parNotificationList;
    }
}
