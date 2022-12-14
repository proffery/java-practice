package com.epam.training.student_dmitry_shamko.house;

import java.util.ArrayList;
import java.util.List;

public class House <C> {

    private final List <C> residents = new ArrayList<>();

    public void enter(C resident) {
        residents.add(resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are following residents in the house:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }
}
