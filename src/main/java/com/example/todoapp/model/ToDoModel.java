package com.example.todoapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoModel {

    @Id
    private String id;   // Auto generated

    private String title;
    private boolean completed;

    private String userId;
}
