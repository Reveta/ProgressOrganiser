package ua.com.reveta.interfaces;

import ua.com.reveta.model.Achievement;

@FunctionalInterface
public interface CreateAch {
    Achievement create(Achievement achievement);
}
