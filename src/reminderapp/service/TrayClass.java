package reminderapp.service;
import reminderapp.view.JFrameNewReminder;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import reminderapp.view.JFrameHomeUI;

/**
 * This class creates SystemTray for the program
 * 
 * @author Riyad
 */

public class TrayClass{
    public static TrayIcon trayIcon;
    private final MenuItem newReminder = new MenuItem("New Reminder");
    private final MenuItem exit = new MenuItem("Exit");
    private final PopupMenu popUp = new PopupMenu();
    private final JFrameHomeUI mainFrame;
    
    /**
     * System tray will automatically shown when the constructor is called.
     * @param mainFrame its always the home frame because if we clicked the tray icon the home frame will be showed.
     */
    public TrayClass(JFrameHomeUI mainFrame) {
        show();
        this.mainFrame = mainFrame;
    }
    
    private void show(){
        if(!SystemTray.isSupported()){
            //System.exit(0);
        }
        trayIcon = new TrayIcon(createIcon("/reminderapp/images/trayIcon.png","Icon"));
        trayIcon.setToolTip("Voice Reminder APP!");
        
        newReminder.addActionListener((ActionEvent e) -> {
            JFrameNewReminder.newReminder(mainFrame);
        });
        
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        popUp.add(newReminder);
        popUp.add(exit);
        trayIcon.setPopupMenu(popUp);
        
        final SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (Exception e) {
        }
    }
    private Image createIcon(String path,String desc){
        URL imageURL = TrayClass.class.getResource(path);
        return (new ImageIcon(imageURL,desc).getImage());
    }
}
