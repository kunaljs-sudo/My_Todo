package com.demo.myTodo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.myTodo.dto.ToDo;
import com.demo.myTodo.models.ToDoEntity;

@Service
public class ToDoConverterImpl implements ToDoConverter {

    private ToDo convertToDtoStatic(ToDoEntity todoEntity) {
        ToDo todoDTO = new ToDo();
        todoDTO.setId(todoEntity.getId());
        todoDTO.setTitle(todoEntity.getTitle());
        todoDTO.setDescription(todoEntity.getDescription());
        todoDTO.setDateTime(todoEntity.getDateTime());

        return todoDTO;
    }

    @Override
    public ToDo convertToDto(ToDoEntity todoEntity) {
        return convertToDtoStatic(todoEntity);
    }

    @Override
    public List<ToDo> convertToDtoList(List<ToDoEntity> todoEntities) {
        return todoEntities.stream()
                .map(this::convertToDtoStatic)
                .collect(Collectors.toList());
    }

}
