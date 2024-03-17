package com.demo.myTodo.exchanges;

import java.util.List;

import com.demo.myTodo.dto.ToDo;

public class GetAllTodoResponse {
    private List<ToDo> todos;

    public GetAllTodoResponse() {
    }

    public GetAllTodoResponse(List<ToDo> todos) {
        this.todos = todos;
    }

    public List<ToDo> getTodo() {
        return todos;
    }

    public void setTodo(List<ToDo> todos) {
        this.todos = todos;
    }

    @Override
    public String toString() {
        return "GetTodoResponse [todo=" + todos + "]";
    }
}
