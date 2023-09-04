package demo.engine;

import org.springframework.stereotype.Component;

@Component
public class OffroadEngine implements Engine{

	private final int hp = 160;
    @Override
	public int getHp() {
		return hp;
	}
	
}
