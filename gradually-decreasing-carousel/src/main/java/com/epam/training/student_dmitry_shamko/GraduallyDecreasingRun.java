package com.epam.training.student_dmitry_shamko;

public class GraduallyDecreasingRun extends CarouselRun {
    int[] arrayFactor = new int[GraduallyDecreasingCarousel.carousel.length];

    public int next() {
        int count = 0;
        int previos;

        if (position < GraduallyDecreasingCarousel.carousel.length) {
            arrayFactor[position]++;
            previos = GraduallyDecreasingCarousel.carousel[position];
            GraduallyDecreasingCarousel.carousel[position] -= arrayFactor[position];
            position++;
            if (previos <= 0) {
                return  -1;
            }

            while (count < GraduallyDecreasingCarousel.carousel.length &&
                    GraduallyDecreasingCarousel.carousel[position %= GraduallyDecreasingCarousel.carousel.length] <= 0) {
                count++;
                position++;

            }

        }
        else {
            return -1;
        }
        return previos;
    }
    @Override
    public boolean isFinished() {
        for (int i = 0; i < GraduallyDecreasingCarousel.carousel.length; i++) {
            if (GraduallyDecreasingCarousel.carousel[i] > arrayFactor[i]) {
                return false;
            }
        }
        return true;
    }

}
