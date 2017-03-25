package ass.kasimyur.cvi3.toyserver;

import java.io.PrintStream;

public class UserRequest {
	
	protected String username;
	protected PrintStream responseStream;
	
	public UserRequest(String username, PrintStream responseStream) {
		super();
		this.username = username;
		this.responseStream = responseStream;
	}

	public String getUsername() {
		return username;
	}

	public PrintStream getResponseStream() {
		return responseStream;
	}
	
}
