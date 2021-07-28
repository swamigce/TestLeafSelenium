package steps;

import io.cucumber.java.en.Given;

public class SimpleTags {
	
	@Given ("print TC1")
	public void printTC1() {
		System.out.println("TC1");
	}
	
	@Given ("print TC2")
	public void printTC2() {
		System.out.println("TC2");
	}
	
	@Given ("print TC3")
	public void printTC3() {
		System.out.println("TC3");
	}

}
