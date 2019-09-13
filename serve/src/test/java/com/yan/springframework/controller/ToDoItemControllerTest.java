package com.yan.springframework.controller;

import com.yan.model.ToDoItem;
import com.yan.service.ToDoItemService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ToDoItemControllerTest  extends AbstractSpringBootTest{


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ToDoItemService toDoItemService;

    @Before
    public void setup(){
        //add some todoItem
        List<ToDoItem> items = new ArrayList<>();
        items.add(new ToDoItem().setId("1").setTitle("walk").setCompleted(false));
        items.add(new ToDoItem().setId("2").setTitle("homework").setCompleted(false));
        items.add(new ToDoItem().setId("3").setTitle("game").setCompleted(false));

        when(toDoItemService.findAll()).thenReturn(items);
    }

    @Test
    public void addToDoITemTest() throws Exception{
        mvc.perform(
        post("/todos")
                .content("{\"title\":\"test\", \"completed\":\"false\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))

               .andDo(print())
               .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("test"));

    }

    @Test
    public void getAllToDoItemsTest() throws Exception{

        mvc.perform(MockMvcRequestBuilders
        .get("/todos")
        .accept(MediaType.APPLICATION_JSON)
        )
                //.andDo(print())
        .andExpect(status().isOk())

        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
        ;
    }
}
