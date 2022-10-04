package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    static int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        if (actionLimit > 0) {
            DecrementingCarouselWithLimitedRun.actionLimit = actionLimit;
        }
    }
    public CarouselRun run() {
        if (!ifRun) {
            ifRun = true;
            return new DecrementingWithLimitRun();
        }
        return null;
    }
}
