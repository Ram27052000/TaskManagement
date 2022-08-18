package com.example.taskmanager.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.example.taskmanager.Model.Task;
import com.example.taskmanager.Repository.TaskRepository;
import com.example.taskmanager.Service.TaskService;

@RestController
public class TaskController {

		private TaskService taskservice;
		@Autowired
		public TaskRepository taskrepository;
	
		public TaskController(TaskService taskservice) 
		{
				super();
				this.taskservice = taskservice;
	    }
		@PostMapping("/taskdetails")
		public String showMessage(@RequestBody Task task)
		{
			taskservice.listoftask(task);
			return "success";
		}	
		@GetMapping("/showalltask")
		public List<Task> showall()
		{
			return taskservice.findall();
			
		}
		@GetMapping("/showbyid/{id}")
		public Task showbyID(@PathVariable ("id") int id )
		{
			return taskservice.getbyId(id);
		}
		@PutMapping("/updatebyid/{id}")
		public Task updatebyID(@RequestBody Task task,@PathVariable("id")int id)
		{
			task.taskid=id;
			return taskservice.listoftask(task);
		}
		
		@GetMapping("/status/{status}")
		public List<Task> gettaskbystatus(@PathVariable("status")String status)
		{
			
			return taskrepository.gettaskbystatus(status);
		}
		@GetMapping("/priority/{priority}")
		public List<Task> gettaskbypriority(@PathVariable("priority")int priority)
		{
			return taskrepository.gettaskbypriority(priority);
		}
		
		@PutMapping("/updateStatusbyID/{id}/{status}")
		public String updateStatus(@PathVariable ("id")int id,@PathVariable("status")String status)
		{
			taskrepository.updateStatus(status, id);
			return "SUCCESS";
		}
	
		
}
