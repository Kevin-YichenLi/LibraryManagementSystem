package org.kevin.dto;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Textbook extends LibraryItem {

    public Textbook() {
        super();
    }

    public Textbook(String title, int yearOfPublication, int storageNum, String author) {
        super(author, title, yearOfPublication, storageNum);
    }

    public Textbook(int id, String author, String title, int yearOfPublication, int storageNum) {
        super(id, author, title, yearOfPublication, storageNum);
    }

    public int getID() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(int storageNum) {
        this.storageNum = storageNum;
    }

    @Override
    public String toString() {
        return "Textbook{" +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", storageNum=" + storageNum +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
