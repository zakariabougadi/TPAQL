package com.example.taskmanager.integration;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class TaskServiceIntegrationTest {

    @Container
    private static final MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
    }

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    void shouldSaveAndRetrieveTask() {
        // Given
        Task task = new Task("Test Task", "Test Description");

        // When
        Task savedTask = taskService.saveTask(task);
        Optional<Task> retrievedTask = taskService.findTaskById(savedTask.getId());

        // Then
        assertThat(retrievedTask).isPresent();
        assertThat(retrievedTask.get().getTitle()).isEqualTo("Test Task");
        assertThat(retrievedTask.get().getDescription()).isEqualTo("Test Description");
    }

    @Test
    void shouldGetAllTasks() {
        // Given
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");
        taskService.saveTask(task1);
        taskService.saveTask(task2);

        // When
        List<Task> tasks = taskService.getAllTasks();

        // Then
        assertThat(tasks).hasSize(2);
        assertThat(tasks).extracting("title").containsExactlyInAnyOrder("Task 1", "Task 2");
    }

    @Test
    void shouldUpdateTask() {
        // Given
        Task task = taskService.saveTask(new Task("Original Task", "Original Description"));
        Task updatedTask = new Task("Updated Task", "Updated Description");

        // When
        Task result = taskService.updateTask(task.getId(), updatedTask);

        // Then
        assertThat(result.getTitle()).isEqualTo("Updated Task");
        assertThat(result.getDescription()).isEqualTo("Updated Description");
    }

    @Test
    void shouldDeleteTask() {
        // Given
        Task task = taskService.saveTask(new Task("Test Task", "Test Description"));

        // When
        taskService.deleteTaskById(task.getId());

        // Then
        assertThat(taskService.findTaskById(task.getId())).isEmpty();
    }
} 