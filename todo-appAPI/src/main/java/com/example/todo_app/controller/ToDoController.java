/*
package com.example.todo_app.controller;

import com.example.todo_app.model.ToDo;
import com.example.todo_app.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        return service.getAllToDos();
    }

    @PostMapping
    public ToDo createToDo(@RequestBody String task) {
        return service.createToDo(task);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestParam boolean completed) {
        return service.updateToDo(id, completed);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoById(@PathVariable Long id) {
        service.deleteToDoById(id);
    }
}
*/
package com.example.todo_app.controller;

import com.example.todo_app.model.ToDo;
import com.example.todo_app.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        return service.getAllToDos();
    }

    @PostMapping
    public ToDo createToDo(@RequestBody String task) {
        return service.createToDo(task);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestParam boolean completed) {
        return service.updateToDo(id, completed);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoById(@PathVariable Long id) {
        service.deleteToDoById(id);
    }
    @GetMapping("/test")
    public String testEndpoint() {
        return "API is working!";
    }

}
