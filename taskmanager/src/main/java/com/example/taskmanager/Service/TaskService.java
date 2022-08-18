package com.example.taskmanager.Service;

import java.util.List;


import com.example.taskmanager.Model.Task;

public interface TaskService {
Task listoftask(Task task);
List<Task> findall();
Task getbyId(int id);



}
