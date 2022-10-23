package sparkles.princess.model.entity.dialogue;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import sparkles.princess.model.BaseEntity;
import sparkles.princess.model.entity.cleo.OpinionOfUser;
import sparkles.princess.model.enums.DialogueType;
import sparkles.princess.model.enums.Mood;

import javax.persistence.*;

/**
 * @author Johnny Cold
 * */
@Getter
@Setter
@Table(name = "cleo_dialogue")
@Entity(name = "cleo_dialogue")
public class CleoDialogue extends BaseEntity {

    @NonNull
    @Column(name = "dialogue", nullable = false)
    private String dialogue;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_parent_dialogue")
    private UserDialogue userParentDialogue;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "mood", nullable = false, columnDefinition = "varchar(25) default none")
    private Mood mood;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private DialogueType type;

    @Column(name = "current_line")
    private Boolean currentLine;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "opinion_of_user", nullable = false, columnDefinition = "varchar(25) default none")
    private OpinionOfUser opinionOfUser;

    @Column(name = "audio_file_name")
    private String audioFileName;

    public CleoDialogue(String dialogue, UserDialogue userParentDialogue, Mood mood, DialogueType type, Boolean currentLine, OpinionOfUser opinionOfUser, String audioFileName) {
        this.dialogue = dialogue;
        this.userParentDialogue = userParentDialogue;
        this.mood = mood;
        this.type = type;
        this.currentLine = currentLine;
        this.opinionOfUser = opinionOfUser;
        this.audioFileName = audioFileName;
    }

    public CleoDialogue(String dialogue, Mood mood, DialogueType type, Boolean currentLine, OpinionOfUser opinionOfUser, String audioFileName) {
        this(dialogue, null, mood, type, currentLine, opinionOfUser, audioFileName);
    }

    public CleoDialogue(String dialogue, DialogueType type, Boolean currentLine, OpinionOfUser opinionOfUser, String audioFileName) {
        this(dialogue, null, type, currentLine, opinionOfUser, audioFileName);
    }
}
