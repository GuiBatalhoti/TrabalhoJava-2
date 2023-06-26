package Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the application
 *
 * @author - GuiBatalhoti
 * @author - Gabriel Nozawa
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationMain {
	/**
	 * Main method for the application
	 * @param args
	 * @throws Throwable
	 */
    public static void main(String[] args) throws Throwable{
		SpringApplication.run(ApplicationMain.class, args);
	}
}
