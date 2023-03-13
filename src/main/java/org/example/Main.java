package org.example;

//import lombok.NonNull;

import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Tasks from https://www.w3resource.com/java-exercises/basic/index.php

public class Main {

    private static boolean dividesByTwo(int numerator, int denominator){
        return numerator % denominator == 0;
    }

    private static List<String> swichVariables(String firstWord, String seconsWord){
        /*
        String tempVariable = "";
        tempVariable = firstWord;
        firstWord = seconsWord;

        seconsWord = tempVariable;
        List<String> listOfSwitchedWords = new ArrayList<>(2);
        listOfSwitchedWords.add(firstWord);
        listOfSwitchedWords.add(seconsWord);
         */
        return Arrays.asList(seconsWord, firstWord);


    }
    // w3resource: https://www.w3resource.com/java-exercises/basic/index.php
    private static String task_1(){
        String outputString = "Hello\nDmytro";
        return outputString;
    }

    private static int task_2_sum(int number_1, int number_2){
        int result = number_1 + number_2;
        return result;
    }

    private static int task_3_int_part_of_division(int number_1, int number_2){
        return number_1 / number_2;
    }

    private static int task_4a(int number_1, int number_2, int number_3){
        return number_1 + number_2 * number_3;
    }

    private static int task_4b(int number_1, int number_2, int number_3){
        return (number_1 + number_2) % number_3;
    }


    private static int task_4c(int number_1, int number_2, int number_3, int number_4){
        float result = number_1 + number_2 * number_3 / number_4;
        return (int) result;
    }

    private static int task_4d
            (int number_1, int number_2, int number_3,
             int number_4, int number_5, int number_6){
        return number_1 + number_2 / number_3 * number_4 + number_5 % number_6;
    }

    private static int task_5_product(int number_1, int number_2){
        return number_1 * number_2;
    }

    private static List<Integer> task_7_multiplication_table(int multiplier){
        List<Integer> multipliers_list = IntStream.rangeClosed(1, 10).boxed().toList();
        return multipliers_list.stream().map(el -> el * multiplier).collect(Collectors.toList());

    }

    private static int sum_of_digits(int input_number){
        int sum = 0;
        while (input_number >= 1) {
            sum += input_number % 10;
            input_number /= 10;
        }
        return sum;
    }
    private static int sum_of_digits_str(String input_string){
        int sum = 0;

        char[] chars_list = input_string.toCharArray();
        for (int i = 0; i < input_string.length(); i++){
            sum += Character.getNumericValue(chars_list[i]);
        }

        return sum;
    }

    // Task 35
    private static double polygon_area(int number_of_sides, double side_length){
        return (number_of_sides * Math.pow(side_length, 2)) / (4 * Math.tan(Math.PI / number_of_sides));
    }


    public static double distanceBeetweenPoints(double x1, double y1, double x2, double y2){
        final double EARTH_RADIUS = 6371.01; // Kilometers
        x1 = Math.toRadians(x1);
        x2 = Math.toRadians(x2);
        y1 = Math.toRadians(y1);
        y2 = Math.toRadians(y2);

        double distance = EARTH_RADIUS *
                Math.acos(Math.sin(x1) * Math.sin(x2) +
                Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        return distance;
    }

    public static String reverseString(String inputString){
        return new StringBuilder(inputString).reverse().toString();
    }

    public static HashMap<String, Integer> countElementsTypes(String inputString) {
        int letterCounter = 0;
        int spaceCounter = 0;
        int numberCounter = 0;
        int otherCounter = 0;
        if (inputString.isEmpty()) {
            System.out.println("No characters are inside");
        } else {
            for (int i = 0; i < inputString.length(); i++) {
                if (Character.isDigit(inputString.charAt(i))) {
                    numberCounter++;
                } else if (Character.isLetter(inputString.charAt(i))) {
                    letterCounter++;
                } else if (Character.isSpaceChar(inputString.charAt(i))) {
                    spaceCounter++;
                } else {
                    otherCounter++;
                }
            }
        }
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        result.put("Letters", letterCounter);
        result.put("Spaces", spaceCounter);
        result.put("Numbers", numberCounter);
        result.put("Others", otherCounter);

        return result;
    }

    public static HashMap<String, Long> countElementsTypesFilter(String inputString) {
        HashMap<String, Long> result = new HashMap<>();
        if (inputString.isEmpty()) {
            System.out.println("No characters are inside");
            return result;
        }
        result.put("Letters", inputString.chars().filter(Character::isLetter).count());
        result.put("Spaces", inputString.chars().filter(Character::isSpaceChar).count());
        result.put("Numbers", inputString.chars().filter(Character::isDigit).count());
        result.put("Others", inputString.length() - result.get("Letters") - result.get("Spaces") - result.get("Numbers"));

        return result;
    }

    public static int getASCIIValue(char inputCharacter){
        return (int) inputCharacter;
    }

    public static int getSumOfNumberMultiplications(int inputNumber, int inputRawLength){
        List<Integer> listOfMultiplications = new ArrayList<>();
        int counter = 1;
        while (counter <= inputRawLength){
            double currentValue = 0;
            for (double i = 0; i < counter; i++) {
                currentValue += inputNumber * Math.pow(10, i);
            }
            listOfMultiplications.add((int) currentValue);
            counter++;
        }
        return listOfMultiplications.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    //48. Write a Java program to print the odd numbers from 1 to 99. Prints one number per line.

    public static void printOdd(int start, int end){
        List<Integer> oddNumbers = IntStream.rangeClosed(start, end)
                .filter(n -> n % 2 != 0)
                .boxed()
                .toList();

        oddNumbers.forEach(System.out::println);
    }

    //50 .Write a Java program to print numbers between 1 to 100 which are divisible by 3, 5 and by both.
    public static void divByThreeOrFiveAndBoth(int start, int end){
        List<Integer> divThree = IntStream.rangeClosed(start, end)
                .filter(n -> n % 3 == 0)
                .boxed()
                .toList();

        List<Integer> divFive = IntStream.rangeClosed(start, end)
                .filter(n -> n % 5 == 0)
                .boxed()
                .toList();

        List<Integer> divThreeAndFive = IntStream.rangeClosed(start, end)
                .filter(n -> (n % 3 == 0) && (n % 5 == 0))
                .boxed()
                .toList();

        System.out.println("Divided by 3:");
        divThree.forEach(s -> System.out.print(s + ", "));
        System.out.println("\nDivided by 5:");
        divFive.forEach(s -> System.out.print(s + ", "));
        System.out.println("\nDivided by 3 & 5:");
        divThreeAndFive.forEach(s -> System.out.print(s + ", "));

    }
    // 56. Write a Java program to find the number of values in a given range divisible by a given value.
    // For example x = 5, y=20 and p =3, find the number of integers within the range x..y and that are divisible by p i.e. { i :x ≤ i ≤ y, i mod p = 0 }
    public static int divisibleList(int start, int end, int denominator) {
        List<Integer> result = IntStream.rangeClosed(start, end)
                .filter(n -> n % denominator == 0)
                .boxed()
                .toList();
        return result.size();
    }

    // 57. Write a Java program to accepts an integer and count the factors of the number.
    public static List<Integer> factorsOfNumber(int inputNumber) {
        List<Integer> result = IntStream.rangeClosed(1, (int) inputNumber / 2)
                .filter(n -> inputNumber % n == 0)
                .boxed()
                .collect(Collectors.toList());
        result.add(inputNumber);
        return result;
    }

    // 58. Write a Java program to capitalize the first letter of each word in a sentence.
    // ????????????????????
    public static String capitalizeLetterOfEachWord(String inputSentence) {
        return Arrays.stream(inputSentence.split("\\s+"))
                .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1))
                .collect(Collectors.joining(" "));
        //return result;
    }

    // 59. Write a Java program to convert a given string into lowercase
    public static String stringToLowercase(String inputSentence) {
        return Arrays.stream(inputSentence.split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.joining(" "));
        //return result;
    }

    // 60. Write a Java program to find the penultimate (next to last) word of a sentence.
    public static String penultimateWordInString(String inputSentence) {
        List<String> splitedInputStream = Arrays.stream(inputSentence.split("\\s+"))
                .toList();
        return splitedInputStream.get(splitedInputStream.size() - 2);

    }

    // 61. Write a Java program to reverse a word.
    public static String reverseWord(String inputWord) {
        return Stream.of(inputWord)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }

    // 62. Write a Java program that accepts three integer values and return true if one of them is 20 or more
    // and less than the substractions of others.
    // ???????????????????????????????????????????
    public static boolean task62(int firstNum, int secondNum, int thirdNum) {
        return Stream.of(firstNum, secondNum, thirdNum)
                .anyMatch(n -> n >= 20);
    }

    // 64. Write a Java program that accepts two integer values between 25 to 75 and
    // return true if there is a common digit in both numbers.
    public static boolean isCommonDigit(String firstValue, String secondValue) {
        final ValueRange range = ValueRange.of(25, 75);
        if (! range.isValidIntValue(Integer.parseInt(firstValue)) ||
                (! range.isValidIntValue(Integer.parseInt(secondValue)))) {
            return false;
        } else {
            IntStream digitsOfFirstValue = firstValue.chars().map(Character::getNumericValue);
            List<Integer> digitsOfSecondValue = secondValue
                                                    .chars().map(Character::getNumericValue)
                                                    .boxed().toList();

            return digitsOfFirstValue.anyMatch(digitsOfSecondValue::contains);
        }
    }

    // 65. Write a Java program to calculate the modules of two numbers without using any inbuilt modulus operator.
    public static int modulesOfTwoNumbers(int firstNumber, int secondNumber) {
        List<Integer> inputNumbersListSorted = IntStream.of(firstNumber, secondNumber)
                                                        .sorted()
                                                        .boxed()
                                                        .toList();
        //inputNumbersListSorted.stream().forEach(n -> System.out.print(n + " "));
        return (int) (Math.sqrt(Math.pow(inputNumbersListSorted.get(1) - inputNumbersListSorted.get(0), 2)));
    }

    // 66. Write a Java program to compute the sum of the first 100 prime numbers.
    public static boolean isPrime(long number) {
        return IntStream.rangeClosed(2,(int) number / 2)
                .allMatch(d -> number % d !=0);
    }
    public static long sumOfTheFirst100PrimeNumbers() {
        List<Long> primeNumbers = new ArrayList<>(100);
        long currentNum = 1;
        while (primeNumbers.size() <= 100) {
            if (isPrime(currentNum)){
                primeNumbers.add(currentNum);
            }
            currentNum++;
        }
        return primeNumbers.stream()
                        .mapToLong(primeNumber -> primeNumber)
                        .sum();
    }


    // 74. Write a Java program to test if 10 appears as either the first or last element of an array of integers.
    // The length of the array must be greater than or equal to 2.
    public static boolean firstAndLastElementOfArrayIs10(List<Integer> inputArray) {
        return (Objects.equals(inputArray.get(0), inputArray.get(inputArray.size() - 1))) &&
                (inputArray.get(0) == 10);
    }

    public static int task1(int n) {
        //TODO: Delete line below and write your own solution
        if (n > 0) {
            return (int) Math.pow((double) n, 2);
        } else if (n < 0) {
            return Math.abs(n);
        }
        return 0;
    }

    public static int task2(int n) {
        String inputValueAsString = String.valueOf(n);
        List<Integer> digitOfInputNumber = new ArrayList<>(inputValueAsString
                .chars().map(Character::getNumericValue)
                .sorted()
                .boxed().toList());
        Collections.reverse(digitOfInputNumber);

        int result = 0;
        for (Integer i : digitOfInputNumber) {
            result = result * 10 + i;
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println("Result: " + task2(187));



        //System.out.println("Result: " + task1(0));

        //System.out.println(firstAndLastElementOfArrayIs10(Arrays.asList(10, 20, 40, 1)));

        //System.out.print(sumOfTheFirst100PrimeNumbers());
        //System.out.print(modulesOfTwoNumbers(-10, -2));

        //System.out.println(isCommonDigit("31", "70"));

        //System.out.println(task62(10, 12, 20));

        //System.out.println(reverseWord("dsaf"));

        //System.out.println(penultimateWordInString("The quick brown fox jumps over the lazy dog"));

        //System.out.print(stringToLowercase("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));

        //System.out.print(capitalizeLetterOfEachWord("in god we trust"));

        //factorsOfNumber(25).stream().forEach(s -> System.out.print(s + ", "));

        //System.out.println("Result = " + divisibleList(5, 20, 3));

        //Clock userClock = new Clock(86399);
        //userClock.printTime();

        //divByThreeOrFiveAndBoth(1, 100);
        //printOdd(1, 100);
        //System.out.println("Result = " + getSumOfNumberMultiplications(5, 3));

        /*
        MergeListsToUniqueList userList = new MergeListsToUniqueList();
        userList.setInputUniqueElements(Arrays.asList(1, 5, 7, 9, 9, 9));
        System.out.println("Set is = " + userList.getInputUniqueElements());
        */
        //System.out.println("ASCII of Q is " + getASCIIValue('Q'));
        /* UniqueNumbersCombinations
        UniqueNumbers userNumbers = new UniqueNumbers(1234, 3);
        System.out.println("Set of digits: " + userNumbers.toDigitSet() + "\n");

        System.out.println("Number of combinations = " + userNumbers.numberOfCombinations());
        System.out.println("All combinations in List of Lists = " + userNumbers.toArrayOfArrays() + "\n");

        System.out.println("Number of permutations = " + userNumbers.numberOfPermutations());
        System.out.println("All permutations of combinations = " + userNumbers.getPermutations());

        System.out.println("to DigitSet type = " + userNumbers.toDigitSet().getClass().getName());
        */

        //userNumbers.getPermutations();
        /*
        String userString = "asdj asdl346 .? asdk3859";
        System.out.println("Result with if = " + countElementsTypes(userString));
        System.out.print("Result with filter= " + countElementsTypesFilter(userString));
        */
        //System.out.print("Result = " + reverseString("abc"));
        //System.out.println("Result = " + distanceBeetweenPoints(25, 35, 35.5, 25.5));

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of sides: ");
        int user_number_of_sides = scanner.nextInt();
        System.out.print("Enter side's length: ");
        double user_side_length = scanner.nextDouble();
        scanner.close();
        System.out.println("Result = " + polygon_area(user_number_of_sides, user_side_length));
        */

        //System.out.println(task_1());
        //System.out.println(task_2_sum(74, 36));
        //System.out.println(task_3_int_part_of_division(50, 3));
        //System.out.println(task_4a(-5, 8, 6));
        //System.out.println(task_4b(55, 9, 9));
        //System.out.println(task_4c(20, -3, 5, 8));
        //System.out.println(task_4d(5, 15, 3, 2, -8, 3));
        //System.out.println(task_5_product(25, 5));

        /*
        Calculator userCalculator = Calculator.builder()
                .number_1(2)
                .number_2(3)
                .build();

        System.out.println(userCalculator.division());
        System.out.println(userCalculator.multiplication());
        System.out.println(userCalculator.addition());
        System.out.println(userCalculator.subtraction());
        System.out.println(userCalculator.power_of());
        */

        //System.out.println(task_7_multiplication_table(8));
        /*
        Circle userCircle = Circle.builder()
                .radius(7.5)
                .build();
        System.out.println("Perimeter is = " + userCircle.calculate_perimeter());
        System.out.println("Area is = " + userCircle.calculate_area());


        AverageNumber averageNumber = new AverageNumber();
        averageNumber.input_list();
        averageNumber.sortedUserList();
        System.out.println(averageNumber.list_of_numbers);

        System.out.println(averageNumber.result());
        */


        /*
        System.out.print("Enter your number: ");
        Scanner scanner = new Scanner(System.in);
        int user_input = scanner.nextInt();
        scanner.close();
        System.out.println("Result = " + sum_of_digits(user_input));
        */
        /*
        System.out.print("Enter your number: ");
        Scanner scanner = new Scanner(System.in);
        String user_input = scanner.next();
        scanner.close();
        System.out.println("Result = " + sum_of_digits_str(user_input));
        */







    }
}