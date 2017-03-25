package ass.kasimyur.cvi3.util;

import java.util.Collection;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Validate;

public final class ThreadsUtil {

	public static boolean isAnyAlive(Collection<Thread> threads) {
		return threads.stream()
		.map(Thread::isAlive)
		.reduce((a,b) -> a || b)
		.orElse(false);
	}
	
	public static void randomDelay(Long minDelay, Long maxDelay) {
		ThreadsUtil.sleep(RandomUtils.nextLong(minDelay, maxDelay));
	}
	
	public static void sleep(Long ms) {
		Validate.exclusiveBetween(0, 10000, ms);
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			/* shush, don't tell anyone! */
		}
	}
	
}
