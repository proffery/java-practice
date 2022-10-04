package com.epam.training.student_dmitry_shamko;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    @Override
    public GraduallyDecreasingRun run() {
        if (!ifRun) {
            ifRun = true;
            return new GraduallyDecreasingRun();
        }
        return null;
    }
}
