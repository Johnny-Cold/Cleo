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

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class CleoDialogueServiceImpl implements CleoDialogueService {
    private CleoDialogueRepository repository;

    @Autowired
    public CleoDialogueServiceImpl(CleoDialogueRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CleoDialogue> getDialogue(Mood mood, OpinionOfUser opinionOfUser) {
        return repository.findAllByMoodAndOpinionOfUser(mood, opinionOfUser);
    }

    @Override
    public List<CleoDialogue> getGreetings(Cleo cleo) {
        Mood mood = cleo.getState().getMood();
        LocalDateTime lastActiveDate = cleo.getState().getLastActiveDateTime();
        LocalDateTime now = LocalDateTime.now();
        DialogueType greetingType = (Duration.between(now, lastActiveDate).toDays() > 7L) ? DialogueType.LONG_TIME_NO_SEE : DialogueType.GREETING;

        return repository.findGreetings(greetingType, mood);
    }

    @Override
    public List<CleoDialogue> getFarewells(Cleo cleo) {
        Mood mood = cleo.getState().getMood();
        return repository.findAllByDialogueTypeAndMood(DialogueType.FAREWELL, mood);
    }

    @Override
    public CleoDialogue greet(Cleo cleo) {
        Random random = new Random();
        List<CleoDialogue> greetings = getGreetings(cleo);
        return greetings.get(random.nextInt(greetings.size() - 1));
    }

    @Override
    public CleoDialogue valedict(Cleo cleo) {
        Random random = new Random();
        List<CleoDialogue> farewells = getFarewells(cleo);
        return farewells.get(random.nextInt(farewells.size() - 1));
    }


}
