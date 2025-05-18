package com.example.taskmanager.integration;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class TaskControllerIntegrationTest {

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

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TaskRepository taskRepository;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/api/tasks";
        taskRepository.deleteAll();
    }

    @Test
    void shouldCreateTask() {
        // Given
        Task task = new Task("Test Task", "Test Description");

        // When
        ResponseEntity<Task> response = restTemplate.postForEntity(baseUrl, task, Task.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Test Task");
        assertThat(response.getBody().getDescription()).isEqualTo("Test Description");
    }

    @Test
    void shouldGetAllTasks() {
        // Given
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");
        taskRepository.save(task1);
        taskRepository.save(task2);

        // When
        ResponseEntity<Task[]> response = restTemplate.getForEntity(baseUrl, Task[].class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(2);
    }

    @Test
    void shouldGetTaskById() {
        // Given
        Task task = taskRepository.save(new Task("Test Task", "Test Description"));

        // When
        ResponseEntity<Task> response = restTemplate.getForEntity(baseUrl + "/" + task.getId(), Task.class);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(task.getId());
    }

    @Test
    void shouldUpdateTask() {
        // Given
        Task task = taskRepository.save(new Task("Original Task", "Original Description"));
        Task updatedTask = new Task("Updated Task", "Updated Description");

        // When
        ResponseEntity<Task> response = restTemplate.exchange(
                baseUrl + "/" + task.getId(),
                HttpMethod.PUT,
                new HttpEntity<>(updatedTask),
                Task.class
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTitle()).isEqualTo("Updated Task");
        assertThat(response.getBody().getDescription()).isEqualTo("Updated Description");
    }

    @Test
    void shouldDeleteTask() {
        // Given
        Task task = taskRepository.save(new Task("Test Task", "Test Description"));

        // When
        restTemplate.delete(baseUrl + "/" + task.getId());

        // Then
        assertThat(taskRepository.findById(task.getId())).isEmpty();
    }
} 