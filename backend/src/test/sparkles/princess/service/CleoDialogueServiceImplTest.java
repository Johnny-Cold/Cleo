package sparkles.princess.service;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import sparkles.princess.model.entity.cleo.Cleo;
import sparkles.princess.model.entity.cleo.OpinionOfUser;
import sparkles.princess.model.entity.dialogue.CleoDialogue;
import sparkles.princess.model.enums.DialogueType;
import sparkles.princess.model.enums.Mood;
import sparkles.princess.repository.CleoDialogueRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import sparkles.princess.model.entity.cleo.*;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

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
        CleoDialogue greeting1 = new CleoDialogue("Hello", DialogueType.GREETING, false, opinionOfUser, null);
        CleoDialogue greeting2 = new CleoDialogue("It has been quite some time.", DialogueType.OBSERVATION, false, opinionOfUser, null);
        List<CleoDialogue> greetings = Arrays.asList(greeting1, greeting2);
        when(repository.findGreetings(DialogueType.GREETING, mood)).thenReturn(greetings.subList(0, 1));
        List<CleoDialogue> result = service.getGreetings(cleo);
        assertEquals(greetings.subList(0, 1), result);
    }

    public void testGetGreetings() {
    }

    public void testGetFarewells() {
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