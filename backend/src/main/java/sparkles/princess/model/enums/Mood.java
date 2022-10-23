package sparkles.princess.model.enums;

import lombok.Getter;

public enum Mood {
    NONE("none"),
    HAPPY("happy"),
    SAD("sad"),
    ANGRY("angry"),
    ANNOYED("annoyed"),
    BORED("bored"),
    SLEEPY("sleepy"),
    EGO("ego");

    @Getter
    private final String name;

    Mood(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
