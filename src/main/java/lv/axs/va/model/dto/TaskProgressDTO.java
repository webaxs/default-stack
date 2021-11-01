package lv.axs.va.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskProgressDTO {

    private String id;

    @NotNull(message = "taskId is not allowed to be null!")
    private String taskId;

    private String reportTitle;

    private String reportText;

    private Boolean done;

    private String createdAt;

    private String updatedAt;

}
