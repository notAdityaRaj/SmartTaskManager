package com.aditya.SmartTaskManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	@GetMapping("/")
	public String message() {
		return "Welcome to Spring Boot Application";
	}
	@Autowired
	TaskRepository taskRepository;
	
	@PostMapping("/tasks")
	public Task createTask(@RequestBody Task task) {
		Task savedTask=taskRepository.save(task);
		return savedTask;
	}
	@GetMapping("/tasks")
	public List<Task> retrieveTask(){
		return taskRepository.findAll();
	}
	
	@PutMapping("/tasks/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
		task.setId(id);
		return taskRepository.save(task);
	}
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Long id){
	    taskRepository.deleteById(id);
	    return ResponseEntity.ok().build();
	}
	
}
