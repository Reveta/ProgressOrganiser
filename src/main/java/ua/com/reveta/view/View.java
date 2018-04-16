package ua.com.reveta.view;


import com.Utils;
import ua.com.reveta.controller.Controller;

public class View{

    Controller controller = new Controller();

    public void startProgram(){
        frontMenu();
    }

    private void frontMenu(){
        String messege =
                "Вибери дію:" +
                        "\n 1. Додати досягнення;" +
                        "\n 2. Оглянути досягнення;";

        System.out.println(messege);
        switch (Utils.scanInt()){
            case 1: controller.saveAchievement(); break;
            case 2: controller.findAchievement(); break;
        }
    }
}
