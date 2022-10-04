package com.epam.training.student_dmitry_shamko;

public class HalvingRun extends CarouselRun {
    @Override
    public int next() {
        int count = 0;
        int previos = 0;
        if (count == HalvingCarousel.carousel.length || isFinished()) {
            return -1;
        }
        if (position < HalvingCarousel.carousel.length) {
            previos = HalvingCarousel.carousel[position];
            HalvingCarousel.carousel[position] = HalvingCarousel.carousel[position] / 2;
            position++;
        }
        while (count <= HalvingCarousel.carousel.length &&
                HalvingCarousel.carousel[position %= HalvingCarousel.carousel.length] < 1) {
            count++;
            position++;
        }
        return previos;
    }

}
