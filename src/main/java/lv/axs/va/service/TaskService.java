package lv.axs.va.service;

import lombok.AllArgsConstructor;
import lv.axs.va.mapper.TaskToDto;
import lv.axs.va.model.dto.TaskDTO;
import lv.axs.va.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskToDto taskToDto;

    public TaskDTO save(TaskDTO task) {
        return taskToDto.toDto(taskRepository.save(taskToDto.fromDto(task)));
    }

    public List<TaskDTO> saveAll(List<TaskDTO> tasks) {
        return taskRepository.saveAll(
                tasks.stream()
                        .map(taskToDto::fromDto)
                        .collect(Collectors.toList())
        )
                .stream().map(taskToDto::toDto)
                .collect(Collectors.toList());

    }

    public Optional<TaskDTO> findById(UUID id) {
        return Optional.of(taskToDto.toDto(taskRepository.findById(id).get()));
    }

    public List<TaskDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskToDto::toDto)
                .collect(Collectors.toList());
    }

}
