package com.example.todoapp.service;

import com.example.todoapp.DTO.ToDoRequestDTO;
import com.example.todoapp.DTO.ToDoResponseDTO;
import com.example.todoapp.model.ToDoModel;
import com.example.todoapp.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoResponseDTO create(ToDoRequestDTO dto, String userId) {

        ToDoModel todo = new ToDoModel();
        todo.setTitle(dto.getTitle());
        todo.setCompleted(false);
        todo.setUserId(userId);

        ToDoModel saved = repository.save(todo);

        return new ToDoResponseDTO(
                saved.getId(),
                saved.getTitle(),
                saved.isCompleted()
        );
    }

    public List<ToDoResponseDTO> getAll(String userId) {

        return repository.findByUserId(userId)
                .stream()
                .map(todo -> new ToDoResponseDTO(
                        todo.getId(),
                        todo.getTitle(),
                        todo.isCompleted()
                ))
                .collect(Collectors.toList());
    }

    public ToDoResponseDTO toggleComplete(String todoId) {

        ToDoModel todo = repository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todo.setCompleted(!todo.isCompleted());
        ToDoModel updated = repository.save(todo);

        return new ToDoResponseDTO(
                updated.getId(),
                updated.getTitle(),
                updated.isCompleted()
        );
    }

    public void delete(String todoId) {
        repository.deleteById(todoId);
    }
}
