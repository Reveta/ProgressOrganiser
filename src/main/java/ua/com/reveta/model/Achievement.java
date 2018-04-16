package ua.com.reveta.model;

import com.Utils;
import lombok.Getter;
import lombok.Setter;
import ua.com.reveta.controller.Controller;
import ua.com.reveta.controller.IOFile;
import ua.com.reveta.interfaces.ControllerInt;
import ua.com.reveta.interfaces.SwitchInt;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
public abstract class Achievement {
    private int id;
    private AchievementType achievementType;
    private String data;
    private Color color;
    private String description;

    static ControllerInt controller = new Controller();

    Achievement() {
        this.id = IOFile.getTOFile().getNumFiles()+1;
    }

    public static Achievement createAchievement() {
        Achievement achievement = null;
        AchievementType achievementType = choiceAchievementType();

        switch (achievementType) {
            case LEETCODE_EXERCISE:
                achievement = new LeetCodeExercise();
                break;
            case EPAM_EXERCISE:
                achievement = new EpamExercise();
                break;
            case OTHER_ACHIVMENT:
                achievement = new OtherAchievement();
                break;
        }

        System.out.print("Напиши опис: ");
        achievement.setDescription(new Scanner(System.in).nextLine());

        System.out.println("Введи час та дату");
        achievement.data = Utils.scanStr();

        return achievement;
    }

    private static AchievementType choiceAchievementType() {
        AtomicReference<AchievementType> achievementType = new AtomicReference<>();

        SwitchInt switchInt = choice -> {
            switch (choice) {
                case 1:
                    achievementType.set(AchievementType.LEETCODE_EXERCISE);
                    break;
                case 2:
                    achievementType.set(AchievementType.EPAM_EXERCISE);
                    break;
                case 3:
                    achievementType.set(AchievementType.OTHER_ACHIVMENT);
                    break;
            }
        };

        while (achievementType.get() == null) {
            System.out.println("Вибери тип досягнення:" +
                    Utils.GREEN + "\n LeetCode" + Utils.RESET +
                    Utils.RED + "\n Epam" + Utils.RESET +
                    Utils.BLUE + "\n Особливе досягнення" + Utils.RESET
            );
            switchInt.choiceIt(Utils.scanInt());
        }

        return achievementType.get();
    }

    public enum Color {
        BLUE,
        GREEN,
        YELLOW,
        Light_RED,
        RED;
    }


   public void setAchievementType(AchievementType achievementType) {
        this.achievementType = achievementType;
    }

   public void setColor(Color color) {
        this.color = color;
    }

   public void setDescription(String description) {
        this.description = description;
    }

   public int getId() {
        return id;
    }

    public AchievementType getAchievementType() {
        return achievementType;
    }

    @Override
    public String toString() {
        return "id=" + id + ", \n" +
                "achievementType=" + achievementType + ", \n" +
                "time=" + data + ", \n" +
                "color=" + color + ", \n" +
                "description='" + description;
    }
}
