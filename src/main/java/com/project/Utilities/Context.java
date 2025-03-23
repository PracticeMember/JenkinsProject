package com.project.Utilities;

import io.cucumber.java.Scenario;

public class Context {

	private  static ThreadLocal<Scenario> scenarioName=new ThreadLocal<Scenario>();
	
	
	public  static synchronized Scenario getScenario() {
		return scenarioName.get();
	}
	
	public  void setScenario(Scenario scenario) {
		scenarioName.set(scenario);
	}
	
	public  void removeScenario() {
		scenarioName.remove();
	}
	
	
}
