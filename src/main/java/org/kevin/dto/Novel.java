package org.kevin.dto;

import java.util.ArrayList;

public class Novel extends LibraryItem{
    private Genre genre;

    public Novel(String title, Genre genre, int yearOfPublication, int storageNum, String author) {
        super(author, title, yearOfPublication, storageNum);
        this.genre = genre;
    }

    public Novel() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }



    @Override
    public String toString() {
        return "Novel{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", yearOfPublication=" + yearOfPublication +
                ", storageNum=" + storageNum +
                '}';
    }
}
