package com.demo.myTodo.exchanges;

import com.mongodb.lang.NonNull;

public class DeleteTodoRequest {

    @NonNull
    private String todoId;

    public DeleteTodoRequest() {
    }

    public DeleteTodoRequest(String todoId) {
        this.todoId = todoId;
    }

    public String getId() {
        return todoId;
    }

    public void setId(String todoId) {
        this.todoId = todoId;
    }

}
