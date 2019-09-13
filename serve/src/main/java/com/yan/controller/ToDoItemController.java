package com.yan.controller;

import com.yan.model.ToDoItem;
import com.yan.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController     // for rest response
public class ToDoItemController {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    // to add new todoItem
    @RequestMapping(value = "/todos", method = RequestMethod.POST)     // or user @GetMapping
    public ToDoItem save(@RequestBody ToDoItem toDoItem){
        return toDoItemRepository.save(toDoItem);
    }

    // to update todoItem
    @RequestMapping(value = "/todos/{id}",method = RequestMethod.PUT)     // or user @GetMapping
    public ToDoItem update(@PathVariable String id, @RequestBody ToDoItem toDoItem){
        ToDoItem item = toDoItemRepository.findById(id);
        if(! StringUtils.isEmpty(toDoItem.getTitle()))
            item.setTitle(toDoItem.getTitle());
        if(toDoItem.isCompleted())
            item.setCompleted(toDoItem.isCompleted());
        return toDoItemRepository.save(item);
    }

    // list of all todoItem
    @RequestMapping(value = "/todos",method = RequestMethod.GET)   // or use @GetMapping
    public java.util.List<ToDoItem> listToDoItem() {
        return toDoItemRepository.findAll();
    }

    // delete specific todoItem using id
    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE)        // or use @DeleteMapping
    public void delete(@PathVariable("id")String id){
         toDoItemRepository.delete(id);
    }
}
