package org.kevin.dto;

import java.util.ArrayList;
import java.util.Objects;

abstract class LibraryItem {
    protected String author;
    protected String title;
    protected int yearOfPublication;
    protected int storageNum;
    protected ArrayList<String> comments;
    protected int id;
    protected ArrayList<Integer> rates;

    public LibraryItem(String author, String title, int yearOfPublication, int storageNum) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.storageNum = storageNum;
        this.author = author;
        comments = new ArrayList<>();
        rates = new ArrayList<>();
    }

    public LibraryItem() {
        comments = new ArrayList<>();
        rates = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem that = (LibraryItem) o;
        return yearOfPublication == that.yearOfPublication && storageNum == that.storageNum && id == that.id &&
                Objects.equals(author, that.author) && Objects.equals(title, that.title) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, yearOfPublication, storageNum, comments, id);
    }
}
