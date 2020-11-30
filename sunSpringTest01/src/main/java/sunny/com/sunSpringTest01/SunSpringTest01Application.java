package sunny.com.sunSpringTest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
@EnableEurekaClient
public class SunSpringTest01Application {

	public static void main(String[] args) {
		System.out.println("starting application...");
		SpringApplication.run(SunSpringTest01Application.class, args);
	}
}
