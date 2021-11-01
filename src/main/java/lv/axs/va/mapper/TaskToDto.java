package lv.axs.va.mapper;

import lv.axs.va.model.Task;
import lv.axs.va.model.dto.TaskDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(uses =
        {
                StringToUUID.class,
                TaskProgressToDto.class,
                LocalDateTimeToString.class,
                TaskFromString.class
        })
public interface TaskToDto {

    Task fromDto(TaskDTO dto);

    @InheritInverseConfiguration
    TaskDTO toDto(Task dto);

}
