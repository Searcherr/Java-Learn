package org.example;

import lombok.Data;
import lombok.NonNull;

import java.lang.reflect.Array;
import java.util.List;

// 55. Write a Java program to convert seconds to hour, minute and seconds.
@Data
public class Clock {
    @NonNull
    private int seconds;
    private int minutes = 0;
    private int hours = 0;

    public Clock(int seconds) {
        if (seconds < 0) {
            throw new RuntimeException("Please input positive value");
        } else {
            this.seconds = seconds;
            this.setHours();
            this.setMinutes();
        }
    }

    public void setHours() {
        final int SECONDS_IN_AN_HOUR = 3_600;
        this.hours = (int) seconds / SECONDS_IN_AN_HOUR;
        this.seconds -= this.hours * SECONDS_IN_AN_HOUR;
    }

    public void setMinutes() {
        final int SECONDS_IN_A_MINUTE = 60;
        this.minutes = (int) seconds / SECONDS_IN_A_MINUTE;
        this.seconds -= this.minutes * SECONDS_IN_A_MINUTE;
    }

    public void printTime() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }


}
