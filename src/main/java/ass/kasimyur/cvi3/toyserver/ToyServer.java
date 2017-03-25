package ass.kasimyur.cvi3.toyserver;

import java.io.PrintStream;
import java.util.List;

public class ToyServer {

	protected SlowDatabase db = new SlowDatabase();
	
	public static void main(String[] args) {
		ToyServer server = new ToyServer();
		
		server.renderPage("user1", System.out);
		server.renderPage("user2", System.out);
	}
	
	public void renderPage(final String username, final PrintStream usersStream) {
		User user = db.findUser(username);
		List<Movie> movies = db.findFavouriteMoviesForUser(user);
		movies.stream().forEach(usersStream::println);
	}
	
}
