package lv.axs.va.mapper;

import lv.axs.va.model.TaskProgress;
import lv.axs.va.model.dto.TaskProgressDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses= {StringToUUID.class, TaskFromString.class})
public interface TaskProgressToDto {

    @Mapping(target="task", source="dto.taskId", qualifiedByName="taskFromId")
    TaskProgress taskProgressFromDto(TaskProgressDTO dto);

    @InheritInverseConfiguration
    @Mapping(target="taskId", source="dto.task", qualifiedByName="idFromTask")
    TaskProgressDTO dtoFromTaskProgress(TaskProgress dto);

}
