package com.yan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ToDoItem")
public class ToDoItem {

    @Id                                                     // primary key
    private String id;

    private String title;

    private boolean completed;

    public String getId() {
        return id;
    }

    public ToDoItem setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ToDoItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isCompleted() {
        return completed;
    }

    public ToDoItem setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }
}
