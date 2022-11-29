package sparkles.princess.model.entity.cleo;

import lombok.Getter;
import lombok.Setter;
import sparkles.princess.model.enums.Mood;

public class Cleo {
    @Getter
    @Setter
    private CleoState state;

    public boolean likesUser() {
        return state.getOpinionOfUser().equals(OpinionOfUser.LIKE);
    }

    public boolean dislikesUser() {
        return state.getOpinionOfUser().equals(OpinionOfUser.DISLIKE);
    }

    public boolean friendsWithUser() {
        return state.getOpinionOfUser().equals(OpinionOfUser.FRIENDS);
    }

    public boolean hatesUser() {
        return state.getOpinionOfUser().equals(OpinionOfUser.HATE);
    }

    public boolean isHappy() {
        return state.getMood().equals(Mood.HAPPY);
    }

    public boolean isSad() {
        return state.getMood().equals(Mood.SAD);
    }

    public boolean isBored() {
        return state.getMood().equals(Mood.BORED);
    }

    public boolean isAngry() {
        return state.getMood().equals(Mood.ANGRY);
    }

    public boolean isAnnoyed() {
        return state.getMood().equals(Mood.ANNOYED);
    }

    public boolean isEgo() {
        return state.getMood().equals(Mood.EGO);
    }
}
