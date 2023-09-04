package demo.engine;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SportEngine implements Engine{
	
	private final int hp = 200;
    @Override
	public int getHp() {
		return hp;
	}
	

}
