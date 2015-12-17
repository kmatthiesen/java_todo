package com.catalyst.springboot.dao;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.TaskItem;

public class TaskListTest {
	
	private TaskList taskList;
	private EntityManager mockEm;
	
	@Before
	public void setup(){
		taskList = new TaskList();
		mockEm = mock(EntityManager.class);
		taskList.setEm(mockEm);
	}
	
	@Test
	public void testAddTask(){
		taskList.addTask(null);
		verify(mockEm, times(1)).persist(null);
	}
	
	@Test
	public void testDisplayTask(){
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		
		taskList.displayTask(0);
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));
	}
	
	@Test
	public void testUpdateTask(){
		TaskItem expected = new TaskItem();
		expected.setId(1);
		
		taskList.updateTask(expected);
		verify(mockEm, times(1)).merge(expected);
	}
	
	@Test
	public void testDeleteTask(){
		TaskItem expected = new TaskItem();
		expected.setId(5);
		
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getSingleResult()).thenReturn(expected);
		
		taskList.deleteTask(5);
		
		
		verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(5));
		verify(mockEm, times(1)).remove(expected);
	}
	
	@Test
	public void testSortTitle(){
		List<TaskItem> expected = new ArrayList<TaskItem>();
		
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		taskList.sortTitle();
		
		verify(mockTypedQuery, times(1)).getResultList();
	}
	
	@Test
	public void testSortUser(){
		List<TaskItem> expected = new ArrayList<TaskItem>();
		
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		taskList.sortUser();
		
		verify(mockTypedQuery, times(1)).getResultList();
	}
	
	@Test
	public void testSortStatus(){
		List<TaskItem> expected = new ArrayList<TaskItem>();
		
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		taskList.sortStatus();
		
		verify(mockTypedQuery, times(1)).getResultList();
	}
	
	@Test
	public void testSortId(){
		List<TaskItem> expected = new ArrayList<TaskItem>();
		
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		taskList.sortId();
		
		verify(mockTypedQuery, times(1)).getResultList();
	}
	
	@Test
	public void testFilterOwner(){
		List<TaskItem> expected = new ArrayList<TaskItem>();
		
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyString())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		taskList.filterOwner("kevin");
		
		verify(mockTypedQuery, times(1)).setParameter(eq("owner"), eq("kevin"));
	}
	
	@Test
	public void testFilterStatus(){
		List<TaskItem> expected = new ArrayList<TaskItem>();
		
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyString())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		taskList.filterStatus("complete");
		
		verify(mockTypedQuery, times(1)).setParameter(eq("status"), eq("complete"));
	}
	
	@Test
	public void testFilterTitle(){
		List<TaskItem> expected = new ArrayList<TaskItem>();
		
		TypedQuery<TaskItem> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(TaskItem.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.setParameter(anyString(), anyString())).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
		
		taskList.filterTitle("test");
		
		verify(mockTypedQuery, times(1)).setParameter(eq("title"), eq("test"));
	}
}
