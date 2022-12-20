package sparkles.princess.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sparkles.princess.model.entity.cleo.Cleo;
import sparkles.princess.model.entity.cleo.CleoState;
import sparkles.princess.model.entity.cleo.OpinionOfUser;
import sparkles.princess.model.entity.dialogue.CleoDialogue;
import sparkles.princess.model.enums.DialogueType;
import sparkles.princess.model.enums.Mood;
import sparkles.princess.repository.CleoDialogueRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static sparkles.princess.util.PrincessUtils.filter;

@RunWith(MockitoJUnitRunner.class)
public class CleoDialogueServiceImplTest extends TestCase {

    @Mock
    private CleoDialogueRepository repository;

    @InjectMocks
    private CleoDialogueServiceImpl service;

    @Test
    public void getListOfGreetings() {
        OpinionOfUser opinionOfUser = OpinionOfUser.NONE;
        Mood mood = Mood.NONE;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusDays(1);
        Cleo cleo = createCleo(mood, opinionOfUser, yesterday, yesterday);
        List<CleoDialogue> expected = Arrays.asList(new CleoDialogue("Hello", DialogueType.GREETING, false, opinionOfUser, null));
        when(repository.findGreetings(DialogueType.GREETING, mood)).thenReturn(expected);
        List<CleoDialogue> actual = service.getGreetings(cleo);
        assertEquals(expected, actual);
    }

    @Test
    public void getTimeOfDayGreetingsReturnsMorningGreetings_When_itIsCurrentlyMorning() {
        OpinionOfUser opinionOfUser = OpinionOfUser.NONE;
        Mood mood = Mood.NONE;
        LocalDateTime sixInTheMorning = LocalDateTime.of(LocalDate.now(), LocalTime.of(6, 0, 0));
        LocalDateTime yesterday = sixInTheMorning.minusDays(1);
        Cleo cleo = createCleo(mood, opinionOfUser, yesterday, yesterday);
        List<CleoDialogue> expected = Arrays.asList(new CleoDialogue("Good morning.", DialogueType.MORNING_GREETING, false, opinionOfUser, null));
        when(repository.findGreetings(DialogueType.MORNING_GREETING, mood)).thenReturn(expected);
        List<CleoDialogue> actual = service.getTimeOfDayGreetings(sixInTheMorning, cleo);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFarewells() {
        LocalDateTime today = LocalDateTime.now();
        OpinionOfUser opinionOfUser = OpinionOfUser.NONE;
        Mood mood = Mood.NONE;
        Cleo cleo = createCleo(mood, opinionOfUser, today, today);
        List<CleoDialogue> expected = Arrays.asList(new CleoDialogue("Goodbye", DialogueType.FAREWELL, false, opinionOfUser, null));
        when(repository.findAllByDialogueTypeAndMood(DialogueType.FAREWELL, mood)).thenReturn(expected);
        List<CleoDialogue> actual = service.getFarewells(cleo);
        assertEquals(expected, actual);
    }

    public void testGreet() {
    }

    public void testValedict() {
    }

    private Cleo createCleo(Mood mood, OpinionOfUser opinionOfUser, LocalDateTime createdDateTime, LocalDateTime lastActiveDateTime) {
        CleoState state = new CleoState(mood, opinionOfUser, createdDateTime, lastActiveDateTime);
        Cleo cleo = new Cleo();
        cleo.setState(state);
        return cleo;
    }
}