package lv.axs.va.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(indexes = {
        @Index(columnList = "createdAt", name = "tp_idx_by_creation_date"),
        @Index(columnList = "updatedAt", name = "tp_idx_by_update_date")
})
public class TaskProgress implements Serializable {

    private static final long serialVersionUID = -90213562364785739L;

    @Id
    @Column(columnDefinition = "VARBINARY(16)", nullable = false, unique = true)
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name="createdAt", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(length = 128)
    private String reportTitle;

    @Lob
    private String reportText;

    @ManyToOne
    @JoinColumn(name="task_id", nullable=false)
    private Task task;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean done;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskProgress that = (TaskProgress) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "TaskProgress(id=" + this.id + ")";
    }

}
