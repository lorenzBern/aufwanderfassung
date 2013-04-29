package com.unisys.ch.jax.restserver.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.unisys.ch.jax.restserver.model.ToDo;

@Service
public class ToDoServiceInMemory implements ToDoService {

	private Long lastId = 4L;
	private Map<Long, ToDo> cachedToDos;
	
	public ToDoServiceInMemory() {
		cachedToDos = new HashMap<Long, ToDo>();
		for (long x = 1; x < 5; x++) {
			ToDo todo = new ToDo(x, "Todo" + x, false, Calendar.getInstance());
			cachedToDos.put(x, todo);
		}
	}
	
	public ToDo findById(Long id) {
		return cachedToDos.get(id);
	}
	
	public Collection<ToDo> findAll() {
		return cachedToDos.values();
	}
	
	public ToDo save(ToDo todo) {
		if (todo.getId() == null) {
			todo.setId(++lastId);
		}
		return cachedToDos.put(todo.getId(), todo);
	}

	public void delete(Long id) {
		cachedToDos.remove(id);
	}
}
