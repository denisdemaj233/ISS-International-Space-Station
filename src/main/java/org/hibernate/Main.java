package org.hibernate;

import org.hibernate.config.Jpa;

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
            System.out.println("2. Upcoming ISS runs for a specific locatiNumber of people in space within the ISSon");
            System.out.println("3. Number of people in space within the ISS ");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("ISS speed calculation");
                    break;
                case 2:
                    System.out.println("Upcoming ISS runs for a specific location");
                    break;
                case 3:
                    System.out.println("Number of people in space within the ISS");
                    break;
                case 4:
                    Jpa.shutdown();
                    System.exit(0);
                default:
                    System.out.println("Please choose one of the options above");
                    break;

            }

        }while (choose!=4);
    }
}