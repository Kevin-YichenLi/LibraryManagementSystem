package org.kevin.dto;

import java.util.ArrayList;

public class Novel extends LibraryItem{
    String authorName;

    public Novel(String title, Genre genre, int yearOfPublication, Condition condition,
                 int storageNum, ArrayList<String> comments, String authorName) {
        super(title, genre, yearOfPublication, condition, storageNum, comments);
        this.authorName = authorName;
    }

    public Novel() {
        super();
        authorName = null;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

    @Override
    public String toString() {
        return "Novel{" +
                "authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", yearOfPublication=" + yearOfPublication +
                ", condition=" + condition +
                ", storageNum=" + storageNum +
                ", comments=" + comments +
                '}';
    }
}
