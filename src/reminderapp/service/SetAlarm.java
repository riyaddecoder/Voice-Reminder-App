package reminderapp.service;

import org.joda.time.DateTime;

/**
 * This class represents one currently set alarm.  It contains the date and time
 * when the alarm will go off, as well as the path of the program or file
 * to be executed when the alarm goes off.  It will function as the data model
 * for the UI.
 * 
 * This class Is Something.
 * @author Riyad
 */
public class SetAlarm {
    /** Let's say 1 month */
    public static final long MAX_FUTURE_SCHEDULING_MILLIS = 31l * 24l * 60l * 60l * 1000l;
    public boolean isExistAudio;
    
    private final DateTime time;
    public DateTime getTime(){
        return time;
    }
    
    private final String about;
    public String getAbout(){
        return about;
    }
    
    private final String audioPath;
    public String getAudioPath(){
        return audioPath;
    }
    
    private final String propertiesPath;
    public String getPropertiesPath(){
        return propertiesPath;
    }
    
    private final int loopTime;
    public int getLoopTime(){
        return loopTime;
    }
    
    public SetAlarm(DateTime time, String about,String propertiesPath,String audioPath, int loopTime){
        this.time = time;
        this.about = about;
        this.audioPath = audioPath;
        this.loopTime = loopTime;
        this.propertiesPath = propertiesPath;
        if(audioPath!=null)
            isExistAudio = true;
    }

    /*
     * Since this class Is Something, that is it represents some data 
     * (namely the exact Time and executable path of a currently set alarm),
     * it should override the equals and getHashCode methods.  
     * Normally an object is only equal to another object if they are the exact
     * same instance.  Here we are overriding that to say that two Favorites are
     * equal if they have the same time and the same path, even if they
     * are two different instances.
     * 
     * Whenever you override the equals method you MUST also override the
     * getHashCode method.  Netbeans will generate this code automatically
     * for you if you hit alt-insert.
     */
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SetAlarm other = (SetAlarm) obj;
        if (this.time != other.time && (this.time == null || !this.time.equals(other.time))) {
            return false;
        }
        return !((this.about == null) ? (other.about != null) : !this.about.equals(other.about));
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.time != null ? this.time.hashCode() : 0);
        hash = 83 * hash + (this.about != null ? this.about.hashCode() : 0);
        return hash;
    }
}
