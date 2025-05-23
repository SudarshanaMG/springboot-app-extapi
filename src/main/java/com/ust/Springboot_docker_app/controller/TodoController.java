package com.ust.Springboot_docker_app.controller;
import com.ust.Springboot_docker_app.model.Todo;
import com.ust.Springboot_docker_app.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<Todo> getTodos() {
        return todoService.getTodos();
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return new Todo();
    }
}

