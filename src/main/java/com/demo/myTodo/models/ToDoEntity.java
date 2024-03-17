package com.demo.myTodo.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class ToDoEntity {

    @Id
    private String id;

    private String title;

    private String description;

    private LocalDateTime dateTime;

    public ToDoEntity() {
    }

    public ToDoEntity(String id, String title, String description, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "ToDo [id=" + id + ", title=" + title + ", description=" + description + ", dateTime=" + dateTime
                + "]";

    }
}
