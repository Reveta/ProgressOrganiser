package ua.com.reveta.model;

import com.Utils;

public class EpamExercise extends Achievement {

    public EpamExercise() {

        super();
        this.setAchievementType(AchievementType.EPAM_EXERCISE);
        this.setColor(Color.Light_RED);

    }

    @Override
    public String toString() {
        return Utils.RED + "EpamExercise{" + Utils.RESET + "\n" +
                super.toString() +
                '}';
    }
}
