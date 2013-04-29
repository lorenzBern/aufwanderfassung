package com.unisys.ch.jax.costserver.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.unisys.ch.jax.costserver.model.Cost;
import com.unisys.ch.jax.costserver.model.CostLocation;

@Service
public class CostServiceInMemory implements CostService {

	private Long lastId = 4L;
	private TreeMap<Long, Cost> cachedToDos;

	public CostServiceInMemory() {
		cachedToDos = new TreeMap<Long, Cost>();
		generateDummyEntities();
	}

	private void generateDummyEntities() {
		for (long x = 1; x <= 15; x++) {
			Cost todo = new Cost(x, "Todo" + x, "Todo" + x + " Description",
					Calendar.getInstance(), 8.0, CostLocation.BAFU);
			cachedToDos.put(x, todo);
		}
	}

	public Cost findById(Long id) {
		return cachedToDos.get(id);
	}

	public Collection<Cost> findAll() {
		return cachedToDos.values();
	}

	public Cost save(Cost todo) {
		if (todo.getId() == null) {
			todo.setId(++lastId);
		}
		return cachedToDos.put(todo.getId(), todo);
	}

	public void delete(Long id) {
		cachedToDos.remove(id);
	}

	@Override
	public Collection<Cost> findAll(int start, int amount) {
		ArrayList<Cost> retVal = new ArrayList<Cost>(findAll());
		if (start > retVal.size()) {
			return new ArrayList<Cost>(0);
		} else {
			return retVal.subList(start,
					Math.min(start + amount, retVal.size()));
		}
	}
}