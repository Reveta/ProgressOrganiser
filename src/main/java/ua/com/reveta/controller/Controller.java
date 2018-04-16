package ua.com.reveta.controller;

import com.Utils;
import ua.com.reveta.interfaces.ControllerInt;
import ua.com.reveta.interfaces.CreateAch;
import ua.com.reveta.model.Achievement;

import java.util.concurrent.atomic.AtomicBoolean;

public class Controller implements ControllerInt {

    IOFile ioFile = IOFile.getTOFile();

    public void saveAchievement() {
        Achievement achievement = null;
        CreateAch createAch = ach -> {
            ach = Achievement.createAchievement();
            return ach;
        };
        achievement = createAch.create(achievement);

        AtomicBoolean conti = new AtomicBoolean(true);

        CreateAch ach = (achiev) -> {
            System.out.println("1. Щоб перестворити подію\n751. Щоб зберегти");
            switch (Utils.scanInt()) {
                case 1:
                    achiev = createAch.create(achiev);
                    break;
                case 751:
                    conti.set(false);
                    break;
                default:
                    System.out.println("Не то ввів");
                    break;
            }
            return achiev;
        };
        while (conti.get()){
            System.out.println(achievement.toString() + "\n");
            ach.create(achievement);
        }




        ioFile.saveAchievement(achievement);

    }

    public void findAchievement() {
        System.out.println("Введи номер досягнення");
        int id = Utils.scanInt();
        System.out.println(ioFile.findAchievement(id));
    }

    public void openAchievement() {

    }


}
