package com.demo.myTodo.exchanges;

import com.demo.myTodo.dto.ToDo;

public class PostTodoResponse {
    private ToDo todo;

    public PostTodoResponse() {
    }

    public PostTodoResponse(ToDo todo) {
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
        return "PostTodoResponse [todo=" + todo + "]";
    }

}
