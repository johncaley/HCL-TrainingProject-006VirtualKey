package com.HCL;


import java.util.Scanner;

public class UserInterface {

    private static final String directoryPath = ".\\UserSpecifiedFiles";
    private static final Scanner sc = new Scanner(System.in);

    private static FileHandler myFileHandler = new FileHandler();

    public static void ApplicationDetails(){
        System.out.println("///////////////////////////////");
        System.out.println("//  Welcome to File Manager  //");
        System.out.println("//  Author: John Caley       //");
        System.out.println("//  Ver 0.9.1                //");
        System.out.println("///////////////////////////////");
    }

    public static void MainMenu(){



        System.out.println("\nPlease Select Options:");
        System.out.println("1) Display File Names");
        System.out.println("2) Close Application");

        String input = sc.nextLine();
        switch (input) {
            case "1":
                displayFileNames();
                break;
            case "2":
                closeApplication();
                break;
            default:
                System.out.println("Invalid Selection");
        }


    }

    public static void displayFileNames(){
        myFileHandler.getFileNames(directoryPath);
        MainMenu();
    }

    public static void closeApplication(){
        System.exit(0);
    }


}
