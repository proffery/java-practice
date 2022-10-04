package com.epam.rd.autotasks;

public class DecrementingCarousel {
    static int[] carousel;
    int i = 0;//Position
    static int capacity;
    boolean ifRun = false;
    public DecrementingCarousel(int capacity) {
        if (capacity > 0) {
            DecrementingCarousel.capacity = capacity;
            carousel = new int[capacity];
        }
    }

    public boolean addElement(int element){
        if (i == capacity || element <= 0 || ifRun) {
            return false;
        }
        carousel[i] = element;
        i++;
        return true;
    }

    public CarouselRun run(){
        if (!ifRun) {
            ifRun = true;
            return new CarouselRun();
        }
        return null;
    }
}
