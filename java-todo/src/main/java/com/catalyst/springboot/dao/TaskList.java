package com.catalyst.springboot.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.catalyst.springboot.entities.TaskItem;

/**
 * Communicates with the database.
 * 
 * @author kmatthiesen
 *
 */

@Component
@Transactional
public class TaskList{
		
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em){
		this.em=em;
	}
	
	/**
	 * Adds a new task to the database.
	 * 
	 * @param task The task item to be added to the database.
	 */
	public void addTask(TaskItem task){
		em.persist(task);		
	}
	
	/**
	 * Grabs an individual TaskItem from the database.
	 * 	
	 * @param id The id of the TaskItem to get.
	 * @return The TaskItem that was retrieved.
	 */
	public TaskItem displayTask(int id){
		return em.createQuery("SELECT e FROM TaskItem e WHERE e.id = :id", TaskItem.class)
				.setParameter("id", id).getSingleResult();
	}
	
	/**
	 * Update a TaskItem in the database.
	 * 
	 * @param newTask The new values for the TaskItem.
	 */
	public void updateTask(TaskItem newTask){
		em.merge(newTask);
	}
	
	/**
	 * Deletes a TaskItem in the database.
	 * 
	 * @param id The TaskItem to be deleted.
	 */
	public void deleteTask(int id){
		TaskItem task = displayTask(id);
		em.remove(task);
	}
		
	/**
	 * Returns all TaskItems sorted by title.
	 * 
	 * @return The list of TaskItems sorted by title.
	 */
	public List<TaskItem> sortTitle(){
		return em.createQuery("SELECT e FROM TaskItem e ORDER BY title", TaskItem.class)
				.getResultList();
	}
	
	/**
	 * Returns all TaskItems sorted by user.
	 * 
	 * @return The list of TaskItems sorted by user.
	 */
	public List<TaskItem> sortUser(){
		return em.createQuery("SELECT e FROM TaskItem e ORDER BY owner", TaskItem.class)
				.getResultList();
	}

	/**
	 * Returns all TaskItems sorted by status.
	 * 
	 * @return The list of TaskItems sorted by status.
	 */
	public List<TaskItem> sortStatus(){
		return em.createQuery("SELECT e FROM TaskItem e ORDER BY status", TaskItem.class)
				.getResultList();
	}	
	

	/**
	 * Returns all TaskItems sorted by id.
	 * 
	 * @return The list of TaskItems sorted by id.
	 */
	public List<TaskItem> sortId(){
		return em.createQuery("SELECT e FROM TaskItem e ORDER BY id", TaskItem.class)
				.getResultList();
	}
	

	/**
	 * Returns all TaskItems sorted by id that are owned by a specific user.
	 * 
	 * @param filter The string to filter the list by.
	 * @return The list of TaskItems sorted by id that are owned by a specific user.
	 */
	public List<TaskItem> filterOwner(String filter){
		return em.createQuery("SELECT e FROM TaskItem e WHERE e.owner = :owner ORDER BY id", TaskItem.class)
				.setParameter("owner", filter).getResultList();
	}
	
	/**
	 * Returns all TaskItems sorted by id that have a specific status.
	 * 
	 * @param filter The string to filter the list by.
	 * @return The list of TaskItems sorted by id that have a specific status.
	 */
	public List<TaskItem> filterStatus(String filter){
		return em.createQuery("SELECT e FROM TaskItem e WHERE e.status = :status ORDER BY id", TaskItem.class)
				.setParameter("status", filter).getResultList();
	}
	
	/**
	 * Returns all TaskItems sorted by id that have a specific title.
	 * 
	 * @param filter The string to filter the list by.
	 * @return The list of TaskItems sorted by id that have a specific title.
	 */
	public List<TaskItem> filterTitle(String filter){
		return em.createQuery("SELECT e FROM TaskItem e WHERE e.title = :title ORDER BY id", TaskItem.class)
				.setParameter("title", filter).getResultList();
	}
}
