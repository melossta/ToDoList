package com.example.todo_app.repository;

import com.example.todo_app.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByCompleted(boolean completed);
}
