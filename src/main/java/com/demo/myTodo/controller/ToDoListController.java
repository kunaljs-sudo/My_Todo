package com.demo.myTodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.myTodo.dto.ToDo;
import com.demo.myTodo.exception.MyToDoException;
import com.demo.myTodo.exchanges.PostTodoRequest;
import com.demo.myTodo.exchanges.UpdateTodoRequest;
import com.demo.myTodo.services.TodoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ToDoListController.MYTODO_API)
@Slf4j
public class ToDoListController {
    public static final String MYTODO_API = "/myTodoApp";

    @Autowired
    private TodoService todoService;

    @GetMapping("/getMyTodos")
    @Cacheable(value = "allTodosCache", key = "'allTodos'")
    public List<ToDo> getMyTodos() {
        log.info("Requested for all ToDos");
        List<ToDo> getAllTodoResponse;
        getAllTodoResponse = todoService.getMyTodos();
        return getAllTodoResponse;
    }

    @GetMapping("/getMyTodo")
    @Cacheable(value = "todo", key = "#todoId")
    public ToDo getMyTodo(String todoId) {
        if (todoId == null || todoId.isEmpty()) {
            log.error("EmptyId given id: " + todoId);
            throw new MyToDoException("EMPTY_ID", "ID Provided is Empty" + todoId);
        }
        ToDo getTodoResponse;
        getTodoResponse = todoService.getMyTodo(todoId);

        return getTodoResponse;
    }

    @PostMapping("/saveMyTodo")
    @CachePut(value = "todo", key = "#result.getId()")
    @CacheEvict(value = "allTodosCache", key = "'allTodos'")
    public ToDo submitMyToDo(@RequestBody PostTodoRequest postTodoRequest) {
        if (postTodoRequest == null) {
            log.error("Null RequestBody", MyToDoException.class);
            throw new MyToDoException("NULL_REQUEST_BODY", "Reuqest Body received is null");
        }
        if (postTodoRequest.getTitle() == null || postTodoRequest.getTitle().isEmpty()) {
            log.error("Empty Title Given tile: " + postTodoRequest.getTitle());
            throw new MyToDoException("EMPTY_TITLE", "Title cannot be empty.");
        }

        ToDo postTodoResponse = todoService.createMyTodo(postTodoRequest);

        return postTodoResponse;

    }

    @PutMapping("/updateMyTodo")
    @CachePut(value = "todo", key = "#todoId")
    @CacheEvict(value = "allTodosCache", key = "'allTodos'")
    public ToDo updateMyToDo(String todoId,
            @RequestBody UpdateTodoRequest updateTodoRequest) {

        if (todoId == null || todoId.isEmpty()) {
            throw new MyToDoException("BAD_ID_GIVEN", "ID provided is either empty or null.");
        }

        try {
            todoService.getMyTodo(todoId);
        } catch (MyToDoException ex) {
            throw new MyToDoException("ID_NOT_PRESENT", ex.getMessage());
        }

        ToDo updateTodoResponse = todoService.updateMyTodo(todoId, updateTodoRequest);

        return updateTodoResponse;

    }

    @DeleteMapping("/deleteMyTodo")
    @CacheEvict(value = "todo", key = "#todoId")
    public String deleteMyToDo(String todoId) {
        String response = todoService.deleteMyTodo(todoId);
        return response;
    }

}
