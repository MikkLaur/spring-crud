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
	public void run(String... args) throws Exception {
		Todo todo = new Todo();
		todo.setSummary("Add a todo item to list");
		todoRepository.save(todo);

		todo = new Todo("summary lol", Boolean.FALSE);
		todoRepository.save(todo);
	}
}
