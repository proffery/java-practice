package com.epam.training.student_dmitry_shamko;

public class DecrementingWithLimitRun extends CarouselRun {
    public int next() {
        if (isFinished()) {
            return -1;
        }
        DecrementingCarouselWithLimitedRun.actionLimit--;
        int count = 0;
        int previos;
        previos = DecrementingCarouselWithLimitedRun.carousel[position];
        DecrementingCarouselWithLimitedRun.carousel[position]--;
        position++;
        while (count < DecrementingCarouselWithLimitedRun.carousel.length &&
                DecrementingCarouselWithLimitedRun.carousel[position %= DecrementingCarouselWithLimitedRun.carousel.length] <= 0) {
            position++;
            count++;
        }
        return previos;


    }
    @Override
    public boolean isFinished() {
        for (int i = 0; i < DecrementingCarouselWithLimitedRun.carousel.length; i++){
            if (DecrementingCarouselWithLimitedRun.carousel[i] > 0 && DecrementingCarouselWithLimitedRun.actionLimit > 0) {
                return false;
            }
        }
        return true;
    }
}
