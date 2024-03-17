package com.demo.myTodo.exchanges;

import com.demo.myTodo.dto.ToDo;

public class UpdateTodoResponse {
    private ToDo todo;

    public UpdateTodoResponse() {
    }

    public UpdateTodoResponse(ToDo todo) {
        this.todo = todo;
    }

    public ToDo getTodo() {
        return todo;
    }

    public void setTodo(ToDo todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "UpdateTodoResponse [todo=" + todo + "]";
    }
}
