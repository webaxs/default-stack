package lv.axs.va.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lv.axs.va.model.TaskStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDTO {

    private String id;
    private String createdAt;
    private String updatedAt;
    private String title;
    private String description;
    @Builder.Default
    private List<TaskProgressDTO> overallProgress = new ArrayList<>();
    private TaskStatus status;

}
