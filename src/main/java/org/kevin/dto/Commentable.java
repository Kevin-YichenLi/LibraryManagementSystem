package org.kevin.dto;

import java.util.ArrayList;

public interface Commentable {
    ArrayList<String> getComments();
    void comment(String comment);
}
