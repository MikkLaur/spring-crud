package ee.bigbank.todoapp;

import ee.bigbank.todoapp.entity.Todo;
import ee.bigbank.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoappApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	@Override
	public void run(String... args) {
		createMockData();
		printServerStartingNotifications();
	}

	private void createMockData() {
		todoRepository.save(new Todo("Wash dishes"));
		todoRepository.save(new Todo("Vacuum living room"));
		todoRepository.save(new Todo("Take car to mechanic"));
		todoRepository.save(new Todo("Write an amazing yet simple Todo app for Edvinas!", Boolean.TRUE));
		todoRepository.save(new Todo("Have a successful interview with Edvinas at 10:30!"));
	}

	private void printServerStartingNotifications() {
		System.out.println("###############################################################################");
		System.out.println("Todo API is running and ready to take requests");
		System.out.println("Check Swagger for endpoint documentation https://localhost:8080/swagger-ui.html");
		System.out.println("###############################################################################");
	}
}
