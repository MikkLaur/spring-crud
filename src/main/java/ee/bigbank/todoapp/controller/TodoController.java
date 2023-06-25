package ee.bigbank.todoapp.controller;

import ee.bigbank.todoapp.entity.Todo;
import ee.bigbank.todoapp.repository.TodoRepository;
import ee.bigbank.todoapp.request.AddTodoRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Get one
    @GetMapping("/{todoId}")
    public Todo getTodoById(@PathVariable Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(NoSuchElementException::new);
    }

    // Get all
    @GetMapping("")
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    // Add 1
    @PostMapping("")
    public Todo addTodo(@RequestBody AddTodoRequest todoRequest) {
        Todo todo = new Todo();
        todo.setSummary(todoRequest.getSummary());
        return todoRepository.save(todo);
    }

    // Edit 1
    @PatchMapping("/{todoId}/edit")
    public Todo editTodoSummary(@PathVariable Long todoId, @RequestBody AddTodoRequest todoRequest) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(NoSuchElementException::new);
        todo.setSummary(todoRequest.getSummary());
        return todoRepository.save(todo);
    }

    // Check todo
    @PatchMapping("/{todoId}/toggle")
    public Todo toggleTodoCompleted(@PathVariable Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(NoSuchElementException::new);
        todo.setCompleted(!todo.getCompleted());
        return todoRepository.save(todo);
    }
    // Delete 1
    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        todoRepository.deleteById(todoId);
    }
    // Delete all
    @DeleteMapping("")
    public void deleteAllTodo(@PathVariable Long todoId) {
        todoRepository.deleteAll();
    }
}
