package reminderapp.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is created for reduce exception due to file processing system.
 * When a alarm created its saves a audio file.
 * Somehow the file cannot be deleted because of its processing.
 * I'm gonna trying to delete it with different thread.
 * If its not, a thread will try to delete it 3 times in 30 seconds.
 * 
 * @author Riyad
 */
public class ErrorCorrection extends Thread{
    
    private String fileName;
    private String filePath;
    private Thread thread;
    
    /**
     * To reduce error of file processing system.
     * @param fileName is the file name need to be deleted(With extension)
     */
    public ErrorCorrection(String fileName){
        this.fileName = fileName;
        
        //Getting the file extension because different types of files are different places.
        if(getFileExtension(fileName).equals("vr"))
            this.filePath = "C:/VoiceReminderFiles/Alarm Audio/";
        else
            this.filePath = "C:/VoiceReminderFiles/Alarm Properties/";
        
        setTheThread();
        thread.start();
    }
    
    private String getFileExtension(String fileName){
        File f = new File("C:/VoiceReminderFiles/If Errors/"+fileName);
        String name = f.getName();
        try{
            return name.substring(name.lastIndexOf(".")+1);
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    
    private void setTheThread(){
        //This thread will try to delete the file after ten seconds.
        //Because sometime the file processing finished up after few moment. 
        thread = new Thread(new Runnable() {
            @Override
            public void run(){
                for(int i = 0;i<3;i++){
                    try {
                        System.out.printf("Called for the %s\n",fileName);
                        Files.delete(Paths.get(filePath + fileName));
                        Files.delete(Paths.get("C:/VoiceReminderFiles/If Errors/" + fileName));
                        return;
                    }catch(FileSystemException ex){
                        try {
                            sleep(10000);
                        } catch (InterruptedException ex1) {}
                    }
                    catch (IOException ex) {
                    }
                }
            }
        });
    }
    
}
