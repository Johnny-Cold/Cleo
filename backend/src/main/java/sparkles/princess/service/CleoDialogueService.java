package sparkles.princess.service;

import sparkles.princess.model.entity.cleo.Cleo;
import sparkles.princess.model.entity.cleo.OpinionOfUser;
import sparkles.princess.model.entity.dialogue.CleoDialogue;
import sparkles.princess.model.enums.Mood;

import java.util.List;

public interface CleoDialogueService {
    List<CleoDialogue> getDialogue(Mood mood, OpinionOfUser opinionOfUser);

    List<CleoDialogue> getGreetings(Cleo cleo);

    List<CleoDialogue> getFarewells(Cleo cleo);

    CleoDialogue greet(Cleo cleo);

    CleoDialogue valedict(Cleo cleo);
}
