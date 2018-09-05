package reminderapp.view;

import reminderapp.service.FileLuncher;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import reminderapp.service.SetAlarm;

/**
 * This the frame that takes a new reminder from user.
 * A completely new reminder that has a time about audio option and lot more things.
 * @author Riyad
 */

public class JFrameNewReminder extends JFrame {
    private int onScreenX,onScreenY;
    private static JFrameNewReminder thisFrame;
    private ErrorMessageTimesOutThread errorMessageTimesOutThread =  new ErrorMessageTimesOutThread("");
    private FileLuncher files = new FileLuncher();
    private boolean isPlaying,isRecorded;
    private PlayingThread playingThread = new PlayingThread();
    private TimingThread timingThread;
    private JFrameHomeUI parentFrame;
    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MMM/yyyy hh:mm a");
    
    public JFrameNewReminder(JFrameHomeUI parentFrame) {
        initComponents();
        this.parentFrame = parentFrame;
        this.setLocation(parentFrame.getLocation()); //Setting same location as parentFrame.
        setThingsFirst();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAudioOption = new javax.swing.ButtonGroup();
        jPanelUI = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jLabelTitleText = new javax.swing.JLabel();
        jLabelTitle2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelAboutHeadline = new javax.swing.JLabel();
        jTextFieldAbout = new javax.swing.JTextField();
        jSpinnerDatePicker = new javax.swing.JSpinner();
        jLabelDateHeadline = new javax.swing.JLabel();
        jPanelAudioOption = new javax.swing.JPanel();
        jRadioButtonNoAudio = new javax.swing.JRadioButton();
        jRadioButtonRecordAReminder = new javax.swing.JRadioButton();
        jButtonPlay = new javax.swing.JButton();
        jProgressBarPlaying = new javax.swing.JProgressBar();
        jToggleButtonRecord = new javax.swing.JToggleButton();
        jLabelRecordingTime = new javax.swing.JLabel();
        jLabelLoopTimeHeadline = new javax.swing.JLabel();
        jButtonDone = new javax.swing.JButton();
        jLabelErrorMessage = new javax.swing.JLabel();
        jComboBoxLoopTime = new javax.swing.JComboBox();
        jLabelTimeHeadline1 = new javax.swing.JLabel();
        jSpinnerTimePicker = new javax.swing.JSpinner();

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

        jLabelTitleText.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitleText.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        jLabelTitleText.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTitleText.setText("VOICE REMINDER");

        jLabelTitle2.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabelTitle2.setForeground(new java.awt.Color(51, 255, 0));
        jLabelTitle2.setText("New Reminder Option");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204), new java.awt.Color(255, 255, 255), new java.awt.Color(204, 204, 204)));

        jLabelAboutHeadline.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelAboutHeadline.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAboutHeadline.setText("Reminder About:");

        jTextFieldAbout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jSpinnerDatePicker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinnerDatePicker.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerDatePicker.setAutoscrolls(true);
        jSpinnerDatePicker.setDoubleBuffered(true);
        jSpinnerDatePicker.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerDatePicker, "dd/MMM/yyyy"));

        jLabelDateHeadline.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelDateHeadline.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDateHeadline.setText("Date:");

        jPanelAudioOption.setBackground(new java.awt.Color(51, 51, 51));
        jPanelAudioOption.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Audio Option", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(102, 255, 255))); // NOI18N
        jPanelAudioOption.setForeground(new java.awt.Color(255, 255, 255));

        jRadioButtonNoAudio.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroupAudioOption.add(jRadioButtonNoAudio);
        jRadioButtonNoAudio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonNoAudio.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNoAudio.setSelected(true);
        jRadioButtonNoAudio.setText("No Audio");
        jRadioButtonNoAudio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonNoAudioItemStateChanged(evt);
            }
        });

        jRadioButtonRecordAReminder.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroupAudioOption.add(jRadioButtonRecordAReminder);
        jRadioButtonRecordAReminder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonRecordAReminder.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonRecordAReminder.setText("Record A Reminder");
        jRadioButtonRecordAReminder.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonRecordAReminderItemStateChanged(evt);
            }
        });

        jButtonPlay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPlay.setText("Play");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jProgressBarPlaying.setForeground(new java.awt.Color(51, 255, 51));

        jToggleButtonRecord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButtonRecord.setText("Record");
        jToggleButtonRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRecordActionPerformed(evt);
            }
        });

        jLabelRecordingTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelRecordingTime.setForeground(new java.awt.Color(51, 255, 51));
        jLabelRecordingTime.setText("00:00");

        javax.swing.GroupLayout jPanelAudioOptionLayout = new javax.swing.GroupLayout(jPanelAudioOption);
        jPanelAudioOption.setLayout(jPanelAudioOptionLayout);
        jPanelAudioOptionLayout.setHorizontalGroup(
            jPanelAudioOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAudioOptionLayout.createSequentialGroup()
                .addGroup(jPanelAudioOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAudioOptionLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanelAudioOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonRecordAReminder)
                            .addComponent(jRadioButtonNoAudio)))
                    .addGroup(jPanelAudioOptionLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanelAudioOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAudioOptionLayout.createSequentialGroup()
                                .addComponent(jProgressBarPlaying, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRecordingTime))
                            .addGroup(jPanelAudioOptionLayout.createSequentialGroup()
                                .addComponent(jToggleButtonRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanelAudioOptionLayout.setVerticalGroup(
            jPanelAudioOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAudioOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonNoAudio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonRecordAReminder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAudioOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAudioOptionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButtonRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAudioOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarPlaying, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRecordingTime))
                .addGap(80, 80, 80))
        );

        jLabelLoopTimeHeadline.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelLoopTimeHeadline.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoopTimeHeadline.setText("Loop Time:");

        jButtonDone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonDone.setText("Done");
        jButtonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoneActionPerformed(evt);
            }
        });

        jLabelErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelErrorMessage.setForeground(new java.awt.Color(0, 255, 255));

        jComboBoxLoopTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxLoopTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabelTimeHeadline1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelTimeHeadline1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTimeHeadline1.setText("Time:");

        jSpinnerTimePicker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinnerTimePicker.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jSpinnerTimePicker.setAutoscrolls(true);
        jSpinnerTimePicker.setDoubleBuffered(true);
        jSpinnerTimePicker.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerTimePicker, "hh:mm a"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelAudioOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAboutHeadline)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAbout))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDateHeadline)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTimeHeadline1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 234, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelLoopTimeHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxLoopTime, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDone, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAboutHeadline)
                    .addComponent(jTextFieldAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDateHeadline)
                    .addComponent(jSpinnerDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTimeHeadline1)
                    .addComponent(jSpinnerTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAudioOption, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxLoopTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLoopTimeHeadline))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDone, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabelErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelUILayout = new javax.swing.GroupLayout(jPanelUI);
        jPanelUI.setLayout(jPanelUILayout);
        jPanelUILayout.setHorizontalGroup(
            jPanelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUILayout.createSequentialGroup()
                .addGroup(jPanelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelUILayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
            .addGroup(jPanelUILayout.createSequentialGroup()
                .addGroup(jPanelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUILayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelUILayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitle2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelUILayout.setVerticalGroup(
            jPanelUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUILayout.createSequentialGroup()
                .addComponent(jButtonClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
       
    private void setThingsFirst(){
        jButtonPlay.setEnabled(false);
        jToggleButtonRecord.setEnabled(false);
        jLabelRecordingTime.setVisible(false);
        jProgressBarPlaying.setVisible(false);
    }
    
    /**
     * Showing a error message that move out automatically after three second.
     * @param message The error message.
     */
    private void setErrorMessage(String message){
        if(!errorMessageTimesOutThread.isAlive()){
            errorMessageTimesOutThread = new ErrorMessageTimesOutThread(message);
            errorMessageTimesOutThread.start();
        }
    }
    private class ErrorMessageTimesOutThread extends Thread{
        private String message;
        public ErrorMessageTimesOutThread(String message) {
            this.message = message;
        }
        @Override
        public void run(){
            jLabelErrorMessage.setText(message);
            jLabelErrorMessage.setVisible(true);
            try{
                sleep(3000);
            }catch(InterruptedException e){}
            jLabelErrorMessage.setVisible(false);
        }
    }
    
    /**
     * To stop the played sound.
     */
    private void stopSound(){
        if(isPlaying){
            isPlaying = false;
            jButtonPlay.setText("Start");
            files.stopSound();
            playingThread.stop();
            this.jProgressBarPlaying.setValue(0);
            jProgressBarPlaying.setVisible(false);
        }
    }
    
    
    /**
     * A Thread that handle the progress bar while playing.
     */
    private class PlayingThread extends Thread{
        @Override
        public void run(){
            for(int i = 0;i<=100;i++){
                try {
                    Thread.sleep(files.Gotmili);
                } catch (InterruptedException ex) {}
                jProgressBarPlaying.setValue(i);
            }
            jProgressBarPlaying.setValue(0);
            isPlaying = false;
            jButtonPlay.setText("Start");
            jProgressBarPlaying.setVisible(false);
        }
    }
    
    
    /**
     * A Thread that handle the timing option when recording.
     */
    private class TimingThread extends Thread{
        @Override
        public void run(){
            int sec = 0,min = 0;
            while(true){
                jLabelRecordingTime.setText(String.format("%02d:%02d",min,sec));
                sec++;
                if(sec == 60){
                    min++;
                    sec = 0;
                }
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {}
            }
        }
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
        //We closing this window
        //When a record started its gonna create a file.
        //We should delete the file because its not be saved.
        //And also we should stop the sound if its playing.
        if(isRecorded){
            if(jToggleButtonRecord.isSelected()){
                files.finishRecording();
            }else if(isPlaying){
                this.stopSound();
            }
            try{
                files.deleteFile(files.recordingPath);
            }catch(IOException e){}
        }
        this.dispose();
        parentFrame.setVisible(true);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jRadioButtonNoAudioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonNoAudioItemStateChanged
        //Things to change when radio button state changed.
        if(jRadioButtonNoAudio.isSelected()){
            stopSound();
            jButtonPlay.setEnabled(false);
            jToggleButtonRecord.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButtonNoAudioItemStateChanged

    private void jRadioButtonRecordAReminderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonRecordAReminderItemStateChanged
        //Things to change when radio button state changed.
        if(jRadioButtonRecordAReminder.isSelected()){
            stopSound();
            jButtonPlay.setEnabled(isRecorded);
            jToggleButtonRecord.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButtonRecordAReminderItemStateChanged

    private void jButtonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoneActionPerformed
        //There we go
        //Its not possible to save reminder with no text.
        //If recording/playing they should be stopped before saving the reminder.
        try{
            if(jTextFieldAbout.getText().isEmpty()){
                setErrorMessage("About textfield cannot be blank.");
            }else if(jRadioButtonRecordAReminder.isSelected() && !isRecorded){
                setErrorMessage("There is no record available.");
            }else{
                if(jToggleButtonRecord.isSelected())
                    files.finishRecording();
                if(isPlaying)
                    files.stopSound();
                
                //Taking things to save
                int loopTime = Integer.parseInt(jComboBoxLoopTime.getSelectedItem().toString());
                DateTime date = new DateTime(jSpinnerDatePicker.getValue());
                DateTime time = new DateTime(jSpinnerTimePicker.getValue());
                
                //Parsing values from two jspinner into one.
                DateTime almTime = formatter.parseDateTime(date.toString(DateTimeFormat.forPattern("dd/MMM/yyyy")) + time.toString(DateTimeFormat.forPattern(" hh:mm a")));
                
                
                //---------------------------- Reminder Time Validation ---------------------
                if(almTime.isBeforeNow()){
                    setErrorMessage("Cannot schedule current/before time.");
                    jSpinnerDatePicker.requestFocus();
                    return;
                }else{
                    long millis = almTime.getMillis() - System.currentTimeMillis();
                    if(millis > SetAlarm.MAX_FUTURE_SCHEDULING_MILLIS){
                        setErrorMessage("Its too long term to schedule.");
                        return;
                    }
                }
                for(Object ob:this.parentFrame.alarms.toArray()){
                    if(almTime.equals(((JPanelAlarms)ob).getAlarm().getTime())){
                        setErrorMessage("The time already scheduled!!!");
                        jSpinnerDatePicker.requestFocus();
                        return;
                    }
                }
                //------------------ End of reminder time validation ----------------------
                
                
                if(this.jRadioButtonNoAudio.isSelected()){
                    //If audio path not needs to be saved.
                    if(isRecorded)
                        files.deleteFile(files.recordingPath);
                    this.parentFrame.setAlarm(almTime,jTextFieldAbout.getText(),"C:/VoiceReminderFiles/Alarm Properties/"+formatter.parseDateTime(almTime.toString(formatter)).getMillis()+".prop",null,loopTime);
                    files.saveAlarmProperties(almTime,jTextFieldAbout.getText(),"null",loopTime);
                }else{
                    //If audio path needs to be saved.
                    this.parentFrame.setAlarm(almTime,jTextFieldAbout.getText(),"C:/VoiceReminderFiles/Alarm Properties/"+formatter.parseDateTime(almTime.toString(formatter)).getMillis()+".prop",files.recordingPath,loopTime);
                    files.saveAlarmProperties(almTime,jTextFieldAbout.getText(),files.recordingPath,loopTime);
                }
                this.parentFrame.updateAlarmsPanel();
                this.parentFrame.setVisible(true);
                this.dispose();
            }
        }catch(NumberFormatException e){
            setErrorMessage("Loop time should be a integer.");
        } catch (IOException ex) {
            Logger.getLogger(JFrameNewReminder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDoneActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        //There we playing the sounds if play button clicked.
        if(isPlaying){
            stopSound();
        }else{
            isPlaying = true;
            jButtonPlay.setText("Stop");
            try {
                files.playSound(files.recordingPath);
            } catch (IOException ex) {
                Logger.getLogger(JFrameNewReminder.class.getName()).log(Level.SEVERE, null, ex);
            }
            playingThread = new PlayingThread();
            jProgressBarPlaying.setVisible(true);
            playingThread.start();
        }
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jToggleButtonRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRecordActionPerformed
        if(this.jToggleButtonRecord.isSelected()){
            stopSound();
            isRecorded = true;
            files.startRecording(files.recordingPath);
            jButtonPlay.setEnabled(false);
            timingThread = new TimingThread();
            timingThread.start();
            jLabelRecordingTime.setVisible(true);
        }else{
            files.finishRecording();
            jButtonPlay.setEnabled(true);
            timingThread.stop();
            jLabelRecordingTime.setVisible(false);
        }
    }//GEN-LAST:event_jToggleButtonRecordActionPerformed

    public static void newReminder(JFrameHomeUI parentFrame) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameNewReminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameNewReminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameNewReminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameNewReminder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                thisFrame = new JFrameNewReminder(parentFrame);
                thisFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupAudioOption;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDone;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JComboBox jComboBoxLoopTime;
    private javax.swing.JLabel jLabelAboutHeadline;
    private javax.swing.JLabel jLabelDateHeadline;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JLabel jLabelLoopTimeHeadline;
    private javax.swing.JLabel jLabelRecordingTime;
    private javax.swing.JLabel jLabelTimeHeadline1;
    private javax.swing.JLabel jLabelTitle2;
    private javax.swing.JLabel jLabelTitleText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAudioOption;
    private javax.swing.JPanel jPanelUI;
    private javax.swing.JProgressBar jProgressBarPlaying;
    private javax.swing.JRadioButton jRadioButtonNoAudio;
    private javax.swing.JRadioButton jRadioButtonRecordAReminder;
    private javax.swing.JSpinner jSpinnerDatePicker;
    private javax.swing.JSpinner jSpinnerTimePicker;
    private javax.swing.JTextField jTextFieldAbout;
    private javax.swing.JToggleButton jToggleButtonRecord;
    // End of variables declaration//GEN-END:variables
}
