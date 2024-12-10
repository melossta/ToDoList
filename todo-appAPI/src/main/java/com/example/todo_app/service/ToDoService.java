package com.example.todo_app.service;

import com.example.todo_app.model.ToDo;
import com.example.todo_app.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public List<ToDo> getAllToDos() {
        return repository.findAll();
    }

    public ToDo createToDo(String task) {
        ToDo toDo = new ToDo();
        toDo.setTask(task);
        toDo.setCompleted(false);
        toDo.setCreatedDate(LocalDateTime.now());
        return repository.save(toDo);
    }

    public ToDo updateToDo(Long id, boolean completed) {
        ToDo toDo = repository.findById(id).orElseThrow();
        toDo.setCompleted(completed);
        return repository.save(toDo);
    }

    public void deleteToDoById(Long id) {
        repository.deleteById(id);
    }
}
