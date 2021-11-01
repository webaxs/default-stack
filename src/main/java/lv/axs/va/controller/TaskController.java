package lv.axs.va.controller;

import lombok.AllArgsConstructor;
import lv.axs.va.model.dto.TaskDTO;
import lv.axs.va.model.exception.TaskNotFoundException;
import lv.axs.va.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO task) {
        return ResponseEntity.ok(taskService.save(task));
    }

    @PostMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> createTasks(@RequestBody List<TaskDTO> task) {
        return ResponseEntity.ok(taskService.saveAll(task));
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDTO> findTaskById(@PathVariable(name = "id") String taskId) {
        return ResponseEntity.ok(taskService
                .findById(UUID.fromString(taskId))
                .orElseThrow(TaskNotFoundException::new));
    }

    @GetMapping("/tasks/all")
    public ResponseEntity<List<TaskDTO>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

}
