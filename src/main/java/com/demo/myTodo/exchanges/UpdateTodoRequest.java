package com.demo.myTodo.exchanges;

import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;

public class UpdateTodoRequest {
    @Nonnull
    private String id;

    @Nonnull
    private String title;

    private String description;

    @Nonnull
    private LocalDateTime localDateTime;

    public UpdateTodoRequest() {
    }

    public UpdateTodoRequest(String id, String title, String description, LocalDateTime localDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.localDateTime = localDateTime;
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "UpdateTodoRequest [id=" + id + ", title=" + title + ", description=" + description + ", localDateTime="
                + localDateTime + "]";
    }

}
