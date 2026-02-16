package com.example.todoapp.repository;

import com.example.todoapp.model.ToDoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ToDoRepository extends MongoRepository<ToDoModel, String> {

    List<ToDoModel> findByUserId(String userId);
}
