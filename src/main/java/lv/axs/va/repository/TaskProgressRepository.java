package lv.axs.va.repository;

import lv.axs.va.model.TaskProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskProgressRepository extends JpaRepository<TaskProgress, UUID> {

}
