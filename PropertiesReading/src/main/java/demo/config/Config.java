package demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@ComponentScan(basePackages = "demo")
@PropertySource("classpath:car.properties")
public class Config {	

}
