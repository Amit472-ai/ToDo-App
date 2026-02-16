package com.example.todoapp.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    private String title;
}
