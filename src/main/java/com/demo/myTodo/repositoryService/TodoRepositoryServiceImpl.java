package com.demo.myTodo.repositoryService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.myTodo.exception.MyToDoException;
import com.demo.myTodo.models.ToDoEntity;
import com.demo.myTodo.repository.TodoRepository;

@Service
@SuppressWarnings("null")
public class TodoRepositoryServiceImpl implements TodoRepositoryService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<ToDoEntity> getMyTodos() {
        List<ToDoEntity> allTodos = todoRepository.findAll();

        return allTodos;
    }

    @Override
    public ToDoEntity getMyTodo(String todoId) {
        Optional<ToDoEntity> oToDoEntity = todoRepository.findById(todoId);

        if (!oToDoEntity.isPresent()) {
            throw new MyToDoException("No such todo present with id: " + todoId);
        }
        ToDoEntity toDoEntity = oToDoEntity.get();

        return toDoEntity;

    }

    @Override
    public ToDoEntity createMyTodo(ToDoEntity toDoEntity) {
        ToDoEntity new_toDoEntity = todoRepository.insert(toDoEntity);
        return new_toDoEntity;
    }

    @Override
    public ToDoEntity updateMyTodo(String todoId, ToDoEntity toDoEntity) {
        Optional<ToDoEntity> oToDoEntity = todoRepository.findById(todoId);
        ToDoEntity new_toDoEntity;
        if (!oToDoEntity.isPresent()) {
            new_toDoEntity = new ToDoEntity();
        } else {
            new_toDoEntity = oToDoEntity.get();
        }

        new_toDoEntity.setTitle(toDoEntity.getTitle());
        new_toDoEntity.setDescription(toDoEntity.getDescription());
        new_toDoEntity.setDateTime(toDoEntity.getDateTime());

        return todoRepository.save(new_toDoEntity);

    }

    @Override
    public String deleteMyTodo(String todoId) {
        todoRepository.deleteById(todoId);
        return "Successfully Deteled Data ToDoId: " + todoId;
    }

}
