package com.epam.training.student_dmitry_shamko;

public class CompleteByRequestTask implements Task {
    boolean isFinished;
    boolean complete;

    @Override
    public void execute() {
        if (complete) {
            isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
        complete = true;
    }
}
