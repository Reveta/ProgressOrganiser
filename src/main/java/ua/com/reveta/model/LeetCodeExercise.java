package ua.com.reveta.model;

import com.Utils;
import lombok.Getter;
import lombok.Setter;
import ua.com.reveta.interfaces.EnterColor;

@Setter
@Getter
public class LeetCodeExercise extends Achievement {

    private String link;
    private int numLeetCode;

    public LeetCodeExercise() {
        super();
        this.setAchievementType(AchievementType.LEETCODE_EXERCISE);
        this.createLeetCodeExercise();
    }

    private LeetCodeExercise createLeetCodeExercise() {

        this.enterColor();
        System.out.print("Встав посилання: ");
        this.link = Utils.scanStr();
        System.out.print("Встав номер завдання: ");
        this.numLeetCode = Utils.scanInt();
        return this;
    }

    private void enterColor() {
        System.out.println("Вибери колір:");
        System.out.println("1. Зелений");
        System.out.println("2. Жовтий");
        System.out.println("3. Червоний");

        EnterColor enterColorLam = (() -> {
            Color color = null;
            switch (Utils.scanInt()) {
                case 1:
                    color = Color.GREEN;
                    break;
                case 2:
                    color = Color.YELLOW;
                    break;
                case 3:
                    color = Color.RED;
                    break;
                default:
                    System.out.println("Промазав!");
                    enterColor();
                    break;
            }
            this.setColor(color);
        });
        enterColorLam.enter();
    }

    @Override
    public String toString() {
        return Utils.GREEN + "LeetCodeExercise: " + Utils.RESET + "\n" +
                super.toString() + '\'' + ", \n" +
                "link='" + link + '\'' + ", \n" +
                "numLeetCode=" + numLeetCode + ";";
    }

}

