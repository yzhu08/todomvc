package com.yan.service;

import com.yan.model.ToDoItem;

import java.util.List;


public interface ToDoItemService {
    List<ToDoItem> findAll();
    ToDoItem save(ToDoItem toDoItem);
    void delete(String id);
    ToDoItem update(ToDoItem toDoItem);
}
