package org.kevin.dto;

import org.kevin.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private ArrayList<Novel> novels;
    private ArrayList<Textbook> textbooks;
    private ArrayList<User> students;
    private ArrayList<User> librarians;
    private static final String librarianMenu = "You can perform among following orders, enter 1 to add an item, enter 2 to " +
            "edit an item's information, enter 3 to delete an item, enter 4 to search an item, enter 5 to sort and " +
            "show items, enter 6 to verify item borrowing demands, enter 7 to verify renewal requests, enter q to log out";

    public LibraryManagementSystem() {
        novels = new ArrayList<>();
        textbooks = new ArrayList<>();
        students = new ArrayList<>();
        librarians = new ArrayList<>();
    }

//    public void logIn() {
//        Scanner console = new Scanner(System.in);
//        System.out.println("Welcome to the library management system, please log in to your account");
//        System.out.println("User name: ");
//        String inpUserName = console.nextLine();
//        System.out.println("Password: ");
//        String inpPassword = console.nextLine();
//
//        for (User student : students) {
//            if (inpUserName.equals(student.getUserName()) && inpPassword.equals(student.getPassword())) {
//                System.out.println("Log in successfully to student account");
//                studentModule();
//            }
//        }
//
//        for (User librarian : librarians) {
//            if (inpUserName.equals(librarian.getUserName()) && inpPassword.equals(librarian.getPassword())) {
//                System.out.println("Log in successfully to librarian account, welcome back " + librarian.getUserName());
//                librarianModule();
//            }
//        }
//    }

    public void login() {

    }

    private void register() {
        Scanner console = new Scanner(System.in);
        int secretKey = 12345;
        System.out.println("Please enter userName");
        boolean flag = false;

        while (true) {
            System.out.println("Please enter the secret key if you want to create a librarian account");
            int inputKey = console.nextInt();
            if (inputKey == secretKey) {
                System.out.println("Please enter userName, no space is allowed, you must include a letter");
                String userName = console.next();
                System.out.println("Please enter password, no space is allowed, you must include a letter");
                String password = console.next();
            }



            if (flag) {
                System.out.println("Log out successfully, have a good day");
                break;
            }
        }

    }

    public void studentModule() {

    }

    public void librarianModule() {
        boolean flag = false;
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.println(librarianMenu);
            String input = console.next();
            switch (input) {
                case "1":
                    addItem();
                    break;
                case "2":
                    editItem();
                    break;
                case "3":
                    deleteItem();
                    break;
                case "4":
                    searchItem();
                    break;
                case "5":
                    sortItem();
                    break;
                case "6":
                    manageBorrowRequests();
                    break;
                case "7":
                    manageRenewalRequests();
                    break;
                case "8":
                    addUser();
                case "q":
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid Input, please enter again");
            }

            if (flag) {
                System.out.println("Log out successfully, have a good day");
                break;
            }
        }
    }

    public void addItem() {

    }

    public void editItem() {

    }

    public void addUser() {

    }

    public void deleteItem() {

    }

    public void searchItem() {

    }

    public void sortItem() {

    }

    public void manageBorrowRequests() {

    }

    public void manageRenewalRequests() {

    }
}
