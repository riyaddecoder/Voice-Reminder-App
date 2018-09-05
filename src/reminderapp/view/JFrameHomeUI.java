package reminderapp.view;

import reminderapp.service.TrayClass;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;
import reminderapp.service.FileLuncher;
import reminderapp.service.SetAlarm;
import reminderapp.service.TimerAlarmStarter;

/**
 * This is the home Frame of the program.
 * Yes this is the root Frame Also.
 * 
 * @author Riyad
 */

public class JFrameHomeUI extends JFrame {
    private int onScreenX,onScreenY;  //To move undecorated frame with mouse dragged
    private TrayClass tray = new TrayClass(this);  //Define the tray
    private int componetsInPanel = 0;    //Define how many components in the panel
    private FileLuncher files = new FileLuncher();   //For file handling
    private final JFrameHomeUI thisFrame = this;  //Saving the memory address of this frame
    private TimerAlarmStarter alarmStarter = new TimerAlarmStarter();
    private boolean isPlaying; //Is audio is playing
    private boolean isShowed = true; //If showed the message on tray icon, its unnessesary to so again and again.
    
    public JFrameHomeUI() {
        initComponents();
        traySettings();
        files.cleaningErrors(); //Cleaning errors/marked files.
        loadProperties(); //Loading properties from files.
        setOnPerfectLocation(); //Setting the form to middle of the screen
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUI = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();
        jLabelTitleText = new javax.swing.JLabel();
        jButtonAddAReminder = new javax.swing.JButton();
        jScrollPaneReminderList = new javax.swing.JScrollPane();
        jPanelAllReminders = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelUI.setBackground(new java.awt.Color(0, 0, 0));
        jPanelUI.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(204, 204, 204)));
        jPanelUI.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelUIMouseDragged(evt);
            }
        });
        jPanelUI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelUIMousePressed(evt);
            }
        });

        jButtonClose.setBackground(new java.awt.Color(0, 204, 255));
        jButtonClose.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonClose.setForeground(new java.awt.Color(255, 255, 51));
        jButtonClose.setText("x");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonMinimize.setBackground(new java.awt.Color(0, 204, 255));
        jButtonMinimize.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButtonMinimize.setForeground(new java.awt.Color(255, 255, 0));
        jButtonMinimize.setText("-");
        jButtonMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizeActionPerformed(evt);
            }
        });

        jLabelTitleText.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleText.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabelTitleText.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTitleText.setText("VOICE REMINDER");

        jButtonAddAReminder.setText("ADD A REMINDER");
        jButtonAddAReminder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAReminderActionPerformed(evt);
            }
        });

        jScrollPaneReminderList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneReminderList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneReminderList.setPreferredSize(new java.awt.Dimension(419, 463));

        jPanelAllReminders.setBackground(new java.awt.Color(51, 51, 51));
        jPanelAllReminders.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), java.awt.Color.white, new java.awt.Color(204, 204, 204)));
        jPanelAllReminders.setAlignmentX(0.0F);
        jPanelAllReminders.setMaximumSize(new java.awt.Dimension(65535, 65535));
        jPanelAllReminders.setMinimumSize(new java.awt.Dimension(4, 4));
        jPanelAllReminders.setPreferredSize(new java.awt.Dimension(4, 4));
        jPanelAllReminders.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelAllRemindersMouseDragged(evt);
            }
        });
        jPanelAllReminders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelAllRemindersMousePressed(evt);
            }
        });
        jPanelAllReminders.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 1));
        jScrollPaneReminderList.setViewportView(jPanelAllReminders);

        javax.swing.GroupLayout jPanelUILayout = new javax.swing.GroupLayout(jPanelUI);
        jPanelUI.setLayout(jPanelUILayout);
        jPanelUILayout.setHorizontalGroup(
            jPanelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addGroup(jPanelUILayout.createSequentialGroup()
                .addGroup(jPanelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUILayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneReminderList, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddAReminder, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanelUILayout.setVerticalGroup(
            jPanelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUILayout.createSequentialGroup()
                .addGroup(jPanelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonMinimize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddAReminder, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneReminderList, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void setOnPerfectLocation(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);
    }
    
    
    /**
     * This is a set that holds customized panels for showing up.
     * We used set because a set has no duplicate values.
     * Its SortedSet thats why all things gonna sorted automatically.
     */
    public SortedSet<JPanelAlarms> alarms = new java.util.TreeSet<JPanelAlarms>(
            //The Comparator is defined as an anonymous class right here inline
            new Comparator<JPanelAlarms>(){
                @Override
                public int compare(JPanelAlarms o1, JPanelAlarms o2) {
                    return o1.getAlarm().getTime().compareTo(o2.getAlarm().getTime());
                }
            });

    /**
     * This method update the panel that contains reminder panels.
     * We changing size of panel because of flowlayout panel holds things but does not update size
     */
    public void updateAlarmsPanel(){
        this.jPanelAllReminders.removeAll();
        jPanelAllReminders.setPreferredSize(new Dimension(417,60*componetsInPanel));
        jScrollPaneReminderList.setPreferredSize(new Dimension(417,60*componetsInPanel));
        for(JPanelAlarms p : this.alarms){
            this.jPanelAllReminders.add(p);
        }
        this.jPanelAllReminders.repaint();
        this.jPanelAllReminders.revalidate();
    }
    
    /**
     * This method creating a alarm/reminder
     * @param time Time of the reminder
     * @param about About of the reminder
     * @param propertiesPath Full path of the properties file path
     * @param audioPath Full path of the audio file path
     * @param loopTime How many times the audio will playing
     * @return  SetAlarm Object
     */
    public SetAlarm setAlarm(DateTime time, String about,String propertiesPath,String audioPath,int loopTime){
        //call into the alarm starter service to create an Alarm for the given time and path
        final SetAlarm alm = this.alarmStarter.createAlarm(time, about,propertiesPath,audioPath,loopTime);
        
        this.setAlarm(alm);

        return alm;
    }
    
    public SetAlarm setAlarm(final SetAlarm alm){
        //Create a new Panel view to display this alarm
        JPanelAlarms alarmPanel = new JPanelAlarms(thisFrame,alm);
        if(!alm.getTime().isBeforeNow()){
            try {
                //Try to start this alarm
                this.alarmStarter.startAlarm(alm, new Runnable(){
                    @Override
                    public void run() {
                        //When the alarm goes off, run this code
                        onAlarmFinished(alarmPanel, alm);
                    }
                });

            } catch (Exception ex) {
                //Log the error, and set the errorText display
                Logger.getLogger(JFrameHomeUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Can't start alarm: " + ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        
        //Make sure we're listening in case the user clicks the cancel button
        alarmPanel.addCancelAlarmListener(new JPanelAlarms.CancelAlarmListener(){
            @Override
            public void alarmCancelled(JPanelAlarms.CancelAlarmEventObject alarm) {
                //We deleting all resources of this reminder
                JPanelAlarms alarmOb = (JPanelAlarms)alarm.getSource();
                if(alarmOb.getAlarm().isExistAudio){  //If there is audio existing in this reminder.
                    if(isPlaying)       //If audio already playing.
                        files.stopSound(); //We gonna close this audio.
                    try {
                        //Deleting twice Reminder properties also the audio
                        files.deleteFile(alarmOb.getAlarm().getPropertiesPath());
                        files.deleteFile(alarmOb.getAlarm().getAudioPath());
                    } catch (IOException ex) {}
                }
                //remove the alarm from the display
                alarms.remove(alarmOb);
                componetsInPanel--;
                updateAlarmsPanel();
                alarmPanel.removeCancelAlarmListener(this);
                if(!alm.getTime().isBeforeNow()){
                    //cancel the running alarm task
                    alarmStarter.cancelAlarm(alarm.getAlarm());
                }
            }
        });
        //Add the Alarm display panel to our Alarms panel
        this.alarms.add(alarmPanel);
        componetsInPanel++;
        //turn on the new alarm panel
        alarmPanel.setVisible(true);
        //this.updateAlarmsPanel();

        return alm;
    }
    
    
    /**
     * This method gonna called when a alarm goes off.
     */
    private void onAlarmFinished(final JPanelAlarms panel, final SetAlarm alm){
        Thread t = null;
        try {
            //If there is a audio existing file should be played.
            if(alm.isExistAudio){
                isPlaying = true;
                t = new Thread(new Runnable() { 
                    @Override
                    public void run() {
                        for(int i = 0;i<alm.getLoopTime();i++){     //Its the looptime functionality.
                            try {
                                files.playSound(alm.getAudioPath());
                                Thread.sleep(files.Gotmili*100);
                            } catch (IOException ex) {
                                Logger.getLogger(JFrameHomeUI.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(JFrameHomeUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        files.stopSound();
                        isPlaying = false;
                    }
                });
                t.start();
            }
        } catch (Exception ex) {
            //Uh oh!  Log it
            Logger.getLogger(JFrameHomeUI.class.getName()).log(Level.SEVERE, null, ex);

            //Can't guarantee this code is running on the same thread as the EventQueue
            //so we do this invokeLater thing again
            java.awt.EventQueue.invokeLater(new Runnable(){
                @Override
                public void run() {
                    
                }
            });
            return;
        }
        JDialogReminder.showDialog(this, alm);
        
        //If The audio already playing
        if(t!= null && t.isAlive()){
            files.stopSound();
            t.stop();
        }
        try {
            //We deleting all those resources
            files.deleteFile(alm.getAudioPath());
            files.deleteFile(alm.getPropertiesPath());
        } catch (IOException ex) {
            Logger.getLogger(JFrameHomeUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        //Can't guarantee this code is running on the same thread as the EventQueue
        //so we do this invokeLater thing again
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                //Remove the alarm now that it's finished
                alarms.remove(panel);
                updateAlarmsPanel();
            }
        });
    }
    
    /**
     * Loading all those properties from folder.
     */
    private void loadProperties(){
        for(SetAlarm al:files.loadProperties()){
            if(!al.getTime().isBeforeNow()){
                setAlarm(al.getTime(),al.getAbout(),al.getPropertiesPath(),al.getAudioPath(),al.getLoopTime());
            }else{
                setAlarm(al);
            }
        }
        this.updateAlarmsPanel();
    }
    
    /**
     * Setting up tray.
     */
    private void traySettings(){
        TrayClass.trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisFrame.setVisible(true);
                thisFrame.requestFocus();
                if(thisFrame.getExtendedState() == JFrame.ICONIFIED)
                    thisFrame.setExtendedState(JFrame.NORMAL);
            }
        });
    }
    
    private void jPanelUIMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUIMouseDragged
        //To move the undecorated frame/panel with mouse dragged.
        this.setLocation(this.getX()+(evt.getX()-this.onScreenX),this.getY()+(evt.getY()-this.onScreenY));
    }//GEN-LAST:event_jPanelUIMouseDragged

    private void jPanelUIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUIMousePressed
        //To move the undecorated frame/panel with mouse dragged.
        //This Panel will save the clicked mouse position.
        this.onScreenX = evt.getX();
        this.onScreenY = evt.getY();
    }//GEN-LAST:event_jPanelUIMousePressed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        //Hiding when click the 'x' button
        //System.exit(0);
        this.setVisible(false);
        if(isShowed){
            isShowed = false;
            tray.trayIcon.displayMessage("Running!", "Voice Reminder APP Running Here", TrayIcon.MessageType.INFO);
        }
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizeActionPerformed
        //Minimizing when '-' button clicked.
        this.setExtendedState(javax.swing.JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizeActionPerformed

    private void jButtonAddAReminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAReminderActionPerformed
        JFrameNewReminder.newReminder(thisFrame);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAddAReminderActionPerformed

    private void jPanelAllRemindersMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAllRemindersMouseDragged
        //To move the undecorated frame/panel with mouse dragged.
        this.setLocation(this.getX()+(evt.getX()-this.onScreenX),this.getY()+(evt.getY()-this.onScreenY));
    }//GEN-LAST:event_jPanelAllRemindersMouseDragged

    private void jPanelAllRemindersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAllRemindersMousePressed
        //To move the undecorated frame/panel with mouse dragged.
        //This Panel will save the clicked mouse position.
        this.onScreenX = evt.getX();
        this.onScreenY = evt.getY();
    }//GEN-LAST:event_jPanelAllRemindersMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddAReminder;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JLabel jLabelTitleText;
    private javax.swing.JPanel jPanelAllReminders;
    private javax.swing.JPanel jPanelUI;
    private javax.swing.JScrollPane jScrollPaneReminderList;
    // End of variables declaration//GEN-END:variables
}
