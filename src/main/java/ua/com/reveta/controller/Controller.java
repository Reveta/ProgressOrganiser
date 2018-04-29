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
        StringBuilder achievement = ioFile.findAchievement(id);
//        System.out.println();
        comfortableShowAchiv(achievement);
    }

    /**
     * Зробив неправильно. Викорисотвую try catch для правильного відтворення.
     * Принцип:
     * 1. Вивести приблизно всі перші поля окрім опису(description)
     * 2. Вивести циклом опис, методом добавлення довжини одного кроку
     * 3. Так як останній рядок дає помилку, вивести його вручну вдруге.
     * */
    private void comfortableShowAchiv(StringBuilder builder){
        int mark = 180;
        int oneLine = 80;
        System.out.println(builder.substring(0, mark));
        try {
            while (mark < builder.length()) {
                System.out.println(builder.substring(mark, mark + oneLine));
                mark += oneLine;
            }
        }catch (StringIndexOutOfBoundsException ignored){}
        System.out.println(builder.substring(mark, builder.length()));
    }

    public void openAchievement() {

    }


}
