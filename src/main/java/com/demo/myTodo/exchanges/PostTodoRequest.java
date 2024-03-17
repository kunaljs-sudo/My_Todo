package com.demo.myTodo.exchanges;

import java.time.LocalDateTime;

public class PostTodoRequest {

    private String title;

    private String description;

    private LocalDateTime localDateTime;

    public PostTodoRequest(String title, String description, LocalDateTime localDateTime) {
        this.title = title;
        this.description = description;
        this.localDateTime = localDateTime;
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
        return "PostTodoRequest [title=" + title + ", description=" + description + ", localDateTime="
                + localDateTime + "]";
    }

}
