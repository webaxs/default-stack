package lv.axs.va.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MY_TASKS", indexes = {
        @Index(columnList = "createdAt", name = "t_idx_by_creation_date"),
        @Index(columnList = "updatedAt", name = "t_idx_by_update_date")
})
public class Task implements Serializable {

    private static final long serialVersionUID = -9021356236478573179L;

    @Id
    @Column(columnDefinition = "VARBINARY(16)", nullable = false, unique = true)
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(name = "createdAt", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(length = 128)
    private String title;

    @Lob
    private String description;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TaskProgress> overallProgress = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(length = 64)
    private TaskStatus status;

    public void setOverallProgress(List<TaskProgress> overallProgress) {
        if (this.overallProgress == null) {
            this.overallProgress = overallProgress;
        } else {
            this.overallProgress.retainAll(overallProgress);
            this.overallProgress.addAll(overallProgress);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task that = (Task) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "Task(id=" + this.id + ")";
    }

}
