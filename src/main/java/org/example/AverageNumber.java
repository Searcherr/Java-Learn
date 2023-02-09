package org.example;

import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.function.ToDoubleFunction;

@Data

public class AverageNumber {

    public ArrayList<Double> list_of_numbers = new ArrayList<>(3);

    public AverageNumber(){

    }
    public void input_list(){
        ArrayList<Double> userList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 numbers: ");
        while (scanner.hasNextDouble()){
            double userNumber = scanner.nextDouble();
            userList.add(userNumber);
        }
        scanner.close();

        list_of_numbers = userList;
    }

    public void sortedUserList(){
        list_of_numbers.sort(Comparator.naturalOrder());
    }

    public double result() {
        return list_of_numbers.get(1);
    }

}
