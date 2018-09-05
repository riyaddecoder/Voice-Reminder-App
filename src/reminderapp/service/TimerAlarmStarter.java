package reminderapp.service;

import java.util.Collections;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.joda.time.DateTime;
/**
 * 
 * @author Riyad
 */
public class TimerAlarmStarter{

    /** This is the timer that actually runs the alarms */
    private Timer timer = new Timer();

    /**
     * This is a collection that simply remembers our currently running timers.
     * It has to be synchronized because it will be modified concurrently by multiple
     * threads, specifically the UI thread and also the timer thread.
     */
    private final Map<SetAlarm, TimerTask> runningTasks = Collections.synchronizedMap(new java.util.HashMap());

    /**
     * This method implements the createAlarm function for the TimerAlarmStarter.
     * It creates and returns a new Alarm for the given time
     * @param alarmDate the Time when the alarm should go off
     * @param reminderAbout is the about of reminder given by a user
     * @param propertiesPath
     * @param audioPath
     * @param loopTime
     * @return a new Alarm object containing that data.
     */
    public SetAlarm createAlarm(DateTime alarmDate, String reminderAbout,String propertiesPath,String audioPath,int loopTime)
    {
        return new SetAlarm(alarmDate, reminderAbout,propertiesPath,audioPath,loopTime);
    }

    /**
     * Starts the given SetAlarm using a timer.
     * @param alarm the alarm to start
     * @param whenFinished A callback task to be executed when the alarm starts
     * @return a new TimerTask which can be used to monitor and cancel the alarm timer
     * @throws Exception if the alarm is not valid or has already been started.
     */
    public TimerTask startAlarm(final SetAlarm alarm, final Runnable whenFinished) throws Exception
    {
        long millis = alarm.getTime().getMillis() - System.currentTimeMillis();
        
        //here we are creating the new TimerTask that will be executed by the timer.
        TimerTask ret = new TimerTask(){
            @Override
            public void run() {
                //run the given task when the timer goes off
                whenFinished.run();

                //and remove it from our remembered tasks
                runningTasks.remove(alarm);
            }

            /**
             * We are overriding cancel here so we can make sure it gets
             * removed from our runningTasks list.
             */
            @Override
            public boolean cancel(){
                //call into the base class' cancel() implementation
                boolean ret = super.cancel();

                runningTasks.remove(alarm);

                return ret;
            }
        };

        //Remember the task for later in case we need to cancel
        runningTasks.put(alarm, ret);

        //We are now scheduling the task in the timer.  The timer runs in a separate
        //thread and will execute the run() method of the timer task when the
        //given date in millis is reached.
        timer.schedule(ret, millis);

        return ret;
    }


    /**
     * Cancels a given alarm that has already been started
     * @param alarm the currently running alarm
     * @return true if the alarm could be canceled, false otherwise.
     */
    public boolean cancelAlarm(SetAlarm alarm){
        //We pull the TimerTask object out of our map of tasks that we remember.
        TimerTask task = runningTasks.get(alarm);
        if (task == null)
            return false;

        //try to cancel it
        boolean cancelled = task.cancel();

        if(cancelled)
            runningTasks.remove(alarm);

        return cancelled;
    }

}
