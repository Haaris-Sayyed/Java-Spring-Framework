package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.car.Car;
import demo.car.OffroadCar;
import demo.car.SportCar;
import demo.config.Config;


public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		Car sportCar = ctx.getBean(SportCar.class);
		Car offroadCar = ctx.getBean(OffroadCar.class);
		
		System.out.println("Car engine: " + sportCar.showEngineHP());
		System.out.println("Car engine: " + offroadCar.showEngineHP());
		
		sportCar.showInfo();
		offroadCar.showInfo();
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
