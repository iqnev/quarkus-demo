package org.fortran.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

import org.fortran.demo.model.Task;


@ApplicationScoped
public class TaskService {

	List<Task> list = new ArrayList<>();

	public boolean addTask(String task) {
		final Task toDo = new Task(task, new Date());
		return list.add(toDo);
	}

	public boolean addTask(Task task) {
		return list.add(task);
	}

	public List<Task> allTasks() {
		return list;
	}

	private Task getTask(String id) {
		Optional<Task> item = list.stream().filter(t -> t.id.equals(id)).findFirst();

		return item.orElse(null);
	}

	public boolean delete(String id) {
		return list.remove(getTask(id));
	}

}
