package com.demo.myTodo.mapper;

import java.util.List;

import com.demo.myTodo.dto.ToDo;
import com.demo.myTodo.models.ToDoEntity;

public interface ToDoConverter {
    public ToDo convertToDto(ToDoEntity todoEntity);

    public List<ToDo> convertToDtoList(List<ToDoEntity> todoEntities);

}
