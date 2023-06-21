package Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationMain {
    public static void main(String[] args) throws Throwable{
		SpringApplication.run(ApplicationMain.class, args);
	}
}
