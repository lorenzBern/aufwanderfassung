package com.unisys.ch.jax.restserver.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.unisys.ch.jax.restserver.model.ToDo;
import com.unisys.ch.jax.restserver.service.ToDoService;

@Controller
@RequestMapping("/todos")
public class ToDoController {
	
	@Autowired
	ToDoService toDoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ToDo read(@PathVariable Long id) {
		ToDo todo = toDoService.findById(id);
		if (todo == null) {
            throw new IllegalArgumentException(String.format("Unable to find ToDo with id: %d", id));
        }
		return todo;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<ToDo> list() {
		return toDoService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ToDo create(@RequestBody ToDo todo) {
		return toDoService.save(todo);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "id") Long id, @RequestBody ToDo todo) {
		if (todo.getId() == null || !todo.getId().equals(id)) {
            throw new IllegalArgumentException(String.format("The id of given ToDo doesn't match URL id: %d", id));
        }
		toDoService.save(todo);
    }
 
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id) {
    	toDoService.delete(id);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleClientErrors(Exception ex) {
        return ex.getMessage();
    }
 
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleServerErrors(Exception ex) {
        return ex.getMessage();
    }
}
