package org.example;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.google.common.collect.Collections2.*;
import lombok.Data;

import java.util.*;


@Data

public class UniqueNumbers {
    private Integer inputDigitsList;
    private Integer numberOfDigits;

    UniqueNumbers(Integer inputDigitsList, Integer numberOfDigits){
        if ((inputDigitsList >= 10) &&
            (numberOfDigits <= (int)(Math.log10(inputDigitsList) + 1))){
            this.inputDigitsList = inputDigitsList;
            this.numberOfDigits = numberOfDigits;
        } else System.out.println("Shitty parameters");//throw new RuntimeException("Shitty parameters");
    }
    public Set<Integer> toDigitSet() {
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
        long result = factorial.calc(this.toDigitSet().size()) /
                      (factorial.calc(this.toDigitSet().size() - numberOfDigits) * factorial.calc(numberOfDigits));
        return result;
    }

    public long numberOfPermutations(){
        Factorial factorial = new Factorial();
        long result = factorial.calc(this.toDigitSet().size()) /
                (factorial.calc(this.toDigitSet().size() - numberOfDigits));
        return result;
    }

    public List<Integer> setToArrayList(){
        return new ArrayList<>(toDigitSet());
    }

    public Set<Set<Integer>> allPossibleCombinations(){
        return Sets.combinations(Sets.newHashSet(toDigitSet()), numberOfDigits);
    }

    public List<List<Integer>> toArrayOfArrays(){
        List<List<Integer>> arrayOfArrays = new ArrayList<>();
        for (Set<Integer> set : allPossibleCombinations()){
            arrayOfArrays.add(new ArrayList<>(set));
        }
        return arrayOfArrays;
    }

    public ArrayList<List<Integer>> getPermutations(){
        ArrayList<List<Integer>> permutationsOfCombinations = new ArrayList<List<Integer>>();
        for (List<Integer> combination : toArrayOfArrays()){
            Collection<List<Integer>> permutations = Collections2.orderedPermutations(combination);
            for (List<Integer> element : permutations){
                permutationsOfCombinations.add(element);

            }

        }
        return permutationsOfCombinations;
    }

}
