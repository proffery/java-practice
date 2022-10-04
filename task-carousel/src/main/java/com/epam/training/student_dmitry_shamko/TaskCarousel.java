package com.epam.training.student_dmitry_shamko;
public class TaskCarousel {
    int capacity;
    Task[] arrayTaskArgument;
    int addPosition = 0;
    int executePosition = 0;

    public TaskCarousel(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        this.capacity = capacity;
        arrayTaskArgument = new Task[capacity];

    }

    public boolean addTask(Task task) {
        if (isFull() || task == null || task.isFinished()) {
            return false;
        }
        int count = 0;
        while (count < capacity && arrayTaskArgument[addPosition %= capacity] != null) {
            addPosition++;
            count++;
        }
        arrayTaskArgument[addPosition] = task;
        return true;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        int count = 0;
        while (count < capacity && arrayTaskArgument[executePosition %= capacity] == null) {
            executePosition++;
            count++;
        }
        arrayTaskArgument[executePosition].execute();
        if (arrayTaskArgument[executePosition].isFinished()) {
            arrayTaskArgument[executePosition] = null;
        }
        executePosition++;
        return true;
    }

    public boolean isFull() {
        for (var val:arrayTaskArgument) {
            if (val == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
         for (int i = 0; i < capacity; i++) {
             if (arrayTaskArgument[i] != null) {
                 return false;
             }
        }
        return true;
    }
}
