package com.kanav.mytodowebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRespository extends JpaRepository<Todo, Integer>{
	
	public List<Todo> findByUserName(String userName);
	public Todo findById(int id);
}
