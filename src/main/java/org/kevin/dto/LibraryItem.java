package org.kevin.dto;

import java.util.ArrayList;

abstract class LibraryItem {
    protected String author;
    protected String title;
    protected Genre genre;
    protected int yearOfPublication;
    protected int storageNum;
    protected ArrayList<String> comments;

    public LibraryItem(String author, String title, Genre genre, int yearOfPublication, int storageNum) {
        this.title = title;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.storageNum = storageNum;
        this.author = author;
    }

    public LibraryItem() {}
}
