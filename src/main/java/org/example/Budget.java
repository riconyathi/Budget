package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Budget {
    private Scanner scan = new Scanner(System.in);
    double total;
    double sum  = 0;
    int i = 0;
    List<Double> proportion = new ArrayList<>();


    public void enterProportion(){
        System.out.println("How much can you spend?");
         total = scan.nextDouble();
        System.out.println("Enter your proportion of various expenses.");
        System.out.println("The system stops if cumulative proportion exceeds 100%");

        do{
            System.out.println("Your proportion of expense " +
                    (i+1)+":");
            double value = scan.nextDouble();
            proportion.add(value);
            sum += proportion.get(i);
            i++;
        }while(sum <= 100);
        fixBudget();
    }

    public void fixBudget(){
        if(sum > 100){
            double cumulativeSum = 0.0;
            for (int j = 0; j < proportion.size()-1; j++) {
                cumulativeSum += proportion.get(j);
            }
            proportion.set(proportion.size()-1, 100.0 - cumulativeSum);
            showBudget();

        }
    }

    public void showBudget(){
        for (double value : proportion){
            double expense = value * total/100.0;
            System.out.println("Your "+ value + "% equals $" + expense);
            close();
        }
    }

    public  void close(){
        scan.close();
    }
}
