package demo.engine;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	
	private final int hp = 200;

	public int getHp() {
		return hp;
	}
	

}
