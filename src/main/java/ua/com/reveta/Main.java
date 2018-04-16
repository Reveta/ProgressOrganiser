package ua.com.reveta;

import ua.com.reveta.controller.IOFile;
import ua.com.reveta.model.Achievement;
import ua.com.reveta.model.OtherAchievement;
import ua.com.reveta.utils.Prop;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        IOFile ioFile = new IOFile();
        ioFile.findAchievement(1);
    }
}
