package ua.com.reveta.model;

import com.Utils;

public class OtherAchievement extends Achievement {

    public OtherAchievement() {
        super();
        this.setAchievementType(AchievementType.OTHER_ACHIVMENT);
        this.setColor(Color.BLUE);
        System.out.print("Напиши опис: ");
        this.setDescription(Utils.scanStr());
    }

    @Override
    public String toString() {
        return Utils.BLUE + "EpamExercise{" + Utils.RESET +
                super.toString() +
                '}';
    }

}
