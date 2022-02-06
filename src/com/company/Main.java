package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        //variables to hold user input
        int hours = 0;
        int minutes = 0;


        //get input time from user
        // loop runs until there is a valid num for hours and minutes
        do {
            System.out.println("Enter hours and then minutes: ");
            hours = sc.nextInt();
            minutes = sc.nextInt();

            if (!validHours(hours)){
                System.out.println("Enter number between 0 and 23 for hours!");
            }
            if (!validMinutes(minutes)){
                System.out.println("Enter number between 0 and 59 for minutes!");
            }


        }while (!validHours(hours) || !validMinutes(minutes));



        //print out time 45 min earlier in 24hr notation
        printEarlierTime(hours, minutes);

    }

    private static void printEarlierTime(int hours, int minutes) {
        int minutesToSubtract = 45;

        // if minutes are bigger than the minutes to subtract
        if (minutes >= minutesToSubtract){
            minutes -= minutesToSubtract;
        }
        else{
            int minsRemaining = minutesToSubtract - minutes; // remainder of minutes
            minutes = 60 - minsRemaining;

            //decrement the hours, wrap around if needed
            if(hours > 0){ //if hours are one or more can decrement by one
                hours--;
            }
            else{ //hours are zero wrap around to 23
                hours = 23;
            }

        }

        System.out.printf("%d:%d", hours, minutes); //prints hours:minutes

    }


    //returns true if minutes are between 0 and 59 inclusive
    private static boolean validMinutes(int minutes) {

        return minutes >= 0 && minutes <= 59;
    }

    //returns true if hours are between 0 and 23 inclusive
    private static boolean validHours(int hours) {

        return hours >= 0 && hours <= 23;
    }
}
