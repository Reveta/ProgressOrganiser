package ua.com.reveta.controller;

import com.Utils;
import ua.com.reveta.interfaces.ControllerInt;
import ua.com.reveta.model.Achievement;

public class Controller implements ControllerInt {

    IOFile ioFile = IOFile.getTOFile();

    public void saveAchievement() {
        Achievement achievement = Achievement.createAchievement();

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
