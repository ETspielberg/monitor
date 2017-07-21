package unidue.ub.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost")
@SpringBootApplication
@EntityScan("unidue.ub.settings.fachref")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
