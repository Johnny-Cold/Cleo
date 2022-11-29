package sparkles.princess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sparkles.princess.model.entity.dialogue.CleoDialogue;
import sparkles.princess.model.entity.cleo.OpinionOfUser;
import sparkles.princess.model.enums.DialogueType;
import sparkles.princess.model.enums.Mood;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CleoDialogueRepository extends JpaRepository<CleoDialogue, Long> {
    List<CleoDialogue> findAllByMoodAndOpinionOfUser(Mood mood, OpinionOfUser opinionOfUser);
    List<CleoDialogue> findAllByDialogueTypeAndMood(DialogueType type, Mood mood);

    @Query("select g from CleoDialogue g where g.type = ?1 and g.mood = ?2")
    List<CleoDialogue> findGreetings(DialogueType greetingType, Mood mood);
}
