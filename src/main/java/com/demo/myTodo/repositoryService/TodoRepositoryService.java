package com.demo.myTodo.repositoryService;

import java.util.List;

import com.demo.myTodo.models.ToDoEntity;

public interface TodoRepositoryService {

    public List<ToDoEntity> getMyTodos();

    public ToDoEntity getMyTodo(String todoId);

    public ToDoEntity createMyTodo(ToDoEntity toDoEntity);

    public ToDoEntity updateMyTodo(String todoId, ToDoEntity toDoEntity);

    public String deleteMyTodo(String todoId);

}
