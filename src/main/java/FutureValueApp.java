/*
 * Author: Luis Figueroa <alefigue@uab.edu>
 * Assignment:  H1 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.alefigue.H1;

import java.text.NumberFormat;
import java.util.Scanner;

public class FutureValueApp {

  public static void main(String[] args) {
    System.out.println("Welcome to the Future Value Calculator");
    System.out.println();

    // get a Scanner object to scan for user input
    Scanner sc = new Scanner(System.in);

    String choice = "y";
    while (choice.equalsIgnoreCase("y")) {

      // get input from user
      System.out.println("Enter monthly investment:   ");
      double monthlyInvestment = sc.nextDouble();

      System.out.println("Yearly interest rate:   ");
      double interestRate = sc.nextDouble();

      System.out.println("Enter number of years:   ");
      int years = sc.nextInt();

      // convert all input values to months
      double monthlyInterestRate = interestRate / 12 / 100;
      int months = years * 12;

      // call method to calculate future value
      double futureValue = calculateFutureValue(monthlyInvestment, monthlyInterestRate, months);

      // format the display result
      NumberFormat currency = NumberFormat.getCurrencyInstance();
      System.out.println("Future value:          " + currency.format(futureValue) + "\n");

      // see if the user wants to continue
      System.out.println("Continue? (y/n): ");
      choice = sc.next();
      System.out.println();
    }
  }

  private static double calculateFutureValue(
      double monthlyInvestment, double monthlyInterestRate, int months) {
    double futureValue = 0;
    for (int i = 1; i <= months; i++) {
      futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
    }
    return futureValue;
  }
}


