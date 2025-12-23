package com.rosea.api.controller;

import com.rosea.api.dto.TaskDto;
import com.rosea.api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskDto create(@Valid @RequestBody TaskDto dto) {
        return taskService.create(dto);
    }

    @GetMapping
    public List<TaskDto> list() {
        return taskService.list();
    }

    @GetMapping("{id}")
    public TaskDto single(@PathVariable int id) {
        return taskService.findTaskById(id);
    }

    @PatchMapping("{id}")
    public TaskDto complete(@PathVariable int id, @RequestParam(required = false) Instant date) {
        return taskService.complete(id, date);
    }

//    @PutMapping("{id}")
//    public ResponseEntity<RegularTask> update(@PathVariable int id, @RequestBody RegularTask regularTask) {
//        return repository
//            .findById(id)
//            .map(t -> {
//                // Update the fields
//                t.setName(regularTask.getName());
//                t.setDate(regularTask.getDate());
//                t.setCompleted(regularTask.isCompleted());
//                // Store the update task
//                return ResponseEntity.ok(repository.save(t));
//            })
//            .orElse(ResponseEntity.notFound().build());
//    }
}
