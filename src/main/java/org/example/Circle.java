package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Circle {
    private double radius;

    public double calculate_perimeter(){
        //pi = per / 2R
        return 2 * Math.PI * radius;
    }

    public double calculate_area(){
        return (float) Math.PI * Math.pow(radius, 2);
    }
}
