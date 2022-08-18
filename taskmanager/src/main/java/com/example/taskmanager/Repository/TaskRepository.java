package com.example.taskmanager.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.taskmanager.Model.Task;

public interface TaskRepository extends JpaRepository<Task,Integer>{
    
	@Query("FROM Task where status= :status")
	List<Task> gettaskbystatus(String status);
	
	@Query("FROM Task where priority=:priority")
	List<Task> gettaskbypriority(int priority);
	
	@Transactional
	@Modifying
	@Query("update Task t set t.status=:status where t.id=:id")
	int updateStatus(String status,int id);
//	
}
