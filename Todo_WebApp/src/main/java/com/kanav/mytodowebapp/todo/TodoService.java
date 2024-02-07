package com.kanav.mytodowebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	private static int todosCount = 0;
	static {
		todos.add(new Todo(++todosCount, "Kanav Sharma", "Learn Full Stack Development", LocalDate.now().plusYears(1),
				false));
		todos.add(new Todo(++todosCount, "Kanav Sharma", "Learn DevOpps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "Kanav Sharma", "Learn GCP", LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todosCount, "Kanav Sharma", "Learn Azure", LocalDate.now().plusYears(4), false));
	}

	public List<Todo> findByUserName(String userName) {
		Predicate<? super Todo> predicate = todo -> todo.getUserName().equalsIgnoreCase(userName);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		todos.add(new Todo(++todosCount, username, description, targetDate, isDone));
	}

	public void deleteById(int id) {

		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
