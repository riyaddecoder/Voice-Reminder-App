package reminderapp.service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/** 
 * This class is created for easily accessing files with branch of methods.
 * 
 * @author Riyad
 */


public class FileLuncher {
    
    public String recordingPath;
    public long Gotmili = 0;
    public final String directoryPath = "C:/VoiceReminderFiles/";
    private AudioInputStream audioInputStream;
    private Clip clip;
    private final AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    private TargetDataLine line;
    private File recordedFile;
    private File playedFile;
    private FileWriter fileWriter;
    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MMM/yyyy hh:mm a");
    
    public FileLuncher(){
        setFolders();
        recordingPath = setARecordingPath();
    }

    /**
     * To play a sound.
     * @param filePath the full file name with format.Its case sensitive
     * @throws java.io.IOException
     */
    public void playSound(String filePath) throws IOException{
        try {
            playedFile = new File(filePath).getAbsoluteFile();
            audioInputStream = AudioSystem.getAudioInputStream(playedFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            this.Gotmili= clip.getMicrosecondLength()/100000; //Saving the length of millis of the (file/100) for progress bar
            clip.start();
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Creating directory/folders if they are not available.
     */
    private void setFolders(){
        File directory = new File("C:/VoiceReminderFiles");
        if(!directory.exists()){
            directory.mkdir();
        }
        directory = new File(directoryPath + "Alarm Properties");
        if(!directory.exists()){
            directory.mkdir();
        }
        directory = new File(directoryPath + "Alarm Audio");
        if(!directory.exists()){
            directory.mkdir();
        }
        directory = new File(directoryPath + "If Errors");
        if(!directory.exists()){
            directory.mkdir();
        }
    }
    
    
    /**
     * To make a different file name which not available and to be saved.
     * @return A new file name for saving.
     */
    private String setARecordingPath(){
        int i = 0;
        File f = new File(directoryPath+"Alarm Audio/VR0"+i+".vr");
        while(f.exists()){
            ++i;
            f = new File(directoryPath+"Alarm Audio/VR0"+i+".vr");
        }
        return f.getPath();
    }
    
    
    /**
     * Saving properties of a reminder with a file.
     * Because the program could be closed.
     * 
     * @param dateTime The dateTime of a reminder
     * @param about The about of a reminder
     * @param audioPath The audio path of a reminder
     * @param loopTime Loop time of a reminder
     */
    public void saveAlarmProperties(DateTime dateTime,String about,String audioPath,int loopTime){
        try {
            fileWriter  = new FileWriter(directoryPath + "Alarm Properties/" + formatter.parseDateTime(dateTime.toString(formatter)).getMillis() + ".prop");
            fileWriter.write(dateTime.toString(formatter)+"\n");
            fileWriter.write(about+"\n");
            fileWriter.write(formatter.parseDateTime(dateTime.toString(formatter)).getMillis()+".prop\n");
            fileWriter.write(audioPath+"\n");
            fileWriter.write(loopTime+"");
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FileLuncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Loading properties from directory and returning with a array
     * @return A array with size of how many files are available at the directory
     */
    public SetAlarm[] loadProperties(){
        File[] tempFiles = new File(directoryPath + "Alarm Properties/").listFiles();
        SetAlarm alarms[] = new SetAlarm[tempFiles.length];
        FileReader reader;
        String[] data = new String[5];
        int i,j = 0,c;
        char ch;
        for(File f:tempFiles){
            i = 0;
            data[0] = "";
            try {
                reader = new FileReader(f);
                while((c = reader.read()) != -1){
                    ch = (char)c;
                    if(ch == '\n'){
                        data[++i] = "";
                    }else{
                        data[i]+=ch;
                    }
                }
                reader.close();
                DateTime almTime = formatter.parseDateTime(data[0]);
                alarms[j++] = new SetAlarm(almTime, data[1],data[2],data[3],Integer.parseInt(data[4]));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileLuncher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileLuncher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alarms;
    } 
    
    /**
     * To delete a file.
     * @param filePath The full file path with extension.
     * @throws IOException
     */
    public void deleteFile(String filePath) throws IOException{
        try{
            System.out.println(filePath);
            if(!filePath.equals("null"))
                Files.delete(Paths.get(filePath));
        }catch(FileSystemException e){
            //Its beacause of file already running and cannot be deleted.
            //We implementing a little bit trick.
            //We marking the file.The file will be deleted when the program closed and then started.
            playedFile = new File(filePath);
            fileWriter = new FileWriter(directoryPath + "/If Errors/" + playedFile.getName());
            fileWriter.close();
            ErrorCorrection er = new ErrorCorrection(playedFile.getName());
        }catch(Exception e){
            //e.printStackTrace();
        }
    }
    
    /**
     *To stop a played sound
     */
    public void stopSound(){
        playedFile = null;
        clip.stop();
        clip.close();
        try {
            audioInputStream.close(); 
        } catch (IOException ex) {
            Logger.getLogger(FileLuncher.class.getName()).log(Level.SEVERE, null, ex);
        }
        clip = null;
        audioInputStream = null;
    }
    
    private AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,channels, signed, bigEndian);
        return format;
    }
    
    /**
     * Collect marked files and delete them.
     */
    public void cleaningErrors(){
        File arr = new File(directoryPath + "/If Errors/");
        for(File f:arr.listFiles()){
            ErrorCorrection er = new ErrorCorrection(f.getName());
        }
    }
    
    private void start(String recordingPath) {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error Data Recordline Not Supported!!","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing
 
            AudioInputStream ais = new AudioInputStream(line);
            recordedFile = new File(recordingPath);
            
            // start recording
            AudioSystem.write(ais, fileType, recordedFile);
 
        } catch (LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *To start a recording.
     */
    public void startRecording(String recordingPath){
        Thread T = new Thread(new Runnable(){
            @Override
            public void run() {
                start(recordingPath);
            }
        });
        T.start();
    }

    /**
     *To finish the current recording.
     */
    public void finishRecording() {
        line.stop();
        line.close();
    }
}
