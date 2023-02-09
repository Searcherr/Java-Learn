package org.example;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigInteger;
import java.util.*;


@Data

public class UniqueNumbers {
    Integer inputDigitsList;
    Integer numberOfDigits;

    UniqueNumbers(Integer inputDigitsList, Integer numberOfDigits){
        if ((inputDigitsList >= 10) &&
            (numberOfDigits <= (int)(Math.log10(inputDigitsList) + 1))){
            this.inputDigitsList = inputDigitsList;
            this.numberOfDigits = numberOfDigits;
        } else System.out.println("Shitty parameters");//throw new RuntimeException("Shitty parameters");
    }
    public Collection<Integer> toDigitSet() {
        Set<Integer> setOfDigits = new HashSet<>();
        int tempDigitList = inputDigitsList;
        while (tempDigitList >= 1) {
            setOfDigits.add(tempDigitList % 10);
            tempDigitList /= 10;
        }
        return setOfDigits;
    }

    public long numberOfCombinations(){
        Factorial factorial = new Factorial();
        System.out.println(this.toDigitSet().size() + "  " + numberOfDigits);
        long result = factorial.calc(this.toDigitSet().size()) /
                      factorial.calc(this.toDigitSet().size() - numberOfDigits);
        return result;
    }

    public ArrayList<Integer> setToArrayList(){
        ArrayList<Integer> inputDigitsListAsArrayList = new ArrayList<>();
        return new ArrayList<>(toDigitSet());
    }

    public Set<Set<Integer>> allPossibleCombinations(){
        Set<Set<Integer>> result = Sets.combinations(Sets.newHashSet(toDigitSet()), numberOfDigits);
        return result;
    }


}
