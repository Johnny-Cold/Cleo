package sparkles.princess.model.enums;

import lombok.Getter;

public enum DialogueType {
    GREETING("greeting"),
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
