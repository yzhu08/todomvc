package com.yan.repository;

import com.yan.model.ToDoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ToDoItemRepository extends MongoRepository<ToDoItem, String> {

    @Override
    List<ToDoItem> findAll();           // find all

    @Query(value = "{ 'title' : ?0 }")
    List<ToDoItem> findByName(String name);       // find item by name

    ToDoItem findById(String id);           // find

    @Override
    void delete(String s);              // delete by ID
}
