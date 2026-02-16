package com.example.todoapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ToDoResponseDTO {

    private String id;
    private String title;
    private boolean completed;
}
