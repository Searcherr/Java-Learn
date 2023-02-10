package org.example;

//import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    private static boolean dividesByTwo(int numerator, int denominator){
        if (numerator % denominator == 0){
            return true;
        }
        return false;
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
        int result = number_1 / number_2;
        return result;
    }

    private static int task_4a(int number_1, int number_2, int number_3){
        int result = number_1 + number_2 * number_3;
        return result;
    }

    private static int task_4b(int number_1, int number_2, int number_3){
        int result = (number_1 + number_2) % number_3;
        return result;
    }


    private static int task_4c(int number_1, int number_2, int number_3, int number_4){
        float result = number_1 + number_2 * number_3 / number_4;
        int int_result = (int) result;
        return int_result;
    }

    private static int task_4d
            (int number_1, int number_2, int number_3,
             int number_4, int number_5, int number_6){
        int result = number_1 + number_2 / number_3 * number_4 + number_5 % number_6;
        return result;
    }

    private static int task_5_product(int number_1, int number_2){
        int result = number_1 * number_2;
        return result;
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
        List<Integer> listOfMultiplications = new ArrayList();
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

    public static void main(String[] args) {
        System.out.println("Result = " + getSumOfNumberMultiplications(5, 3));





        //MergeListsToUniqueList userList = new MergeListsToUniqueList();

        //userList.setInputUniqueElements(Arrays.asList(1, 5, 7, 9, 9, 9));
        //System.out.println("Set is = " + userList.getInputUniqueElements());

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