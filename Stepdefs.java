package io.cucumber.skeleton;

import cucumber.api.java8.En;

public class Stepdefs implements En{
	public Stepdefs(){
		
		Given("I was given {int} cukes in my belly", (Integer int1) -> {
		    
		    System.out.println("............................................");
		});

		When("I when wait {int} hour", (Integer int1) -> {
		    // Write code here that turns the phrase above into concrete actions
		    System.out.println("............................................");
		});

		Then("my then belly should growl", () -> {
		    // Write code here that turns the phrase above into concrete actions
		    System.out.println("............................................");
		});

	
	}
    
}
