package kr.cse.gt.scheduler;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public abstract class ProgrammableScheduler {
	@Autowired
	private ThreadPoolTaskScheduler scheduler;

	private ScheduledFuture<?> scheuledFuture;

	public void stopScheduler() {
		if (scheuledFuture != null) {
			scheuledFuture.cancel(true);
		}
	}

	public void startScheduler(String email) {
		scheuledFuture = scheduler.schedule(getRunnable(email), getTrigger());
	}

	private Runnable getRunnable(String email) {
		return new Runnable() {
			@Override
			public void run() {
				runner(email);
			}
		};
	}

	public abstract void runner(String email);

	public abstract Trigger getTrigger();

}
