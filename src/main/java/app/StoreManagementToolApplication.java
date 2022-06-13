package app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreManagementToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreManagementToolApplication.class, args);
		System.out.println("GLO");
		
//        SpringApplication app = new SpringApplication(StoreManagementToolApplication.class);
//        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
//        app.run(args);
	}

}
