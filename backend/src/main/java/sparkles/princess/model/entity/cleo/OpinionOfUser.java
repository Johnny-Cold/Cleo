package sparkles.princess.model.entity.cleo;

import lombok.Getter;

public enum OpinionOfUser {
    NONE("none"),
    LIKE("like"),
    FRIENDS("friends"),
    DISLIKE("dislike"),
    HATE("hate");

    @Getter
    private final String name;

    OpinionOfUser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
