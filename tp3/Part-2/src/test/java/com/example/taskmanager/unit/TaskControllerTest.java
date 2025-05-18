package com.example.taskmanager.unit;

import com.example.taskmanager.controller.TaskController;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateTask() {
        // Given
        Task task = new Task("Test Task", "Test Description");
        when(taskService.saveTask(any(Task.class))).thenReturn(task);

        // When
        ResponseEntity<Task> response = taskController.createTask(task);

        // Then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Test Task");
        verify(taskService, times(1)).saveTask(task);
    }

    @Test
    void shouldGetAllTasks() {
        // Given
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");
        when(taskService.getAllTasks()).thenReturn(Arrays.asList(task1, task2));

        // When
        ResponseEntity<List<Task>> response = taskController.getAllTasks();

        // Then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        verify(taskService, times(1)).getAllTasks();
    }

    @Test
    void shouldGetTaskById() {
        // Given
        Task task = new Task("Test Task", "Test Description");
        when(taskService.findTaskById(1L)).thenReturn(Optional.of(task));

        // When
        ResponseEntity<Task> response = taskController.getTaskById(1L);

        // Then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Test Task");
        verify(taskService, times(1)).findTaskById(1L);
    }

    @Test
    void shouldReturnNotFoundWhenTaskDoesNotExist() {
        // Given
        when(taskService.findTaskById(1L)).thenReturn(Optional.empty());

        // When
        ResponseEntity<Task> response = taskController.getTaskById(1L);

        // Then
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
        verify(taskService, times(1)).findTaskById(1L);
    }

    @Test
    void shouldUpdateTask() {
        // Given
        Task task = new Task("Updated Task", "Updated Description");
        when(taskService.updateTask(eq(1L), any(Task.class))).thenReturn(task);

        // When
        ResponseEntity<Task> response = taskController.updateTask(1L, task);

        // Then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Updated Task");
        verify(taskService, times(1)).updateTask(1L, task);
    }

    @Test
    void shouldDeleteTask() {
        // Given
        Long taskId = 1L;

        // When
        ResponseEntity<Void> response = taskController.deleteTask(taskId);

        // Then
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        verify(taskService, times(1)).deleteTaskById(taskId);
    }
} 