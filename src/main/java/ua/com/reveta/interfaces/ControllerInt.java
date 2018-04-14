package ua.com.reveta.interfaces;

import ua.com.reveta.model.Achievement;

import java.util.List;

public interface ControllerInt {

    void SaveAchievement();

    List<Achievement> FindAchievement();

    void OpenAchievement();

}
