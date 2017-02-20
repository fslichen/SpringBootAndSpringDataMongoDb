package evolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	AnyService anyService;
	
	@Override
	public void run(String... args) throws Exception {
		anyService.saveAndFindByMongoRepository();
		anyService.saveAndFindByMongoTemplate();
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(new Object[] { Application.class }, args);
	}
}