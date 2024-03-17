package com.demo.myTodo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.myTodo.dto.ToDo;
import com.demo.myTodo.exception.MyToDoException;
import com.demo.myTodo.exchanges.PostTodoRequest;
import com.demo.myTodo.exchanges.UpdateTodoRequest;
import com.demo.myTodo.mapper.ToDoConverter;
import com.demo.myTodo.models.ToDoEntity;
import com.demo.myTodo.repositoryService.TodoRepositoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepositoryService todoRepositoryService;

    @Autowired
    private ToDoConverter toDoConverter;

    @Override
    public List<ToDo> getMyTodos() {
        List<ToDoEntity> allTodos = todoRepositoryService.getMyTodos();
        List<ToDo> allTodoDtos = toDoConverter.convertToDtoList(allTodos);
        return allTodoDtos;
    }

    @Override
    public ToDo getMyTodo(String todoId) {
        ToDoEntity toDoEntity = todoRepositoryService.getMyTodo(todoId);
        ToDo todo = toDoConverter.convertToDto(toDoEntity);
        return todo;
    }

    @Override
    public ToDo createMyTodo(PostTodoRequest postTodoRequest) {
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTitle(postTodoRequest.getTitle());
        toDoEntity.setDescription(postTodoRequest.getDescription());
        toDoEntity.setDateTime(
                postTodoRequest.getLocalDateTime() == null ? LocalDateTime.now() : postTodoRequest.getLocalDateTime());

        ToDoEntity new_toDoEntity = todoRepositoryService.createMyTodo(toDoEntity);
        ToDo todo = toDoConverter.convertToDto(new_toDoEntity);
        return todo;
    }

    @Override
    public ToDo updateMyTodo(String todoId, UpdateTodoRequest updateTodoRequest) {
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTitle(updateTodoRequest.getTitle());
        toDoEntity.setDescription(updateTodoRequest.getDescription());
        toDoEntity.setDateTime(
                updateTodoRequest.getLocalDateTime() == null ? LocalDateTime.now()
                        : updateTodoRequest.getLocalDateTime());

        if (toDoEntity.getTitle().isEmpty() || toDoEntity.getTitle() == null) {
            log.error("Empty Title Given tile: " + toDoEntity.getTitle());
            throw new MyToDoException("EMPTY_TITLE", "Title cannot be empty.");
        }
        ToDoEntity new_toDoEntity = todoRepositoryService.updateMyTodo(todoId, toDoEntity);
        ToDo todo = toDoConverter.convertToDto(new_toDoEntity);
        return todo;
    }

    @Override
    public String deleteMyTodo(String todoId) {
        return todoRepositoryService.deleteMyTodo(todoId);
    }

}
