package demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.engine.Engine;

@Component
public class Car {
	
	private Engine engine;

//	Without DI
//	public Car() {
//		engine = new Engine();
//	}
	
//	public Car() {
//		
//	}
	
//	With DI
	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public String showEngineHP() {
		return "hp: " + engine.getHp();
	}

}
