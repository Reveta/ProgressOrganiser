package ua.com.reveta.model;

import lombok.Getter;
import lombok.Setter;
import ua.com.reveta.controller.IOFile;

@Getter
@Setter
public abstract class Achievement {
    private int id;
    private AchievementType achievementType;
    private Color color;
    private String description;

    Achievement() {
        this.id = 0001;
    }

    @Override
    public String toString() {
        return  "id=" + id +", \n"+
                "achievementType=" + achievementType +", \n"+
                "color=" + color +", \n"+
                "description='" + description;
    }

    enum Color{
        GREEN,
        YELLOW,
        Light_RED,
        RED;
    }


    void setAchievementType(AchievementType achievementType) {
        this.achievementType = achievementType;
    }

    void setColor(Color color) {
        this.color = color;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AchievementType getAchievementType() {
        return achievementType;
    }

    public Color getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }
}
