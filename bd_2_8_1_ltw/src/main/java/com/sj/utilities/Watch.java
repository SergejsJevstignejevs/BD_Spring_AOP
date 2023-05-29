package com.sj.utilities;

import org.springframework.stereotype.Component;

@Component
public class Watch implements FictiveWatch {

    public void sleeping(long timeMillis) throws InterruptedException {
        Thread.sleep(timeMillis);
        System.out.println("Slept " + timeMillis + " ms");
    }

}
