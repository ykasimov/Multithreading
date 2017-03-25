package ass.kasimyur.cvi3.toyserver;

public class Movie {
	protected String name;

	public Movie(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return String.format("Movie[%s]", name);
	}
	
}
