package sparkles.princess.model.entity.dialogue;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import sparkles.princess.model.BaseEntity;

import javax.persistence.*;

/**
 * @author Johnny Cold
 * */
@Getter
@Setter
@Table(name = "user_dialogue")
@Entity(name = "users_dialogue")
public class UserDialogue extends BaseEntity {

    @NonNull
    @Column(name = "dialogue", nullable = false)
    private String dialogue;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "cleo_parent_dialogue", nullable = false)
    private CleoDialogue cleoParentDialogue;
}
