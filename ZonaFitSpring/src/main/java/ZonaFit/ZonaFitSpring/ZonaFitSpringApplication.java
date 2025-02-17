package ZonaFit.ZonaFitSpring;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZonaFitSpringApplication {

	private static final Logger logger=
			LoggerFactory.getLogger(ZonaFitSpringApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(ZonaFitSpringApplication.class, args);

	}

}
