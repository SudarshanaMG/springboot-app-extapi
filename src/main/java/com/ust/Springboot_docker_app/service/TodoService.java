package com.ust.Springboot_docker_app.service;




import com.ust.Springboot_docker_app.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TodoService {
    private final RestTemplate restTemplate;

    public TodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Todo> getTodos() {
        String url = "http://localhost:8080/api/todos/";
        try {
            Todo[] todos = restTemplate.getForObject(url, Todo[].class);
            assert todos != null;
            return Arrays.asList(todos);
        } catch (RestClientException e) {
            System.err.println("Failed to fetch todos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Todo getTodoById(int id) {
        String url = "http://localhost:8080/api/todos/" + id;
        try {
            return restTemplate.getForObject(url, Todo.class);
        } catch (RestClientException e) {
            System.err.println("Failed to fetch todo with ID " + id + ": " + e.getMessage());
            return null;
        }
    }
}

