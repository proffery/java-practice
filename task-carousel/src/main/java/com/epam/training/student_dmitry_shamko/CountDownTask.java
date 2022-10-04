package com.epam.training.student_dmitry_shamko;

public class CountDownTask implements Task {
    int value;
    public CountDownTask(int value) {
        if (value < 0) {
            value = 0;
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        if (!isFinished()) {
            this.value--;
        }
    }

    @Override
    public boolean isFinished() {
        return value == 0;
    }
}
