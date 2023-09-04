package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.car.Car;
import demo.config.Config;


public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		Car car = ctx.getBean(Car.class);
		
		System.out.println("Car engine: " + car.showEngineHP());
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
