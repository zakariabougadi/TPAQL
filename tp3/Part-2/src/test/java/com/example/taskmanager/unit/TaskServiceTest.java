package com.example.taskmanager.unit;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveTask() {
        // Given
        Task task = new Task("Test Task", "Test Description");
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        // When
        Task savedTask = taskService.saveTask(task);

        // Then
        assertThat(savedTask).isNotNull();
        assertThat(savedTask.getTitle()).isEqualTo("Test Task");
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void shouldGetAllTasks() {
        // Given
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        // When
        List<Task> tasks = taskService.getAllTasks();

        // Then
        assertThat(tasks).hasSize(2);
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void shouldFindTaskById() {
        // Given
        Task task = new Task("Test Task", "Test Description");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        // When
        Optional<Task> foundTask = taskService.findTaskById(1L);

        // Then
        assertThat(foundTask).isPresent();
        assertThat(foundTask.get().getTitle()).isEqualTo("Test Task");
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void shouldDeleteTaskById() {
        // Given
        Long taskId = 1L;

        // When
        taskService.deleteTaskById(taskId);

        // Then
        verify(taskRepository, times(1)).deleteById(taskId);
    }

    @Test
    void shouldUpdateTask() {
        // Given
        Task existingTask = new Task("Original Task", "Original Description");
        Task updatedTask = new Task("Updated Task", "Updated Description");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        // When
        Task result = taskService.updateTask(1L, updatedTask);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo("Updated Task");
        verify(taskRepository, times(1)).findById(1L);
        verify(taskRepository, times(1)).save(any(Task.class));
    }
} 