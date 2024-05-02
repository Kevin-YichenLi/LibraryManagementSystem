package org.kevin.dto;

import java.util.ArrayList;

abstract class LibraryItem {
    protected String author;
    protected String title;
    protected int yearOfPublication;
    protected int storageNum;
    protected ArrayList<String> comments;
    protected int id;
    private static int nextId = 1;

    public LibraryItem(String author, String title, int yearOfPublication, int storageNum) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.storageNum = storageNum;
        this.author = author;
        id = nextId++;
    }

    public LibraryItem() {
        id = nextId++;
    }
}
