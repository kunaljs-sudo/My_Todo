package com.demo.myTodo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ToDo implements Serializable {

    private String id;
    private String title;
    private String description;
    private LocalDateTime dateTime;

    public ToDo() {
    }

    public ToDo(String id, String title, String description, LocalDateTime dateTime) {
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

}
