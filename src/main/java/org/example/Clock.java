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

    public List<Integer> getTime(){
        int[] time = new int[3];

    }


}
