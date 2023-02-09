package org.example;

import lombok.Data;

@Data
public class Factorial {
    long n;

    Factorial(){
        if (n >=1 ){
            this.n = n;
        }
    }

    public long calc(long n) {
        if (n <= 1)
            return 1;
        else
            return n * calc(n - 1);
    }
}
