package reminderapp.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import reminderapp.service.SetAlarm;

/**
 * Panel to show different reminders.
 * @author Riyad
 */
public class JPanelAlarms extends javax.swing.JPanel {
    /**
     * Creates new form JPanelAlarms
     * @param parentFrame Parent frame of this panel
     * @param alm Alarm object for this panel for showing up
     */
    public JPanelAlarms(JFrame parentFrame,SetAlarm alm) {
        initComponents();
        setAlarm(alm);
        settingMouseListener(parentFrame,alm);
        backgroundSetting();
    }
    
    /**
     * This is the Alarm property.  It is a property because it has a
     * Get and a Set method.  Properties are the preferred way to expose
     * fields to outside classes.  If necessary, additional code can be placed
     * inside the Get and Set methods in order to perform validation, tracking,
     * or other tasks when this property is changed.
     */
    private SetAlarm alarm;    
    public SetAlarm getAlarm(){
        return alarm;
    }
    public void setAlarm(SetAlarm alarm){
        this.alarm = alarm;
        
        //Here is an advantage to the Property paradigm.  Whenever any outside
        //class changes the Alarm property we can update the display to match
        //the new values.
        this.Update();
    }
    
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("h:mm a d MMM, yyyy");
    public void Update(){
	this.jLabelAbout.setText(alarm.getAbout());
        this.jLabelDate.setText(alarm.getTime().toString(formatter));
    }
    
    private void settingMouseListener(JFrame parentFrame,SetAlarm alm){       
        //Adding mouse listener for the panel
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                JDialogReminderProperties.showTheDialog(parentFrame,e.getXOnScreen(),e.getYOnScreen(),alm);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                jLabelAbout.setForeground(Color.yellow);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jLabelAbout.setForeground(Color.cyan);
            }
        });
    }

    private void backgroundSetting(){
        //Background of created panel
        JLabel tempbackground = new JLabel(new ImageIcon(getClass().getResource("/reminderapp/images/ButtonBackground.png")));
        tempbackground.setSize(390,65);
        this.add(tempbackground);
    }
    
        /*
     * Below is an instance of the Event paradigm.  In java an Event is when you
     * provide methods to add and remove EventListeners.  EventListeners are
     * (usually anonymous) classes which implement a certain interface that 
     * extends from EventListener.  These classes receive Events, which are
     * methods on the interface.
     */
    /**
     * This interface defines an EventListener which receives the event
     * alarmCancelled.
     */
    public interface CancelAlarmListener extends EventListener
    {
        /**
         * This event is fired whenever the user wishes to cancel an alarm using
         * the Cancel button on the AlarmPanel.
         * @param alarm The alarm to be cancelled
         */
        public void alarmCancelled(CancelAlarmEventObject alarm);
    }
    
    /**
     * This class is the specific event object that gets passed to the event
     * listeners when events are fired.  
     */
    public static class CancelAlarmEventObject extends EventObject{
        private SetAlarm alarm;
        public SetAlarm getAlarm(){
            return this.alarm;
        }
        
        public CancelAlarmEventObject(Object sender, SetAlarm alarm){
            super(sender);
            this.alarm = alarm;
        }
    }
    
    private List<CancelAlarmListener> CancelAlarmListeners = new java.util.ArrayList();
    public void addCancelAlarmListener(CancelAlarmListener l){
        this.CancelAlarmListeners.add(l);
    }
    
    public void removeCancelAlarmListener(CancelAlarmListener l){
        this.CancelAlarmListeners.remove(l);
    }
    
    /**
     * This is a private utility method which fires the alarmCancelled event on
     * all attached CancelAlarmListeners.  It is called from the EventHandler
     * for clicking the Cancel button.
     */
    private void fireAlarmCancelled(){
        //You should always do this in your Fire methods.  This ensures that 
        //if the event handler removes itself as a listener you will not get an
        //exception when you move on to the next listener.
        CancelAlarmListener[] arr = this.CancelAlarmListeners.toArray(new CancelAlarmListener[1]);
        for(CancelAlarmListener l : arr){
            l.alarmCancelled(new CancelAlarmEventObject(this, alarm));
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDate = new javax.swing.JLabel();
        jLabelAbout = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDate.setText("Date");

        jLabelAbout.setBackground(new java.awt.Color(51, 255, 255));
        jLabelAbout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelAbout.setForeground(new java.awt.Color(51, 255, 255));
        jLabelAbout.setText("About");

        jButtonCancel.setBackground(new java.awt.Color(153, 153, 255));
        jButtonCancel.setForeground(new java.awt.Color(255, 0, 0));
        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reminderapp/images/cancel.png"))); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCancel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDate)
                        .addGap(8, 8, 8)
                        .addComponent(jLabelAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.fireAlarmCancelled();
    }//GEN-LAST:event_jButtonCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabelAbout;
    private javax.swing.JLabel jLabelDate;
    // End of variables declaration//GEN-END:variables
}
