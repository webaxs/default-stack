package lv.axs.va.mapper;

import lv.axs.va.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface TaskFromString {

    @Named("taskFromId")
    default Task taskFromId(String id) {
        return Task.builder().id(UUID.fromString(id)).build();
    }

    @Named("idFromTask")
    default String idFromTask(Task task) {
        return Optional.ofNullable(task.getId())
                .orElse(UUID.randomUUID()).toString();
    }

}
