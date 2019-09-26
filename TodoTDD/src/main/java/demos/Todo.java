package demos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    private LocalDateTime completedAt;

    public Todo() {
    }

    public Todo(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void markComplete() {
        this.completedAt = LocalDateTime.now();
    }

    public boolean isCompete() {
        return completedAt != null;
    }
}
