package com.company.CSVanalytics;

import com.company.CSVanalytics.util.App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        System.out.println("Please enter the path to the resource folder,"+"example: C:\\\\Users\\\\Admin\\\\Desktop\\\\CSVFiles");
        String resourceFolder=scanner.nextLine();

        System.out.println("Please enter the path to the folder where the finished file will be stored");
        String  resultWritePath=scanner.nextLine();

        System.out.println("Please enter a name final file without extension");
        String fileName=scanner.nextLine();

        System.out.println("Specify the maximum number of threads that will work simultaneously in the system");
        int threadCount=scanner.nextInt();


        System.out.println("The program started successfully. Wait for the analysis to finish," +
                " and check the folder that you specified as the storage of the finished file");
        App.start(resourceFolder,resultWritePath,fileName,threadCount);
    }
}
