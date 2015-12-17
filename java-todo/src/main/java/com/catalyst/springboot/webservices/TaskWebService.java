package com.catalyst.springboot.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.springboot.dao.TaskList;
import com.catalyst.springboot.entities.TaskItem;
/**
 * Controls the various requests coming in from the website.
 * 
 * @author kmatthiesen
 *
 */
@RestController
public class TaskWebService {

	@Autowired
	private TaskList taskList;
	
	public void setTaskList (TaskList taskList){
		this.taskList = taskList;
	}
	
	/**
	 * Adds a new TaskItem to the database.
	 * 
	 * @param task The new TaskItem to be added.
	 */
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public void addTask(@RequestBody TaskItem task){
		taskList.addTask(task);
	}
	
	/**
	 * Displays all TaskItems sorted by id.
	 * 
	 * @return List of all TaskItems sorted by id.
	 */
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<TaskItem> displayTasks(){
		return taskList.sortId();
	}
	
	/**
	 * Update a TaskItem in the database.
	 * 
	 * @param task The updated TaskItem.
	 * @param id The id of the TaskItem to be updated.
	 */
	@RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
	public void updateTask(@RequestBody TaskItem task, @PathVariable int id){
		taskList.updateTask(task);
	}
	
	/**
	 * Display the information of a single TaskItem.
	 * 
	 * @param id The id of the TaskItem to display.
	 * @return The TaskItem retrieved from the database.
	 */
	@RequestMapping(value ="/task/{id}", method = RequestMethod.GET)
	public TaskItem displayTask(@PathVariable int id){
		return taskList.displayTask(id);
		
	}
	
	/**
	 * Delete a TaskItem from the database.
	 * 
	 * @param id The id of the TaskItem to be deleted.
	 */
	@RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
	public void deleteTask(@PathVariable int id){
		taskList.deleteTask(id);
	}
	
	/**
	 * Retrieve a list of all TaskItems sorted by title.
	 * 
	 * @return Retrieved list of all TaskItems sorted by title.
	 */
	@RequestMapping(value = "/tasks/title", method = RequestMethod.GET)
	public List<TaskItem> sortTitle(){
		return taskList.sortTitle();
	}

	/**
	 * Retrieve a list of all TaskItems sorted by user.
	 * 
	 * @return Retrieved list of all TaskItems sorted by user.
	 */
	@RequestMapping(value = "/tasks/user", method = RequestMethod.GET)
	public List<TaskItem> sortUser(){
		return taskList.sortUser();
	}

	/**
	 * Retrieve a list of all TaskItems sorted by status.
	 * 
	 * @return Retrieved list of all TaskItems sorted by status.
	 */
	@RequestMapping(value = "/tasks/status", method = RequestMethod.GET)
	public List<TaskItem> sortStatus(){
		return taskList.sortStatus();
	}

	/**
	 * Returns all TaskItems sorted by id that are owned by a specific user.
	 * 
	 * @param filter The string to filter the list by.
	 * @return The list of TaskItems sorted by id that are owned by a specific user.
	 */
	@RequestMapping(value = "/tasks/filter/owner/{filter}", method = RequestMethod.GET)
	public List<TaskItem> filterOwner(@PathVariable String filter){
		return taskList.filterOwner(filter);
	}
	
	/**
	 * Returns all TaskItems sorted by id that have a specific status.
	 * 
	 * @param filter The string to filter the list by.
	 * @return The list of TaskItems sorted by id that have a specific status.
	 */
	@RequestMapping(value = "/tasks/filter/status/{filter}", method = RequestMethod.GET)
	public List<TaskItem> filterStatus(@PathVariable String filter){
		return taskList.filterStatus(filter.toLowerCase());
	}
	
	/**
	 * Returns all TaskItems sorted by id that have a specific title.
	 * 
	 * @param filter The string to filter the list by.
	 * @return The list of TaskItems sorted by id that have a specific title.
	 */
	@RequestMapping(value = "/tasks/filter/title/{filter}", method = RequestMethod.GET)
	public List<TaskItem> filterTitle(@PathVariable String filter){
		return taskList.filterTitle(filter);
	}

}
