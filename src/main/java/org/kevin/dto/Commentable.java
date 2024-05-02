package org.kevin.dto;

import java.util.ArrayList;

public interface Commentable {
    public ArrayList<String> getComments();
    public void comment(String comment);
}
