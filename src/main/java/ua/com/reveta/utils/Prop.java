package ua.com.reveta.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Prop {
    private static Prop ourInstance;
    private Properties prop;

    private Prop() {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("src\\main\\resources\\config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Prop getClazz() {
        if (ourInstance == null) {
            ourInstance = new Prop();
        }

        return ourInstance;
    }


    public static String getProp(String prop) {
        return getClazz().prop.getProperty(prop);
    }

    @Deprecated
    public static void addProp(String key, String value){
        //TODO Треба зробити так, щоб проперті записувалося
        //TODO зразу у файлик(перевіряло, чи вже є таке проперті)
        ourInstance.prop.setProperty(key, value);
    }



}
