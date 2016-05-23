package Control;
import java.util.Timer;
import java.util.TimerTask;

public class WettTimerSingleton 
{
    protected static WettTimerSingleton inst;

    public static synchronized WettTimerSingleton getInstance() 
    {
        if (inst == null)
        {
            inst = new WettTimerSingleton();
        }
        return inst;
    }

    // -------------------------
    protected Timer t;

    public WettTimerSingleton() 
    {
        t = new Timer("TimerSingleton Timer",true);
    }

    public void schedule(TimerTask tt, long delay, long interval) 
    {
        t.schedule(tt, delay, interval);
    }

    public void killTimer() 
    {
        t.cancel();
        t.purge();
        t = null;
        inst = null;
    }
}
