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
import java.time.LocalTime;
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
        return repository.findGreetings(DialogueType.GREETING, mood);
    }

    @Override
    public List<CleoDialogue> getTimeOfDayGreetings(LocalDateTime localDateTime, Cleo cleo) {
        Mood mood = cleo.getState().getMood();
        DialogueType greetingType = null;

        LocalDateTime midnight = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.of(0, 0, 0));
        LocalDateTime noon = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.of(12, 0, 0));
        LocalDateTime night = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.of(17, 0, 0));

        if (isBetween(localDateTime, noon, midnight)) {
            greetingType = DialogueType.MORNING_GREETING;
        } else if (isBetween(localDateTime, night, noon)) {
            greetingType = DialogueType.NOON_GREETING;
        } else if (isBetween(localDateTime, midnight, night)) {
            greetingType = DialogueType.NIGHT_GREETING;
        }

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

    private boolean isBetween(LocalDateTime dateTime, LocalDateTime beforeDateTime, LocalDateTime afterDateTime) {
        return dateTime.isBefore(beforeDateTime) && dateTime.isAfter(afterDateTime);
    }
}
