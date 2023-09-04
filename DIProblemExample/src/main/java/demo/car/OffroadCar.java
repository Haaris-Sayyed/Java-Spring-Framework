package demo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import demo.engine.Engine;

@Component
public class OffroadCar implements Car{
	
	@Autowired
	@Qualifier("offroadEngine")
	private Engine engine;


	public OffroadCar(Engine engine) {
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
