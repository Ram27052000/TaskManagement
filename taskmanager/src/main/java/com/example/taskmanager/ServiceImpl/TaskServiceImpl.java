package com.example.taskmanager.ServiceImpl;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;


import com.example.taskmanager.Model.Task;
import com.example.taskmanager.Repository.TaskRepository;
import com.example.taskmanager.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	private TaskRepository taskRepository;
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}
	@Override
	public Task listoftask(Task task) {
		return taskRepository.save(task);
	}
	@Override
	public List<Task> findall() {
		
		return taskRepository.findAll();
	}
	@Override
	public Task getbyId(int id) {
		Optional<Task> task=taskRepository.findById(id);
		return task.get();
	}
	
	

	
	
	
	
	
}
