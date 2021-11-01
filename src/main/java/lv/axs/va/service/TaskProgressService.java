package lv.axs.va.service;

import lombok.AllArgsConstructor;
import lv.axs.va.mapper.TaskProgressToDto;
import lv.axs.va.model.TaskProgress;
import lv.axs.va.model.dto.TaskProgressDTO;
import lv.axs.va.repository.TaskProgressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class TaskProgressService {

    private final TaskProgressRepository taskProgressRepository;
    private final TaskProgressToDto taskProgressMapper;

    public Optional<TaskProgress> findById(UUID id) {
        return taskProgressRepository.findById(id);
    }

    public TaskProgressDTO save(TaskProgressDTO taskProgressDto) {
       TaskProgress t = taskProgressMapper.taskProgressFromDto(taskProgressDto);
       return taskProgressMapper.dtoFromTaskProgress(taskProgressRepository.save(t));
    }

}
