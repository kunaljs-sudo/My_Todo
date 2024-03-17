package com.demo.myTodo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.myTodo.models.ToDoEntity;

@Repository
public interface TodoRepository extends MongoRepository<ToDoEntity, String> {
}
