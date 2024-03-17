package com.demo.myTodo.services;

import java.util.List;

import com.demo.myTodo.dto.ToDo;
import com.demo.myTodo.exchanges.PostTodoRequest;
import com.demo.myTodo.exchanges.UpdateTodoRequest;

public interface TodoService {
    public List<ToDo> getMyTodos();

    public ToDo getMyTodo(String todoId);

    public ToDo createMyTodo(PostTodoRequest postTodoRequest);

    public ToDo updateMyTodo(String todoId, UpdateTodoRequest updateTodoRequest);

    public String deleteMyTodo(String todoId);
}
