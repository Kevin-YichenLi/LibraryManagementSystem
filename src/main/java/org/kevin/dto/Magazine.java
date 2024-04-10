package org.kevin.dto;

import java.util.ArrayList;

public class Magazine extends LibraryItem{
    private String publisher;

    public Magazine(String title, Genre genre, int yearOfPublication, Condition condition,
                    int storageNum, ArrayList<String> comments, String publisher) {
        super(title, genre, yearOfPublication, condition, storageNum, comments);
        this.publisher = publisher;
    }

    public Magazine() {
        super();
        publisher = null;
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

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "publisher='" + publisher + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", yearOfPublication=" + yearOfPublication +
                ", condition=" + condition +
                ", storageNum=" + storageNum +
                ", comments=" + comments +
                '}';
    }
}
