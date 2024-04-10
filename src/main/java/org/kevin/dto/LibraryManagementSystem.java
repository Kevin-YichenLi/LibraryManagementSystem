package org.kevin.dto;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private ArrayList<Novel> novels;
    private ArrayList<DvD> dvds;
    private ArrayList<Magazine> magazines;
    private ArrayList<Textbook> textbooks;
    private ArrayList<User> students;
    private ArrayList<User> teachers;

    public void logIn() {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the library management system, please log in to your account");
        System.out.println("User name: ");
        String inpUserName = console.nextLine();
        System.out.println("Password: ");
        String inpPassword = console.nextLine();

        for (User student : students) {
            if (inpUserName.equals(student.getUserName()) && inpPassword.equals(student.getPassword())) {
                System.out.println("Log in successfully");
            }
        }

    }

}
