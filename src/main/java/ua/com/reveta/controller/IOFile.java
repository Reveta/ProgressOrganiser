package ua.com.reveta.controller;

import lombok.Getter;
import lombok.Setter;
import ua.com.reveta.interfaces.IOFileInt;
import ua.com.reveta.model.Achievement;

import java.io.*;
import java.util.Properties;

@Getter
@Setter
public class IOFile implements IOFileInt {

    private int sizeAchievement;

    private static IOFile ioFile;

    public static IOFile getTOFile() {
        if (ioFile != null) {
            ioFile = new IOFile();
        }

        return ioFile;
    }

    public void InputAchievement(Achievement achievement) {

    }

    public void OutputAchievement() {

    }

    public static void creatFolders() {


        Properties prop = new Properties();
        try {
//            prop.load(new FileInputStream("../resources/config.properties"));
            prop.load(new FileInputStream("/config.properties"));

            System.out.println(prop.getProperty("toRepository"));
//
//            File folder = new File(prop.getProperty("toRepository") + "Prog/Organiser/Achives/");
//            folder.mkdirs();
//            File file = new File(prop.getProperty("toRepository") + "test.txt");
//
//
//            PrintWriter writer = new PrintWriter(new FileWriter(file));
//            writer.write("Hello me!432");
//            writer.close();
        } catch (IOException e) {
            System.out.println("Помилка(((");
            e.printStackTrace();
        }
//
    }

}
