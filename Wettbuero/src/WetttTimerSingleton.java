import java.util.Timer;

public class WetttTimerSingleton
{
   static Timer timer;

   private WetttTimerSingleton()
   {
   }

   public static Timer getInstance()
   {
      if (timer == null)
      {
         timer = new Timer();
      }
      return timer;
   }
}


