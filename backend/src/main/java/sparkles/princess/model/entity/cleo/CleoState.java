package sparkles.princess.model.entity.cleo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import sparkles.princess.model.BaseEntity;
import sparkles.princess.model.enums.Mood;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Table(name = "cleo_state")
@Entity(name = "cleo_state")
public class CleoState extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "mood", nullable = false, columnDefinition = "varchar(100) default 'happy'")
    private Mood mood;

    @Enumerated(EnumType.STRING)
    @Column(name = "opinion_of_user", columnDefinition = "varchar(100) default 'none'")
    private OpinionOfUser opinionOfUser;

    @NonNull
    @Column(name = "created_date_time", nullable = false, updatable = false)
    private LocalDateTime createdDateTime;

    @NonNull
    @Column(name = "last_active_date_time", nullable = false)
    private LocalDateTime lastActiveDateTime;

    public CleoState(Mood mood, OpinionOfUser opinionOfUser, @NonNull LocalDateTime createdDateTime, @NonNull LocalDateTime lastActiveDateTime) {
        this.mood = mood;
        this.opinionOfUser = opinionOfUser;
        this.createdDateTime = createdDateTime;
        this.lastActiveDateTime = lastActiveDateTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mood, opinionOfUser, createdDateTime, lastActiveDateTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CleoState)) return false;
        if (!super.equals(obj)) return false;

        CleoState cleoState = (CleoState) obj;
        return (mood == cleoState.mood)
                && (opinionOfUser == cleoState.opinionOfUser)
                && (Objects.equals(createdDateTime, cleoState.createdDateTime))
                && (Objects.equals(lastActiveDateTime, cleoState.lastActiveDateTime));
    }
}
