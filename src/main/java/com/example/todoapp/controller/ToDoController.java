package com.example.todoapp.controller;

import com.example.todoapp.DTO.ToDoRequestDTO;
import com.example.todoapp.DTO.ToDoResponseDTO;
import com.example.todoapp.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class ToDoController {

    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public ToDoResponseDTO create(
            @PathVariable String userId,
            @Valid @RequestBody ToDoRequestDTO dto
    ) {
        return service.create(dto, userId);
    }


    @GetMapping("/{userId}")
    public List<ToDoResponseDTO> getAll(@PathVariable String userId) {
        return service.getAll(userId);
    }

    @PutMapping("/{todoId}")
    public ToDoResponseDTO toggleComplete(@PathVariable String todoId) {
        return service.toggleComplete(todoId);
    }

    @DeleteMapping("/{todoId}")
    public String delete(@PathVariable String todoId) {
        service.delete(todoId);
        return "Deleted Successfully";
    }
}
