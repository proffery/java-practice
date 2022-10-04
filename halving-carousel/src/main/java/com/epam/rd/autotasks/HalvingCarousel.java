package com.epam.rd.autotasks;

import java.util.Arrays;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }
    @Override
    public HalvingRun run() {
        if (!ifRun) {
            ifRun = true;
            return new HalvingRun();
        }
        return null;
    }
}
