package org.kevin.dto;

import java.util.ArrayList;
import java.util.Objects;

public abstract class LibraryItem {
    protected String author;
    protected String title;
    protected int yearOfPublication;
    protected int storageNum;

    public LibraryItem(String author, String title, int yearOfPublication, int storageNum) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.storageNum = storageNum;
        this.author = author;
    }

    public LibraryItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryItem that = (LibraryItem) o;
        return yearOfPublication == that.yearOfPublication && storageNum == that.storageNum &&
                Objects.equals(author, that.author) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, yearOfPublication, storageNum);
    }
}
