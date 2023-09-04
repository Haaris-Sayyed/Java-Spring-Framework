package demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import demo.engine.Engine;
import demo.engine.SportEngine;

@Component
public class SportCar implements Car{
	
	
	
	private Engine engine;

	
	public SportCar(@Qualifier("sportEngine") Engine engine) {
		this.engine = engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public String showEngineHP() {
		return "hp: " + engine.getHp();
	}

}
