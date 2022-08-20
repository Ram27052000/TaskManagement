package com.example.taskmanager.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		@RequestMapping(value="/taskdetails",method = RequestMethod.POST)
		public String showMessage(@RequestBody Task task)
		{
			taskservice.listoftask(task);
			return "success";
		}
		@RequestMapping(value="/showalltask",method = RequestMethod.GET)
		public List<Task> showall()
		{
			return taskservice.findall();
			
		}
		@RequestMapping(value="/showbyid/{id}",method = RequestMethod.GET)
		public Task showbyID(@PathVariable ("id") int id )
		{
			return taskservice.getbyId(id);
		}
		@RequestMapping(value="/updatebyid/{id}",method = RequestMethod.PUT)
		public Task updatebyID(@RequestBody Task task,@PathVariable("id")int id)
		{
			task.taskid=id;
			return taskservice.listoftask(task);
		}
		
		@RequestMapping(value="/status/{status}",method = RequestMethod.GET)
		public List<Task> gettaskbystatus(@PathVariable("status")String status)
		{
			
			return taskrepository.gettaskbystatus(status);
		}
		@RequestMapping(value="/priority/{priority}",method = RequestMethod.GET)
		public List<Task> gettaskbypriority(@PathVariable("priority")int priority)
		{
			return taskrepository.gettaskbypriority(priority);
		}
		
		@RequestMapping(value="/updateStatusbyID/{id}/{status}",method = RequestMethod.PUT)
		public String updateStatus(@PathVariable ("id")int id,@PathVariable("status")String status)
		{
			taskrepository.updateStatus(status, id);
			return "SUCCESS";
		}
	
		
}
