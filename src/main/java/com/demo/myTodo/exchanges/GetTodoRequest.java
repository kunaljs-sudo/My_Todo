package com.demo.myTodo.exchanges;

import com.mongodb.lang.NonNull;

public class GetTodoRequest {
    @NonNull
    private String todoId;

    public GetTodoRequest() {
    }

    public GetTodoRequest(String todoId) {
        this.todoId = todoId;
    }

    public String getId() {
        return todoId;
    }

    public void setId(String todoId) {
        this.todoId = todoId;
    }

}
