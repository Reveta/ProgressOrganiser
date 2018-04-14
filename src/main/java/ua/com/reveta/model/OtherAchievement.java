package ua.com.reveta.model;

import com.Utils;

public class OtherAchievement extends Achievement {

    public OtherAchievement() {
        super();
        this.setAchievementType(AchievementType.EPAM_EXERCISE);
        this.setColor(Color.Light_RED);
        System.out.print("Напиши опис: ");
        this.setDescription(Utils.scanStr());
    }


}
