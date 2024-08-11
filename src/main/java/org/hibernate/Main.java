package org.hibernate;

import org.hibernate.config.Jpa;
import org.hibernate.functionality.NumberOfPeopleFunction;
import org.hibernate.functionality.SpaceFunction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------------------");
        System.out.println("                   INTERNATIONAL SPACE STATION");
        System.out.println("---------------------------------------------------------------------");

        int choose;

        do {
            System.out.println("Functionalities:");
            System.out.println("1. ISS speed calculation");
            System.out.println("2. Number of people in space within the ISS ");
            System.out.println("3 Exit");
            System.out.print("Choose: ");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();

            switch (choose) {
                case 1:

                    System.out.println("ISS speed is: "+ SpaceFunction.speedCalculation()+"\n");
                    break;
                case 2:
                    System.out.println("Number of people in space within the ISS: "+ NumberOfPeopleFunction.numberOfPeopleInSpace()+"\n");
                    break;
                case 3:
                    Jpa.shutdown();
                    System.exit(0);
                default:
                    System.out.println("Please choose one of the options above");
                    break;

            }

        }while (choose!=3);
    }
}