package ass.kasimyur.cvi3.functional;

import java.util.stream.IntStream;


public class IntroductionFunctional {
	
	public static void main(String[] args) {
		
		// TODO: implement the same functionality as in Introduction.java but with Java 8 streams
		IntStream.range(0, 20)
		.boxed()
		.forEach(System.out::println);
	}
	
}
