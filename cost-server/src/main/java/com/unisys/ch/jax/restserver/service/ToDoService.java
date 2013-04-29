package com.unisys.ch.jax.restserver.service;

import java.util.Collection;

import com.unisys.ch.jax.restserver.model.ToDo;

public interface ToDoService {

	public ToDo findById(Long id);
	
	public Collection<ToDo> findAll();
	
	public ToDo save(ToDo todo);

	public void delete(Long id);
}
