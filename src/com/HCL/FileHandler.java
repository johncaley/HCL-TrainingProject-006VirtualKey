package com.HCL;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileHandler {

    public FileHandler(){
    }

    public void getFileNames(String directoryPath){
        File workingDirectory = new File(directoryPath);
        String contentOfDirectory[] = workingDirectory.list();

        if (contentOfDirectory.length < 1){
            System.out.println("Directory Empty");
            return;
        }

        ArrayList<String> files = new ArrayList<String>();
        ArrayList<String> directories = new ArrayList<String>();

        for (int i = 0; i <contentOfDirectory.length; i++){
            if (Pattern.matches(".*\\..*", contentOfDirectory[i])){
                files.add(contentOfDirectory[i]);
            }
            else{
                directories.add(contentOfDirectory[i]);
            }
        }

        System.out.println("\n(" + files.size() + ") Files in Current Directory");
        for (int i = 0; i < files.size(); i++){
            System.out.println(files.get(i));
        }
        for (int i = 0; i < directories.size(); i++){
            System.out.println(directories.get(i) + " <DIR>");
        }
    }

    public void addNewFile(String directoryPath, String documentName){
        File myFile = new File(directoryPath, documentName);

        boolean execute = false;

        try{
            execute = myFile.createNewFile();
            System.out.println("File \"" + myFile.getName() + "\" Created");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String directoryPath, String documentName){
        File myFile = new File(directoryPath, documentName);

        if (myFile.exists()){
            try{
                myFile.delete();
                System.out.println("File \"" + myFile.getName() + "\" was deleted");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("File \"" + documentName + "\" does not exist in current directory");
        }
    }

    public void searchForFile(String directoryPath, String documentName){
        File myFile = new File(directoryPath, documentName);
        if (myFile.exists()){
            System.out.println("File \"" + documentName + "\" exist in current directory");
        }
        else {
            System.out.println("File \"" + documentName + "\" does not exist in current directory");
        }
    }

}
