package ass.kasimyur.cvi3.toyserver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ass.kasimyur.cvi3.util.ThreadsUtil;
import org.apache.commons.lang3.RandomStringUtils;

public class SlowDatabase {
	
	public User findUser(String username) {
		ThreadsUtil.sleep(1000L);
		return new User(username);
	}
	
	public List<Movie> findFavouriteMoviesForUser(User user) {
		ThreadsUtil.sleep(1000L);
		return IntStream.range(0, 3).boxed()
		.map(i -> new Movie(RandomStringUtils.randomAlphabetic(10)))
		.collect(Collectors.toList());
	}
	
	
}
