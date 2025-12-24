package com.rosea.api.service;

import com.rosea.api.dto.TaskDto;
import com.rosea.api.mapper.TaskMapper;
import com.rosea.api.model.Task;
import com.rosea.api.repository.TaskRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository repository, TaskMapper taskMapper) {
        this.repository = repository;
        this.taskMapper = taskMapper;
    }

    public TaskDto create(TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task savedTask = repository.save(task);
        return taskMapper.toDto(savedTask);
    }

    public TaskDto findTaskById(int id) {
        return repository
                .findById(id)
                .map(taskMapper::toDto)
                .orElse(null);
    }

    public List<TaskDto> list() {
        return repository.findAll().stream()
                .filter(t -> t.getParent() == null)
                .map(taskMapper::toDto)
                .toList();
    }

    public TaskDto complete(int id, Instant date) {
        // Get the task from the repository
        Task task = repository.findById(id).orElseThrow();
        // Complete the task
        task.complete(date);
        // Update the task
        repository.save(task);
        // Return the task as a DTO
        return taskMapper.toDto(task);
    }
}
