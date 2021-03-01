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
        System.out.println("//  Ver 0.9.2                //");
        System.out.println("///////////////////////////////");
    }

    public static void MainMenu(){

        System.out.println("\nPlease Select Options:");
        System.out.println("1) Display File Names");
        System.out.println("2) Additional Operations");
        System.out.println("3) Close Application");
        String input = sc.nextLine();

        switch (input) {
            case "1":
                displayFileNames();
                break;
            case "2":
                AditionalOperations();
                break;
            case "3":
                closeApplication();
                break;
            default:
                System.out.println("Invalid Selection");
                MainMenu();
        }


    }

    public static void AditionalOperations(){
        System.out.println("\nPlease Select Options:");
        System.out.println("1) Add User Defined File");
        System.out.println("2) Return to Main Menu");
        String input = sc.nextLine();

        switch (input) {
            case "1":
                addNewFile();
                break;
            case "2":
                MainMenu();
                break;
            default:
                System.out.println("Invalid Selection");
                ApplicationDetails();
        }
    }

    public static void displayFileNames(){
        myFileHandler.getFileNames(directoryPath);
        MainMenu();
    }

    public static void addNewFile(){
        String documentName;
        StringBuilder documentContents = new StringBuilder();

        System.out.println("Create new file name:");
        documentName = sc.nextLine();

        myFileHandler.addNewFile(directoryPath, documentName);
        AditionalOperations();
    }

    public static void closeApplication(){
        System.exit(0);
    }


}
