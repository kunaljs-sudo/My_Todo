package com.demo.myTodo.exchanges;

import com.demo.myTodo.dto.ToDo;

public class GetTodoResponse {
    private ToDo todo;

    public GetTodoResponse() {
    }

    public GetTodoResponse(ToDo todo) {
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
        return "GetTodoResponse [todo=" + todo + "]";
    }

}
