package sparkles.princess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparkles.princess.model.entity.dialogue.CleoDialogue;
import sparkles.princess.model.entity.cleo.OpinionOfUser;
import sparkles.princess.model.entity.cleo.Cleo;
import sparkles.princess.model.enums.DialogueType;
import sparkles.princess.model.enums.Mood;
import sparkles.princess.repository.CleoDialogueRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CleoDialogueServiceImpl implements CleoDialogueService {
    private CleoDialogueRepository repository;

    @Autowired
    public CleoDialogueServiceImpl(CleoDialogueRepository repository) {
        this.repository = repository;
    }

    public List<CleoDialogue> getDialogue(Mood mood, OpinionOfUser opinionOfUser) {
        return repository.findAllByMoodAndOpinionOfUser(mood, opinionOfUser);
    }

    public List<CleoDialogue> getGreetings(Cleo cleo) {
        Mood mood = cleo.getState().getMood();
        LocalDateTime lastActiveDate = cleo.getState().getLastActiveDateTime();
        return repository.findGreetings(lastActiveDate, mood);
    }

    public List<CleoDialogue> getFarewells(Cleo cleo) {
        Mood mood = cleo.getState().getMood();
        return repository.findAllByDialogueTypeAndMood(DialogueType.FAREWELL, mood);
    }
}
