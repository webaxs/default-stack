package lv.axs.va.controller;

import lombok.AllArgsConstructor;
import lv.axs.va.model.TaskProgress;
import lv.axs.va.model.dto.TaskProgressDTO;
import lv.axs.va.model.exception.TaskProgressNotFoundException;
import lv.axs.va.service.TaskProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TaskProgressController {

    private final TaskProgressService taskProgressService;

    @GetMapping("/task-progress/{id}")
    public ResponseEntity<TaskProgress> findTaskProgressById(@PathVariable(name = "id") String taskId) {
        return ResponseEntity.ok(taskProgressService
                .findById(UUID.fromString(taskId))
                .orElseThrow(TaskProgressNotFoundException::new));
    }

    @PostMapping("/task-progress")
    public ResponseEntity<TaskProgressDTO> saveOne(@RequestBody TaskProgressDTO taskProgressDTO) {
        return ResponseEntity.ok(taskProgressService
                .save(taskProgressDTO));
    }

    @PostMapping("/task-progresses")
    public ResponseEntity<List<TaskProgressDTO>> saveMany(@RequestBody List<TaskProgressDTO> taskProgressDTOS) {
        return ResponseEntity.ok(taskProgressDTOS.stream().map(taskProgressService::save).collect(Collectors.toList()));
    }

}
