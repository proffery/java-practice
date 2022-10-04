package com.epam.rd.autotasks;

public class CarouselRun {
    int position = 0;
    public int next() {
       int count = 0;
       while (count < DecrementingCarousel.carousel.length &&
               DecrementingCarousel.carousel[position %= DecrementingCarousel.carousel.length] <= 0) {
           position++;
           count++;
       }
       if (count == DecrementingCarousel.carousel.length) {
           return -1;
       }
       return DecrementingCarousel.carousel[position++]--;

    }
    public boolean isFinished() {
        for (int i = 0; i < DecrementingCarousel.carousel.length; i++){
            if(DecrementingCarousel.carousel[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
