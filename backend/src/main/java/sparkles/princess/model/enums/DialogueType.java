package sparkles.princess.model.enums;

import lombok.Getter;

public enum DialogueType {
    GREETING("greeting"),
    MORNING_GREETING("morning_greeting"),
    NOON_GREETING("noon_greeting"),
    EVENING_GREETING("evening_greeting"),
    NIGHT_GREETING("night_greeting"),
    LATE_GREETING("greeting"),
    LONG_TIME_NO_SEE("long time no see"),
    DIALOGUE("dialogue"),
    RANDOM("random"),
    OBSERVATION("observation"),
    FAREWELL("farewell");

    @Getter
    private final String name;

    DialogueType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
