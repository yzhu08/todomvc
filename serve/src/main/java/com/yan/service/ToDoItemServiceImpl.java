package com.yan.service;

import com.yan.model.ToDoItem;
import com.yan.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Override
    public List<ToDoItem> findAll() {
        return toDoItemRepository.findAll();
    }


    @Override
    public void delete(String id) {
        toDoItemRepository.delete(toDoItemRepository.findOne(id));
    }

    @Override
    public ToDoItem save(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    @Override
    public ToDoItem update(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }
}
