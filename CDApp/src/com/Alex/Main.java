package com.Alex;

import java.util.Scanner;

/**
 * Simple console application that allows the user to manipulate a
 * fictitious CD shop in terms of adding, deleting or searching certain CDs based on its title
 * or its artist. Note that some validation is implemented in order to avoid duplication of CDs.
 *The application uses Collection( e.g. ArrayList) as well as the encapsulation principle in order to hide the
 * inner functionality from the user.
 */

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static CDCatalog cdCatalog = new CDCatalog("Catalog");

    public static void main(String[] args) {
        boolean quit = false;
        System.out.println("CD CATALOG");
        printMenu();
        System.out.println("Press: ");
        while (!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printMenu();
                    break;
                case 1:
                    addCD();
                    break;
                case 2:
                    removeCD();
                    break;
                case 3:
                    searchByTitle();
                    break;
                case 4:
                    searchByArtist();
                    break;
                case 5:
                    cdCatalog.removeAllCD();
                    break;
                case 6:
                    getByIndex();
                    break;
                case 7:
                    getSize();
                    break;
                case 8:
                    cdCatalog.printCatalog();
                    break;
                case 9:
                    quit = true;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Press: \n");
        System.out.println("0 - To show the menu");
        System.out.println("1 - To add a new CD");
        System.out.println("2 - To remove a CD");
        System.out.println("3 - To search a CD by the title");
        System.out.println("4 - To search a CD by the artist");
        System.out.println("5 - To remove all the CDs from the Catalog");
        System.out.println("6 - To get a CD by its index");
        System.out.println("7 - To get the size of the Catalog");
        System.out.println("8 - To print the Catalog");
        System.out.println("9 - To quit the app");
    }

    private static void addCD(){
        System.out.println("Enter the title of the CD: ");
        String cdTitle = scanner.nextLine();
        System.out.println("Enter the name of the artist: ");
        String artistName = scanner.nextLine();

        cdCatalog.addCD(new CD(cdTitle,artistName));
    }

    private static void removeCD(){
        System.out.println("Enter the title of the CD: ");
        String cdTitle = scanner.nextLine();

        cdCatalog.removeCD(cdTitle);
    }

    public static void getSize(){
        System.out.println("The size of the Catalog is: " + cdCatalog.getSize());
    }

    private static void getByIndex(){
        System.out.println("Enter the index of the CD (integer)");
        int choice = scanner.nextInt() - 1;
        scanner.nextLine();

        if(choice < 0){
            System.out.println("Index must be a positive number!");
            return;
        }

        if(cdCatalog.getByIndex(choice) == null){
            System.out.println("CD not found!");
            return;
        }

        System.out.println("The CD is: " + cdCatalog.getByIndex(choice));
    }

    private static void searchByTitle(){
        System.out.println("Enter the title of the CD");
        String cdTitle = scanner.nextLine();

        Object o = cdCatalog.findByTitle(cdTitle);
        System.out.println("The CD is: " + o);
    }

    private static void searchByArtist(){
        System.out.println("Enter the artist");
        String cdArtist = scanner.nextLine();

        Object o = cdCatalog.findByArtist(cdArtist);
        System.out.println("The CD is: " + o);
    }

}
