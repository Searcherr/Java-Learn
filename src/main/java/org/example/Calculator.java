package org.example;

import lombok.*;

@Data
@Builder
public class Calculator {
    private int number_1;
    private int number_2;
    public int addition(){
        return number_1 + number_2;
    }

    public int subtraction(){
        return number_1 - number_2;
    }

    public int multiplication(){
        return number_1 * number_2;
    }

    public float division(){
        return number_1 / number_2;
    }

    public int remainder(){
        return number_1 % number_2;
    }

    public double power_of(){
        return Math.pow(number_1, number_2);
    }

}
