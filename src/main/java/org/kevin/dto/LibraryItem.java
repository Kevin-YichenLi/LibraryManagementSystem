package org.kevin.dto;

import java.util.ArrayList;

abstract class LibraryItem {
    protected String title;
    protected Genre genre;
    protected int yearOfPublication;
    protected Condition condition;
    protected int storageNum;
    protected ArrayList<String> comments;

    public LibraryItem(String title, Genre genre, int yearOfPublication, Condition condition,
                       int storageNum, ArrayList<String> comments) {
        this.title = title;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.condition = condition;
        this.storageNum = storageNum;
        this.comments = comments;
    }

    public LibraryItem() {
        title = null;
        genre = null;
        yearOfPublication = 0;
        condition = null;
        storageNum = -1;
        comments = null;
    }
}
