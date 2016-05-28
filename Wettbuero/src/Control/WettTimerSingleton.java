package Control;

import java.util.Timer;
import java.util.TimerTask;

public class WettTimerSingleton extends Timer {
	private static final class InstanceHolder {
		static final WettTimerSingleton INSTANCE = new WettTimerSingleton();
	}

	WettTimerSingleton() {
	}

	public static WettTimerSingleton getInstance() {
		return InstanceHolder.INSTANCE;
	}
}
