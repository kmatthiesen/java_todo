package com.catalyst.springboot.webservices;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.dao.TaskList;

public class WebServicesTest {

	private TaskWebService taskWebService;
	private TaskList mockTaskList;
	
	@Before
	public void createTaskWebService(){
		mockTaskList= mock(TaskList.class);
		taskWebService = new TaskWebService();
		taskWebService.setTaskList(mockTaskList);
	}
	
	@Test
	public void testAddTask(){
		taskWebService.addTask(null);
		verify(mockTaskList, times(1)).addTask(null);
	}
	
	@Test
	public void testDisplayTasks(){
		taskWebService.displayTasks();
		verify(mockTaskList, times(1)).sortId();
	}
	
	@Test 
	public void testUpdateTask(){
		taskWebService.updateTask(null, anyInt());
		verify(mockTaskList, times(1)).updateTask(null);
	}
	
	@Test 
	public void testDisplayTask(){
		taskWebService.displayTask(anyInt());
		verify(mockTaskList, times(1)).displayTask(anyInt());
	}
	
	@Test 
	public void testDeleteTask(){
		taskWebService.deleteTask(anyInt());
		verify(mockTaskList, times(1)).deleteTask(anyInt());
	}
	
	@Test
	public void testSortTitle(){
		taskWebService.sortTitle();
		verify(mockTaskList, times(1)).sortTitle();
	}
	
	@Test
	public void testSortUser(){
		taskWebService.sortUser();
		verify(mockTaskList, times(1)).sortUser();
	}
	
	@Test
	public void testSortStatus(){
		taskWebService.sortStatus();
		verify(mockTaskList, times(1)).sortStatus();
	}
	
	@Test
	public void testFilterOwner(){
		taskWebService.filterOwner(null);
		verify(mockTaskList, times(1)).filterOwner(null);
	}
	
	@Test
	public void testFilterStatus(){
		taskWebService.filterStatus(anyString());
		verify(mockTaskList, times(1)).filterStatus(anyString());
	}
	
	@Test
	public void testFilterTitle(){
		taskWebService.filterTitle(null);
		verify(mockTaskList, times(1)).filterTitle(null);
	}
}
